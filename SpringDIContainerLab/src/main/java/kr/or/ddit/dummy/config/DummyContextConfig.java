package kr.or.ddit.dummy.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import kr.or.ddit.dummy.dao.DummyDAOImpl_MariaDB;
import kr.or.ddit.dummy.dao.DummyDAOImpl_Oracle;
import kr.or.ddit.dummy.service.DummyServiceCase1;

/*^0^*/
//@Configuration
//@ComponentScan(basePackages = "kr.or.ddit.dummy", lazyInit = false)
public class DummyContextConfig {
//	
//	//객체를 하나 등록했다. 메소드 하나를 선언하면서 객체를 반환.
//	//@Bean Annotation을 사용하는 것이 등록 요건.
//	@Bean
//	public DummyDAOImpl_Oracle dao() {
//		return new DummyDAOImpl_Oracle();
//	}
//	
//	@Bean
//	public DummyDAOImpl_MariaDB daoMariaDB() {
//		return new DummyDAOImpl_MariaDB();
//	}
//	
//	//이제 두 개^0^
//	@Bean
//	public DummyServiceCase1 service() {
//		DummyServiceCase1 service = new DummyServiceCase1();
//		service.setDao(daoMariaDB());
//		return service;
//	}
}
