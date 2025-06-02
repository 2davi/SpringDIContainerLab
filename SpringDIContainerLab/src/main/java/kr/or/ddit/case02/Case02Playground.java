package kr.or.ddit.case02;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import kr.or.ddit.case02.conf.Case02DependencyInjectionConfig;
import kr.or.ddit.case02.objs.dao.Case02DAO;
import kr.or.ddit.case02.objs.service.Case02Service;
import lombok.extern.slf4j.Slf4j;

/**
 * 	원래 하려던 것: 똑같은 조건(ex.클래스)의 Bean을 여러개 등록해놓고,
 * 	그것들을 annotation으로 구분해서 써먹으려고 했음.
 * 	근데 버전 달라지면서 쓰려던 어노테이션 다 빠짐 LOL
 */
@Slf4j
/*^0^*/
public class Case02Playground {
	public static void main(String[] args) {
		
		ConfigurableApplicationContext context =
				new AnnotationConfigApplicationContext(Case02DependencyInjectionConfig.class);
		
		///종료를 감지하는 daemon Thread를 생성
		context.registerShutdownHook();
		
		Case02DAO dao = context.getBean("dao1", Case02DAO.class);
		Case02Service service = context.getBean(Case02Service.class);
		log.info("체킁: {}", dao);
		log.info("체크응: {}", service);
	}
}
