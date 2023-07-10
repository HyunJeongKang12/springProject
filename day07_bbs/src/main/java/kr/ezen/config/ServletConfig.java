package kr.ezen.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.multipart.MultipartResolver;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

//servlet-context.xml 대체

// 내부적인 동작은 구체적으로 모르지만 사용하기 편리함 : 추상화(PSA)
@Configuration
@EnableWebMvc   //<annotation-driven />
//<context:component-scan, 하위 포함하여 생성, mapper는 component scan 대상 아님
@ComponentScan(basePackages= {"kr.ezen.bbs2", "kr.ezen.controller"}) 
public class ServletConfig implements WebMvcConfigurer {
	
	private final int MAX_SIZE = 10*1024*1024; //10M
	
	// <resources />
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/**").addResourceLocations("/resources/");
	}
	
	//Resolves views : jsp => InternalResourceViewResolver
	@Override
	public void configureViewResolvers(ViewResolverRegistry registry) {
		InternalResourceViewResolver bean = new InternalResourceViewResolver();
		bean.setPrefix("/WEB-INF/views/");
		bean.setSuffix(".jsp");
		registry.viewResolver(bean);
	}
	
	// FileUpload API 설정
	@Bean
	public MultipartResolver multipartResolver() {
		CommonsMultipartResolver multipartResolver = new CommonsMultipartResolver();
		multipartResolver.setMaxUploadSize(MAX_SIZE);
		multipartResolver.setMaxUploadSizePerFile(MAX_SIZE);
		multipartResolver.setMaxInMemorySize(0);  //임시메모리
		
		return multipartResolver;
	}
	
}
