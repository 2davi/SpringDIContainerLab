package kr.or.ddit.case03.conf;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Lazy;
//import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.Scope;

import kr.or.ddit.case03.objs.EagerDummy;
import kr.or.ddit.case03.objs.EagerSingletonDummy;
import kr.or.ddit.case03.objs.LazyDummy;
import kr.or.ddit.case03.objs.LazyPrototypeDummy;
import lombok.extern.slf4j.Slf4j;

/**
 * 	스프링 컨테이너의 빈 관리 특성
 * 	1. 싱글턴 scope를 기본으로 사용함.
 * 		*Design Pattern (singleton): 어플리게이션을 통틀어 Heap 메모리 상에
 * 									 특정 클래스의 인스턴스가 하나만 로딩 되는 구조.
 * 		: 싱글턴 스코프의 대상을 등록된 빈을 기준으로 측정함.
 * 		@Scope 어노테이션으로 기본 설정을 변경할 수 있음.
 * 			   +)singleton(default): 미리 객체를 생성하고, 주입할 때마다 동일한 객체 참조
 * 			   +)prototype: 객체의 생성 시점을 뒤로 미루고(주입 직전으로), 주입할 때마다 새로운 객체 생성
 * 			   +)request: WA의 `요청 객체`와 동일한 생명주기를 갖는 빈. 요청이 들어오면서 생성되고 응답이 나가면서 소멸
 * 			   +)session: `세션 객체`와 동일한 생명주기를 갖는 빈. 세션ID가 생성될 때 생성되고 세션소멸과 함께 소멸(쿠키제거,브라우저종료,타임아웃(기본30분),로그아웃)
 * 			   +)application: `ServletContext`와 동일한 생명주기를 갖는 빈. 서버가 구동될 때 생성되고 서버 다운과 함께 소멸 
 * 	
 * 	2. 구체적인 설정이 없으면, eager-loading 방식으로 객체를 미리 생성함.
 * --사용하지 않을지도 모를 객체까지 미리 생성하는 건 그다지 효율적이지 못함.
 * 		@Lazy  객체가 주입되기 직전까지 생성이 지연됨.(scope의 prototype이 lazy설정을 포함하고 있는 셈)
 * 	
 * 	//@Bean() 안에는 콜백메소드가 존재 (initMethod, destroyMethod) 생성자(의존객체 주입) 호출 이후에 실행됨.
 * --내가 호출하는 게 아니야. 어떤 조건을 만족했을 때 시스템 내부에서 자체로 실행됨.
 * 	3. 관리 대상 객체의 생명주기 콜백 메소드 실행.
 * 		 initMethod(***) :1)객체가 생성되고, 2)모든 의존성 주입이 완료된 후에 실행됨.
 * 						 :주로, 주입된 객체를 대상으로 추가 처리가 필요할 때 활용.
 * 						 :WebApplication에서 많이 사용됨.
 * 		 destroyMethod :객체 소멸 직전에 실행됨.
 * 					   :singleton-SCOPE-->스프링컨테이너 종료 시 같이 소멸
 * 					   :prototype-SCOPE-->null-reference 할당으로 더이상 사용되지 않는 경우에 소멸.
 * 
					sb1 = null; //변수 sb1에 참조했던 주소를 지워버림! ^0^::Null-Reference
 */
@Slf4j
/** 컨테이너 전체를 LAZY로 만듦 */
@Lazy
public class Case03ContainerBeanManagementPolicyConfig {

//	@Bean
//	@Lazy
////	@Scope("request")
//	public StringBuffer sb1() {
//		log.info("sb1 팩토리 메소드 실행");
//		return new StringBuffer();
//	}
	
//	@Bean
//	public StringBuffer sb2() {
//		log.info("sb2 팩토리 메소드 실행");
//		return new StringBuffer();
//	}
	
	/** 아래 두 어노테이션은 서로 상반되는 설정.
	 * 	prototype이 Lazy(false)를 씹어먹음^0^
	 */
	@Bean(initMethod = "start", destroyMethod = /*"expire"*/"awqeoihfd")
	@Scope("prototype")
	@Lazy(false)
	public EagerDummy ed(EagerSingletonDummy esd) {
		EagerDummy ed = new EagerDummy();
		ed.setEsd(esd);
		log.info("EagerDummy 팩토리 메소드 실행");
		return ed;
	}
	
	@Bean
	@Scope("singleton")
	@Lazy(false) //<--일일이 false 처리도 가능
	public EagerSingletonDummy esd() {
		log.info("EagerSingletonDummy 팩토리 메소드 실행");
		return new EagerSingletonDummy();
	}
	
	@Bean
	@Lazy
	public LazyDummy ld() {
		log.info("LazyDummy 팩토리 메소드 실행");
		return new LazyDummy();
	}
	
	@Bean
	@Scope("prototype")
	public LazyPrototypeDummy lpd() {
		log.info("LazyPrototypeDummy 팩토리 메소드 실행");
		return new LazyPrototypeDummy();
	}
}
