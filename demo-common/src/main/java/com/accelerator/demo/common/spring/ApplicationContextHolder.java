package com.accelerator.demo.common.spring;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.ApplicationContextException;

public class ApplicationContextHolder implements ApplicationContextAware {

    /** Logger that is available to subclasses */
    protected final Logger logger = LoggerFactory.getLogger(getClass());

    /** ApplicationContext this object runs in */
    private static ApplicationContext applicationContext;

    @Override
    public final void setApplicationContext(ApplicationContext context) throws BeansException {
        if (context == null && !isContextRequired()) {
            // Reset internal context state.
            applicationContext = null;
        } else if (applicationContext == null) {
            // Initialize with passed-in context.
            if (!requiredContextClass().isInstance(context)) {
                throw new ApplicationContextException(
                        "Invalid application context: needs to be of type [" + requiredContextClass().getName() + "]");
            }
            applicationContext = context;
            initApplicationContext(context);
        } else {
            // Ignore reinitialization if same context passed in.
            if (applicationContext != context) {
                throw new ApplicationContextException(
                        "Cannot reinitialize with different application context: current one is [" +
                                applicationContext + "], passed-in one is [" + context + "]");
            }
        }
    }

    /**
     * Determine whether this application object needs to run in an ApplicationContext.
     * <p>Default is "false". Can be overridden to enforce running in a context
     * (i.e. to throw IllegalStateException on accessors if outside a context).
     * @see #getApplicationContext
     */
    protected static boolean isContextRequired() {
        return false;
    }

    /**
     * Determine the context class that any context passed to
     * {@code setApplicationContext} must be an instance of.
     * Can be overridden in subclasses.
     * @see #setApplicationContext
     */
    protected static Class<?> requiredContextClass() {
        return ApplicationContext.class;
    }

    /**
     * Subclasses can override this for custom initialization behavior.
     * Gets called by {@code setApplicationContext} after setting the context instance.
     * <p>Note: Does </i>not</i> get called on reinitialization of the context
     * but rather just on first initialization of this object's context reference.
     * <p>The default implementation calls the overloaded {@link #initApplicationContext()}
     * method without ApplicationContext reference.
     * @param context the containing ApplicationContext
     * @throws ApplicationContextException in case of initialization errors
     * @throws BeansException if thrown by ApplicationContext methods
     * @see #setApplicationContext
     */
    protected void initApplicationContext(ApplicationContext context) throws BeansException {
        initApplicationContext();
    }

    /**
     * Subclasses can override this for custom initialization behavior.
     * <p>The default implementation is empty. Called by
     * {@link #initApplicationContext(org.springframework.context.ApplicationContext)}.
     * @throws ApplicationContextException in case of initialization errors
     * @throws BeansException if thrown by ApplicationContext methods
     * @see #setApplicationContext
     */
    protected void initApplicationContext() throws BeansException {
    }


    /**
     * Return the ApplicationContext that this object is associated with.
     * @throws IllegalStateException if not running in an ApplicationContext
     */
    public static final ApplicationContext getApplicationContext() throws IllegalStateException {
        if (applicationContext == null && isContextRequired()) {
            throw new IllegalStateException(
                    "SpringContextHolder instance does not run in an ApplicationContext");
        }
        return applicationContext;
    }

}
