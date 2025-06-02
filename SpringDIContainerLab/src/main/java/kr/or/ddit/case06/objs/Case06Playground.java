package kr.or.ddit.case06.objs;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import kr.or.ddit.case06.conf.AdminConfig;
import kr.or.ddit.case06.conf.ParentConfig;
import kr.or.ddit.case06.conf.UserConfig;
import kr.or.ddit.case06.objs.parent.CommonService;
import lombok.extern.slf4j.Slf4j;

//상황가정:: 회원정보 조회용 컨트롤러
@Slf4j
public class Case06Playground {
	@SuppressWarnings({ "resource", "unused" })
	public static void main(String[] args) {
		ConfigurableApplicationContext parent =
				new AnnotationConfigApplicationContext(ParentConfig.class);
		ConfigurableApplicationContext admin =
				new AnnotationConfigApplicationContext(AdminConfig.class);
		ConfigurableApplicationContext user =
				new AnnotationConfigApplicationContext(UserConfig.class);
		
		admin.setParent(parent);
		user.setParent(parent);
		
		ConfigurableApplicationContext xmlChild =
				new ClassPathXmlApplicationContext(
						new String[] {"kr/or/ddit/case06/conf/Case06-Config.xml"}
						, parent);
		
		log.info("주입된 객체: {}", parent.getBean(CommonService.class));
		//부모 컨테이너는 자식 컨테이너의 빈을 주입받을 수 없음.
//		log.info("주입된 객체: {}", parent.getBean(AdminController.class));
		//자식 컨테이너는 부모 컨테이너의 빈을 주입받을 수 있음.
		log.info("주입된 객체: {}", admin.getBean(CommonService.class));
		log.info("주입된 객체: {}", user.getBean(CommonService.class));
		//계층 구조에 속하지 않은 컨테이너의 빈을 주입받을 수 없음.
//		log.info("주입된 객체: {}", user.getBean(AdminController.class));
	}
}
