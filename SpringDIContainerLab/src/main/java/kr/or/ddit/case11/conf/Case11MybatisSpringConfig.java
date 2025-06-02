package kr.or.ddit.case11.conf;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.mapper.MapperScannerConfigurer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import kr.or.ddit.case10.conf.Case10JdbcConfig;

/**
 * 	Mybatis와 Spring 연동 단계
 * 	1. 스프링 컨테이너에 DataSource를 빈으로 등록: "dataSource"라는 아이디로 등록
 * 	2. SqlSessionFactoryBean을 이용해 SqlSessionFactory를 빈으로 등록
 * 		- dataSource 주입
 * 		- Configuration 파일의 위치(Resource)
 * 		- Mapper 파일의 위치(Resource...)
 * 	3. Mapper 구현체를 직접 구현하는 경우, SqlSessionTemplate을 등록.
 * 	4. MapperScanner 설정 (Mapper proxy를 싱글턴으로 관리하기 위해)
 * 		- basePackage: Mapper INTERFACE 위치
 * 		- 스캔 대상을 선별할 마커 어노테이션 설정 ex)@Mapper, @Repository
 * 
 */
@Configuration
@Import(Case10JdbcConfig.class)
@ComponentScan(basePackages = "kr.or.ddit.case11")
public class Case11MybatisSpringConfig {
	
	@Bean("sqlSessionFactory")
	public SqlSessionFactoryBean sqlSessionFactory(
			@Value("classpath:kr/or/ddit/case11/Configuration.xml")
			Resource configLocation
			, DataSource dataSource
			, @Value("classpath:kr/or/ddit/case11/objs/mapper/**/*.xml")
			Resource...mapperLocations
	) {
		SqlSessionFactoryBean factoryBean =
				new SqlSessionFactoryBean();
		factoryBean.setConfigLocation(configLocation);
		factoryBean.setDataSource(dataSource);
		factoryBean.setMapperLocations(mapperLocations);
		return factoryBean;
	}
	
	@Bean
	public SqlSessionTemplate sqlSession(
			SqlSessionFactory sessionFactory
			) {
		SqlSessionTemplate template =
				new SqlSessionTemplate(sessionFactory);
		return template;
	}
	
	@Bean
	public MapperScannerConfigurer mapperScanner() {
		MapperScannerConfigurer scanner =
				new MapperScannerConfigurer();
		scanner.setBasePackage("kr.or.ddit.case11.objs.mapper");
		scanner.setSqlSessionFactoryBeanName("sqlSessionFactory");
		scanner.setAnnotationClass(Repository.class);
//		scanner.setAnnotationClass(Service.class);
		return scanner;
	}
}
