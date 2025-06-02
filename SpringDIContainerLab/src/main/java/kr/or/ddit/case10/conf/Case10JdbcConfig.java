package kr.or.ddit.case10.conf;

import java.io.IOException;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.config.PropertiesFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.io.Resource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import com.zaxxer.hikari.HikariDataSource;


/**
 * javax.sql.DataSource
 * JdbcTemplate
 * NamedParameterJdbcTemplate
 */
@Configuration
@PropertySource("classpath:kr/or/ddit/db/DBInfo.properties")
public class Case10JdbcConfig {
	
	@Bean("infoProps")
	public PropertiesFactoryBean dbInfoProp(
			@Value("classpath:kr/or/ddit/db/DBInfo.properties")Resource location
		) throws IOException { // 호출자가 이걸 가져감. 즉 스프링컨테이너가 가져가게됨. 웹어플리케이션이면 스프링의 톰캣에 던져줌. 어지간해서 try/catch잘 안함.
		// 단 예외를 전환할때는 try/catch사용.
		PropertiesFactoryBean factoryBean =
				new PropertiesFactoryBean();
		factoryBean.setLocation(location);
		return factoryBean; // 자기 자신은 노출시키지않고 내부에 있는 Object를 노출시키기 때문에 안에 있는 Properties를 반환함.
//		return factoryBean.getObject();
	}
	
	@Bean("dataSource")// dataSource 라는 아이디로 빈을 등록함. 반드시.
	public DataSource dataSource(
			@Value("#{infoProps['maindb.driverClassName']}")String driverClassName
			,@Value("#{infoProps['maindb.url']}")String url
			,@Value("#{infoProps['maindb.username']}")String username
			,@Value("#{infoProps['maindb.password']}")String password
			,@Value("#{infoProps['maindb.autoCommit']}")boolean autoCommit
			,@Value("#{infoProps['maindb.minimumIdle']}")int minimumIdle
			,@Value("#{infoProps['maindb.maximumPoolSize']}")int maximumPoolSize
			,@Value("#{infoProps['maindb.connectionTimeout']}")long connectionTimeout
		) {
		HikariDataSource ds = new HikariDataSource();
		ds.setDriverClassName(driverClassName);
		ds.setJdbcUrl(url);
		ds.setUsername(username);
		ds.setPassword(password);
		ds.setAutoCommit(autoCommit);
		ds.setMinimumIdle(minimumIdle); 
		ds.setMaximumPoolSize(maximumPoolSize); 
		ds.setConnectionTimeout(connectionTimeout);
		return ds;
	}
	
	@Bean
	public JdbcTemplate jdbcTemplate(DataSource dataSource) {
		return new JdbcTemplate(dataSource);
	}
	
	@Bean
	public NamedParameterJdbcTemplate npjt(DataSource dataSource) {
		return new NamedParameterJdbcTemplate(dataSource);
	}
}
