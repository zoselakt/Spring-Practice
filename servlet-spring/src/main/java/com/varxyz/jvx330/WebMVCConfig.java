package com.varxyz.jvx330;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@EnableWebMvc		//	스프링 MVC 설정에 대한 개본 구성 제공 
@ComponentScan(basePackages = "com.varxyz.jvx330.banking")
public class WebMVCConfig implements WebMvcConfigurer{
	
	
	/**
	 * DispatcherServlet의 매핑 경로를 "/"로 주었을때, JSP/HTML/CSS 등을 바로 처리하도록 한다 
	 * <mvc:default-servlet-handler>
	 */
	
	@Override
	public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
		configurer.enable();
	}
	
	/**
	 * 	컨트롤러의 처리 결과를 jsp로 표시하기 위한 설정 
	 */
	@Override
	public void configureViewResolvers(ViewResolverRegistry registry) {
		registry.jsp("/WEB-INF/views/", ".jsp");
	}
	
	/**
	 * src/main/webapp/resources 위치의 정적 리소스를 설정 
	 */
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry  registry) {
		registry.addResourceHandler("/resources/**").addResourceLocations("/resources/");
	}
}
