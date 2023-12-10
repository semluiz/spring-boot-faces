package com.auth0.samples.bootfaces;

import org.ocpsoft.rewrite.servlet.RewriteFilter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

import java.util.EnumSet;

import javax.faces.webapp.FacesServlet;
import javax.servlet.DispatcherType;

@EnableAutoConfiguration
@ComponentScan({"com.auth0.samples.bootfaces"})
@EntityScan(basePackages = "entity")
public class Application extends SpringBootServletInitializer {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Bean
	public ServletRegistrationBean servletRegistrationBean(){
		FacesServlet servlet = new FacesServlet();
		return new ServletRegistrationBean(servlet, "*.jsf");
	}

	@Bean
	public FilterRegistrationBean rewriteFilter(){
		FilterRegistrationBean  filter =  new FilterRegistrationBean(new RewriteFilter());
		filter.setDispatcherTypes(EnumSet.of(DispatcherType.FORWARD, DispatcherType.REQUEST, DispatcherType.ASYNC, DispatcherType.ERROR));
		filter.addUrlPatterns("/*");
		return filter;
	}
}
