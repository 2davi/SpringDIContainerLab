package kr.or.ddit.case02.conf;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;

import jakarta.annotation.Resource;
import jakarta.inject.Inject;
import kr.or.ddit.case02.objs.dao.Case02DAO;
import kr.or.ddit.case02.objs.service.Case02Service;

/*^r^*/
public class Case02DependencyInjectionConfig {
	
	@Bean
	public StringBuffer optionBuffer() {
		return new StringBuffer();
	}
	
//	@Bean
//	public StringBuffer otherBuffer() {
//		return new StringBuffer();
//		//service에서 주입받으려는 StringBuffer는 다른 녀석
//		//언제나 주입받으려는 녀석은 유일해야 한다.
//	}
	
	@Bean
	public Case02DAO dao1() {
		Case02DAO dao = new Case02DAO();
		return dao;
	}
	
	@Bean
	public Case02DAO dao2() {
		Case02DAO dao = new Case02DAO();
		return dao;
	}
	
	//이 메소드를 실행하는 주체는 스프링 컨테이너
	@Bean
	public Case02Service service(Case02DAO dao1, StringBuffer optionBuffer) {
		//동일한 클래스의 여러 Bean 중 하나를 특정하기 위해,
		//객체의 이름을 리플렉션하는 과정이 필요했다.
		Case02Service service = new Case02Service(dao1);
		service.setOption(optionBuffer);
		return service;
	}
}
