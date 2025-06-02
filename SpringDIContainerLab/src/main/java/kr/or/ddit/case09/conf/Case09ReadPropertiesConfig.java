package kr.or.ddit.case09.conf;

import java.io.IOException;

import org.springframework.beans.factory.FactoryBean;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.config.PropertiesFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.io.Resource;

import kr.or.ddit.case09.objs.DBInfoVO;
import lombok.extern.slf4j.Slf4j;
/**
 * DBInfo.properties 파일을 읽고,
 * 프로퍼티들의 값을 DBInfoVO로 복사.
 * 1. place holder와 Property Source의 활용 ==> Property소스는 빈에 등록이 안된다. 연산자 사용불가. 공백도 하나의 문자로 인식. .도 하나의 문자로만 인식함.
 * 2. spEL 과  Properties 객체의 활용
 */
@Slf4j
@Configuration
@PropertySource("classpath:kr/or/ddit/db/DBInfo.properties")
// property 가져올때 이런 어노테이션 잘 사용하면 됨! Spring의 Enviroment에 프로퍼티 소스들을 넣어준다. 대부분 @Configuration 클래스와 같이 사용된다.
// Resource에서 썼던 파일 가져오는 방식이랑 같음! 동일하게 작성해주면 됨!
public class Case09ReadPropertiesConfig {
	@Bean
	public FactoryBean<String[]> array(){
		return new FactoryBean<String[]>() {
			
			@Override
			public Class<?> getObjectType() {
				// TODO Auto-generated method stub
				return String[].class;
			}
			
			@Override
			public String[] getObject() throws Exception {
				// TODO Auto-generated method stub
				return new String[] {"value1", "value2"};
			}
		};
	}
	
	/**
	 * FactoryBean의 빈 등록 구조
	 *	FactoryBean 이 팩토리 메소드의 반환 타입으로 선언되었더라도,
	 *	실제 등록되는 객체는 factory에서 생성되는 객체(getObject의 리턴객체)가 빈으로 등록됨.
	 * @param location
	 * @return
	 * @throws IOException
	 */
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
	@Bean
	public DBInfoVO dbInfo1(
			@Value("${maindb.driverClassName}")String driverClassName
			,@Value("${maindb.url}")String url
			,@Value("${maindb.username}")String username
			,@Value("${maindb.password}")String password
			,@Value("${maindb.autoCommit}")boolean autoCommit
			,@Value("${maindb.minimumIdle}")int minimumIdle
			,@Value("${maindb.maximumPoolSize}")int maximumPoolSize
			,@Value("${maindb.connectionTimeout}")long connectionTimeout
	) {
		return DBInfoVO.builder()
						.driverClassName(driverClassName)
						.url(url)
						.username(username)
						.password(password)
						.autoCommit(autoCommit)
						.minimumIdle(minimumIdle)
						.maximumPoolSize(maximumPoolSize)
						.connectionTimeout(connectionTimeout)
						.build();
	}
	@Bean
	public DBInfoVO dbInfo2(
			@Value("#{infoProps['maindb.driverClassName']}")String driverClassName
			,@Value("#{infoProps['maindb.url']}")String url
			,@Value("#{infoProps['maindb.username']}")String username
			,@Value("#{infoProps['maindb.password']}")String password
			,@Value("#{infoProps['maindb.autoCommit']}")boolean autoCommit
			,@Value("#{infoProps['maindb.minimumIdle']}")int minimumIdle
			,@Value("#{infoProps['maindb.maximumPoolSize']}")int maximumPoolSize
			,@Value("#{infoProps['maindb.connectionTimeout']}")long connectionTimeout
			) {
		return DBInfoVO.builder()
				.driverClassName(driverClassName)
				.url(url)
				.username(username)
				.password(password)
				.autoCommit(autoCommit)
				.minimumIdle(minimumIdle)
				.maximumPoolSize(maximumPoolSize)
				.connectionTimeout(connectionTimeout)
				.build();
	}
	
	
}
