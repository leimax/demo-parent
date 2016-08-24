package com.accelerator.demo.common.web.listener;

import javax.servlet.ServletContext;
import javax.servlet.ServletRequest;
import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;

public class BasePathListener implements ServletRequestListener {

    @Override
    public void requestInitialized(ServletRequestEvent sre) {
        ServletRequest request = sre.getServletRequest();
        ServletContext application = sre.getServletContext();
        StringBuilder basePathBuilder = new StringBuilder();
        basePathBuilder.append(request.getScheme());
        basePathBuilder.append("://");
        basePathBuilder.append(request.getServerName());
        basePathBuilder.append(":");
        basePathBuilder.append(request.getServerPort());
        basePathBuilder.append(application.getContextPath());
        basePathBuilder.append("/");
        String basePath = basePathBuilder.toString();
        request.setAttribute("basePath", basePath);
    }

    @Override
    public void requestDestroyed(ServletRequestEvent sre) {}
}