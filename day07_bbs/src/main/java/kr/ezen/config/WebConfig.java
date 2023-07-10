package kr.ezen.config;

import javax.servlet.Filter;

import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

//web.xml 대체

public class WebConfig extends AbstractAnnotationConfigDispatcherServletInitializer{

	@Override
	protected Class<?>[] getRootConfigClasses() { //root-context.xml
		return new Class[] {RootConfig.class};
	}

	@Override
	protected Class<?>[] getServletConfigClasses() {//servlet-context.xml
		return new Class[] {ServletConfig.class};
	}

	@Override
	protected String[] getServletMappings() {//Dispatcher servlet url patten mapping
		return new String[] {"/"};
	}
	
	@Override
	protected Filter[] getServletFilters() { //filter:utf-8
		CharacterEncodingFilter ef = new CharacterEncodingFilter();
		ef.setEncoding("UTF-8");
		ef.setForceEncoding(true);
		return new Filter[] {ef};
	}
	
	
}
