package kr.ezen.config;


import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

//root-context.xml 대체

@Configuration
@MapperScan(basePackages= {"kr.ezen.bbs2.mapper"})  //mybatis가 수행
@PropertySource({"classpath:/db.properties"})
@ComponentScan(basePackages = {"kr.ezen.service"})  //service, 해당 repository만든다
public class RootConfig {
	
	//properties 정보 가져오기 위해 필요
	@Autowired
	private Environment env;
	
	//resourece 정보 가져오기 위해 필요
	@Autowired
	ApplicationContext ac;   //spring container
	
	//bean : spring container에서 관리하는 객체
	@Bean
	public DataSource hkSource() {
		HikariConfig hcf = new HikariConfig();
//		hcf.setDriverClassName("com.mysql.cj.jdbc.Driver");  //값 직접 설정
//		hcf.setJdbcUrl("jdbc:mysql://localhost:3307/testdb");
//		hcf.setUsername("hjkang");
//		hcf.setPassword("1234");
		
		hcf.setDriverClassName(env.getProperty("jdbc-driver"));  //설정 파일 읽어오기
		hcf.setJdbcUrl(env.getProperty("jdbc-url"));
		hcf.setUsername(env.getProperty("jdbc-username"));
		hcf.setPassword(env.getProperty("jdbc-password"));
		
		HikariDataSource hkds = new HikariDataSource(hcf);
		
		return hkds;
	}
	
	@Bean
	public SqlSessionFactory sessionFactory() throws Exception {
		SqlSessionFactoryBean sfb = new SqlSessionFactoryBean();
		sfb.setDataSource(hkSource());
		sfb.setConfigLocation(ac.getResource("classpath:/config.xml")); 
		//xml파일 interface 위치로 이동 시 설정 불필요
		//sfb.setMapperLocations(ac.getResources("classpath:/mybatis/*.xml"));  
		return (SqlSessionFactory) sfb.getObject();
	}

}
