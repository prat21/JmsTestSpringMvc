package com.jms.spring.config;

import java.util.List;

import javax.jms.ConnectionFactory;
import javax.naming.NamingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.jms.config.DefaultJmsListenerContainerFactory;
import org.springframework.jndi.JndiTemplate;
import org.springframework.validation.MessageCodesResolver;
import org.springframework.validation.Validator;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.HandlerMethodReturnValueHandler;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.AsyncSupportConfigurer;
import org.springframework.web.servlet.config.annotation.ContentNegotiationConfigurer;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.PathMatchConfigurer;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

import com.jms.spring.endpoint.MessageReceiver;

@Configuration
@EnableWebMvc
@EnableJms
@ComponentScan("com.jms.spring")
public class AppConfig implements WebMvcConfigurer {	
	
	@Autowired
    MessageReceiver messageReceiver;
	
	@Bean
	public ViewResolver viewResolver() {
		InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
		viewResolver.setViewClass(JstlView.class);
		viewResolver.setPrefix("/WEB-INF/jsp/");
		viewResolver.setSuffix(".jsp");
		
		return viewResolver;
	}
	
	
	public void addViewControllers(ViewControllerRegistry registry) {
		registry.addViewController("/home").setViewName("home");
	}
	
	@Bean
	public ConnectionFactory connectionFactory() throws NamingException  {
        return new JndiTemplate().lookup("myConnectionFactory",ConnectionFactory.class);
    }
	
	@Bean
	public DefaultJmsListenerContainerFactory myJmsListenerContainerFactory() throws NamingException{
		DefaultJmsListenerContainerFactory factory = new DefaultJmsListenerContainerFactory();
		factory.setConnectionFactory(connectionFactory());
		return factory;
	}
	
	/*Unimplemented methods- due to usage of older version of spring (WebMvcConfigurer)*/


	@Override
	public void addArgumentResolvers(List<HandlerMethodArgumentResolver> arg0) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void addFormatters(FormatterRegistry arg0) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void addInterceptors(InterceptorRegistry arg0) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void addResourceHandlers(ResourceHandlerRegistry arg0) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void addReturnValueHandlers(List<HandlerMethodReturnValueHandler> arg0) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void configureAsyncSupport(AsyncSupportConfigurer arg0) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void configureContentNegotiation(ContentNegotiationConfigurer arg0) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void configureDefaultServletHandling(DefaultServletHandlerConfigurer arg0) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void configureHandlerExceptionResolvers(List<HandlerExceptionResolver> arg0) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void configureMessageConverters(List<HttpMessageConverter<?>> arg0) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void configurePathMatch(PathMatchConfigurer arg0) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void configureViewResolvers(ViewResolverRegistry arg0) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void extendMessageConverters(List<HttpMessageConverter<?>> arg0) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public MessageCodesResolver getMessageCodesResolver() {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public Validator getValidator() {
		// TODO Auto-generated method stub
		return null;
	}

	
	
	
}
