package kr.or.ddit.case05;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import kr.or.ddit.case05.objs.Case05Controller;
import lombok.extern.slf4j.Slf4j;

/**
 * 	XML을 사용할 땐, Annotaion과 관련된 기본 초기셋팅이 수동으로 이루어짐.
 * 
 */
@Slf4j
public class Case05Playground {
	public static void main(String[] args) {
		ConfigurableApplicationContext context =
//				new ClassPathXmlApplicationContext("kr/or/ddit/case05/conf/Case05-Context.xml");
				new GenericXmlApplicationContext("classpath:kr/or/ddit/case05/conf/Case05-Context.xml");
		context.registerShutdownHook();
		
		
//		//등록된 빈의 개수
//		log.info("■■■■■■■^0^)ㅗ■■■■■■■ COUNT: {}", context.getBeanDefinitionCount());
//		//등록된 모든 빈의 id
//		String str = "";
//		for(String name: context.getBeanDefinitionNames()) {
//			Object bean = context.getBean(name);
//			str += "["+name +"] : ["+bean+"] _";
//		}
//		log.info("■■■■■■■ㅗ(^0^■■■■■■■ NAMES: {}", str);
	}
}
