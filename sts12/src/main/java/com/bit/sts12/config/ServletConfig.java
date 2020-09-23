package com.bit.sts12.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

//<annotation-driven />
@EnableWebMvc
//<context:component-scan base-package="com.bit.sts12" />
@ComponentScan("com.bit.sts12")
public class ServletConfig implements WebMvcConfigurer {

//	<beans:bean id="viewResolver" 
//		class="org.springframework.web.servlet.view.InternalResourceViewResolver">
//	<beans:property name="prefix" value="/WEB-INF/views/" />
//	<beans:property name="suffix" value=".jsp" />
//	</beans:bean>
	@Override
	public void configureViewResolvers(ViewResolverRegistry registry) {
		InternalResourceViewResolver viewResolver=null;
		viewResolver=new InternalResourceViewResolver();
		viewResolver.setPrefix("/WEB-INF/views/");
		viewResolver.setSuffix(".jsp");
		registry.viewResolver(viewResolver);
	}
	
//	<resources mapping="/resources/**" location="/resources/" />
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/resources/**")
				.addResourceLocations("/resources/");
	}
}










