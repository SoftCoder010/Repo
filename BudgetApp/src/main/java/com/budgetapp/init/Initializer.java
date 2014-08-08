package com.budgetapp.init;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.filter.HiddenHttpMethodFilter;
import org.springframework.web.servlet.DispatcherServlet;

import javax.servlet.*;
import java.util.EnumSet;

/**
 * Created by lapostol on 7/31/2014.
 */
public class Initializer implements WebApplicationInitializer {

    private static final String  DISPATCHER_SERVLET_NAME = "dispatcher";

    @Override
    public void onStartup(ServletContext servletContext) throws ServletException {
        AnnotationConfigWebApplicationContext ctx = new AnnotationConfigWebApplicationContext();
        ctx.register(WebAppConfig.class);

        ctx.setServletContext(servletContext);

        registerHiddenHttpMethodFilter(servletContext);

        ServletRegistration.Dynamic servlet = servletContext.addServlet(DISPATCHER_SERVLET_NAME, new DispatcherServlet(ctx));
        servlet.addMapping("/");
        servlet.setLoadOnStartup(1);
    }

    private void registerHiddenHttpMethodFilter(ServletContext servletContext){
        FilterRegistration.Dynamic fr = servletContext
                .addFilter("hiddenHttpMethodFilter", HiddenHttpMethodFilter.class);
        fr.addMappingForServletNames(
                EnumSet.of(DispatcherType.REQUEST, DispatcherType.FORWARD),
                false,
                DISPATCHER_SERVLET_NAME);

    }
}
