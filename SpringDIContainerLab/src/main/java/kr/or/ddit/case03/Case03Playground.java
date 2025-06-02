package kr.or.ddit.case03;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import kr.or.ddit.case03.conf.Case03ContainerBeanManagementPolicyConfig;
import kr.or.ddit.case03.objs.EagerDummy;
import kr.or.ddit.case03.objs.EagerSingletonDummy;
import kr.or.ddit.case03.objs.LazyDummy;
import kr.or.ddit.case03.objs.LazyPrototypeDummy;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Case03Playground {
	public static void main(String[] args) {
		
		@SuppressWarnings("resource")
		ConfigurableApplicationContext context =
				new AnnotationConfigApplicationContext(Case03ContainerBeanManagementPolicyConfig.class);
		context.registerShutdownHook();
		
//		StringBuffer sb1 = context.getBean("sb1", StringBuffer.class);
//		StringBuffer sb2 = context.getBean("sb1", StringBuffer.class);
//		sb1 = null; //변수 sb1에 참조했던 주소를 지워버림! ^0^::Null-Reference
		
		//싱글턴이긴 한데, 착각해서는 안돼
		//스프링에서의 싱글턴은 우리가 알던 디자인패턴에서의 싱글턴과 좀 달라.
		//-->Config.java로!
//		log.info("[A == B] : {}", (sb1==sb2));
		
		log.info("■□■□■□■□■□■□■□■□■□■□■□■□■□■□■□■□■");
//		EagerDummy ed = context.getBean(EagerDummy.class);
//		EagerSingletonDummy esd = context.getBean(EagerSingletonDummy.class);
//		LazyDummy ld = context.getBean(LazyDummy.class);
//		LazyPrototypeDummy lpd = context.getBean(LazyPrototypeDummy.class);
//		
		
	}
}
