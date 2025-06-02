package kr.or.ddit.dummy.controller;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import kr.or.ddit.dummy.config.DummyContextConfig;
import kr.or.ddit.dummy.service.DummyServiceCase1;
import lombok.extern.slf4j.Slf4j;

@Slf4j		//전략의 주입자가 된 컨트롤러
public class DummyController {
	
	public static void main(String[] args) {
//		DummyServiceCase1 service = new DummyServiceCase1();
//		DummyDAO dao = new DummyDAOImpl_MariaDB();
//		service.setDao(dao);
		
		ApplicationContext context = new AnnotationConfigApplicationContext("kr.or.ddit.dummy");
		//context 안에는 저장소가 들어있다고 생각하자.
		//Spring Container = Bean Container = DI Container
		DummyServiceCase1 service = context.getBean(DummyServiceCase1.class);
		StringBuffer information = service.readDummy("primary");
		log.info("■□■ 만들어진 요리: \n{}", information);
		
	}
}
