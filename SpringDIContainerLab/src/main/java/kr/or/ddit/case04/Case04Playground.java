package kr.or.ddit.case04;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import kr.or.ddit.case04.objs.controller.Case04DummyController;
import kr.or.ddit.case04.objs.mapper.Case04DummyMapper;
import kr.or.ddit.case04.objs.service.Case04DummyService;
import kr.or.ddit.case04.objs.service.Case04DummyServiceImpl;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Case04Playground {
	@SuppressWarnings("unused")
	public static void main(String[] args) {
		// 컨테이너 객체 생성
		// 등록된 모든 빈을 주입받고 로그로 출력.
		
		log.info("▒▒ main Method Operated...^0^");
		
		@SuppressWarnings("resource")
		ConfigurableApplicationContext context =
//				new AnnotationConfigApplicationContext(Case04ComponentScanConfig.class);
				new AnnotationConfigApplicationContext("kr.or.ddit.case04.conf");
		context.registerShutdownHook();
		
//		Case04DummyMapper mapper = context.getBean(Case04DummyMapper.class);
//		Case04DummyService service = context.getBean(Case04DummyService.class);
		Case04DummyController controller = context.getBean(Case04DummyController.class);
		
	}
}
