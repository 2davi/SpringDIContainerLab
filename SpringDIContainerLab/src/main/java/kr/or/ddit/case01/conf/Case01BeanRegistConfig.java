package kr.or.ddit.case01.conf;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import kr.or.ddit.case01.objs.Bar;
import kr.or.ddit.case01.objs.Baz;
import kr.or.ddit.case01.objs.Foo;

/**
 * 	Spring DI Container(Bean Container) 사용 단계
 * 	 Bean: 컨테이너 내부에서 관리되는 객체
 * 	1. 사용할 객체에 대한 모델링 작업(obj패키지에 config 클래스를 만듦)
 * 		의존성 주입 방법에 대한 설계 필수.
 * 		- constructor injection::필수의존객체에 대해 사용
 * 		- setter injection
 * 	
 * 	2. Core Container를 사용할 수 있는 Maven Dependency 추가(pom.xml)
 * 	3. 컨테이너의 설정 파일 역할을 하는 config 클래스 정의
 * 		- FactoryMethod() 정의: 객체를 생성하고 반환하는 메소드
 * 		- @Bean(SingleValueAnnotation) 등록
 * 		Bean name을 생략한 경우, 메소드명이 객체 이름으로 반영됨.
 * 	4.*어플리케이션의 엔트리포인트에서 컨테이너객체를 생성함.(stand-alone에서는 main())
 * 		ApplicationContext의 구현체  선택 =(ConfigurableApplicationContext)
 * 	5. 필요객체를 컨테이너로부터 주입. :getBean(빈 검색조건-Class<T> or String)
 */
@Configuration
public class Case01BeanRegistConfig {
	
	@Bean
	public Bar barMerong() {
		return new Bar();
	}
	
	@Bean("barzChk")
	public Baz baz() {
		return new Baz();
	}
	
	//1.Foo 등록
	//2.의존객체
	//3.Foo주입 결과를 log로 출력.
	@Bean("fooDummy")
	public Foo foo() {
//		ConfigurableApplicationContext context =
//				new AnnotationConfigApplicationContext(Case01BeanRegistConfig.class);
		Foo foo = new Foo(/* context.getBean(Bar.class) */ barMerong());
		foo.setBaz(baz());
		return foo;
	}
	
	@Bean
	public Foo fooOther() {
		Foo foo = new Foo(barMerong());
		foo.setBaz(baz());
		return foo;
	}
}
