package com.jms.spring.config;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

public class MyWebAppInitializer implements WebApplicationInitializer {

	public void onStartup(ServletContext context) throws ServletException {
		AnnotationConfigWebApplicationContext ctx = new AnnotationConfigWebApplicationContext();
		ctx.register(AppConfig.class);
		ctx.setServletContext(context);
		
		ServletRegistration.Dynamic register = context.addServlet("dispatcher", new DispatcherServlet(ctx));
		register.setLoadOnStartup(1);
		register.addMapping("/");
		
	}
}
