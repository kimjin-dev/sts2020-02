package com.bit.sts12.config;

import javax.servlet.Filter;

import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.filter.HiddenHttpMethodFilter;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;
// web.xml
public class WebConfig extends AbstractAnnotationConfigDispatcherServletInitializer {
//<context-param>
//	<param-name>contextConfigLocation</param-name>
//	<param-value>/WEB-INF/spring/root-context.xml</param-value>
//</context-param>
//
//<listener>
//	<listener-class>org.springframework.web.context.ContextLoaderListener</listener-class>
//</listener>
	@Override
	protected Class<?>[] getRootConfigClasses() {
		return new Class[] {RootConfig.class};
	}

//<servlet>
//	<servlet-name>appServlet</servlet-name>
//	<servlet-class>org.springframework.web.servlet.DispatcherServlet</servlet-class>
//	<init-param>
//		<param-name>contextConfigLocation</param-name>
//		<param-value>/WEB-INF/spring/appServlet/servlet-context.xml</param-value>
//	</init-param>
//	<load-on-startup>1</load-on-startup>
//</servlet>
	@Override
	protected Class<?>[] getServletConfigClasses() {
		return new Class[] { ServletConfig.class};
	}

//<servlet-mapping>
//	<servlet-name>appServlet</servlet-name>
//	<url-pattern>/</url-pattern>
//</servlet-mapping>
	@Override
	protected String[] getServletMappings() {
		return new String[] {"/"};
	}

	@Override
	protected Filter[] getServletFilters() {
		return new Filter[] {new CharacterEncodingFilter("utf-8"),new HiddenHttpMethodFilter()};
	}
}

