package com.uplooking.crowdfunding.controller.listener;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class listener implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        ServletContext context = sce.getServletContext();
        String path = context.getContextPath();
        context.setAttribute("APP_PATH",path);
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {

    }
}
