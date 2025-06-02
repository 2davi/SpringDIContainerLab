package kr.or.ddit.case01;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import kr.or.ddit.case01.conf.Case01BeanRegistConfig;
import kr.or.ddit.case01.objs.Bar;
import kr.or.ddit.case01.objs.Baz;
import kr.or.ddit.case01.objs.Foo;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Case01Playground {
	public static void main(String[] args) {
		ConfigurableApplicationContext context =
				new AnnotationConfigApplicationContext(Case01BeanRegistConfig.class);
		//로그를 확인해보자.
		//어플리케이션이 실행되면, 컨테이너가 자동으로 Config 파일을 실행한다.
		//@Bean 객체 등록이 되어있는 경우 자동으로 생성해준다.
		//14:34:41.210 [main] INFO  k.o.d.d.c.o.Bar -- ■□■ Bar 객체 생성
		//14:34:41.212 [main] INFO  k.o.d.d.c.o.Baz -- ■□■ Baz 객체 생성
		
		Bar bar1 = context.getBean(Bar.class);
		Baz baz1 = context.getBean(Baz.class);
		Bar bar2 = context.getBean(Bar.class);
		Baz baz2 = context.getBean(Baz.class);
		log.info("bar1: {}", bar1);
		log.info("bar2: {}", bar2);
		log.info("baz1: {}", baz1);
		log.info("baz2: {}", baz2);
		//해시코드를 보면 알겠지만, 객체는 하나만 생성됨 ==> Singleton으로 관리되는 구나!
		
		Integer count = context.getBeanDefinitionCount();
		log.info("count: {}", count);
		//컨테이너의 구동을 위해 필요한 여러 객체가 존재.
		//우리가 모르는 녀석들이 물밑에서 실행되고 있다.
		
		String[] names = context.getBeanDefinitionNames();
		for(String name: names) {
			log.info("bean name: {}", name);
		}
		//FactoryMethod()명은 등록된 Bean객체의 이름으로 반영된다.
		
//		Foo foo = context.getBean(Foo.class);
//		Foo타입 객체가 두 개 등록되어있기 때문에 class<T>로는 식별할 수 없다.
		Foo foo = context.getBean("fooDummy", Foo.class);
		log.info("주입된 객체 foo: {}", foo);
	}
}
