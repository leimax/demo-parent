package com.accelerator.demo.struts.web.interceptor;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component("testInterceptor")
public class TestInterceptor extends AbstractInterceptor {

    private static final long serialVersionUID = 1363222964715122353L;

    protected final Logger logger = LoggerFactory.getLogger(getClass());

    @Override
    public String intercept(ActionInvocation invocation) throws Exception {
        logger.info("拦截器已拦截！");
        return invocation.invoke();
    }

}
