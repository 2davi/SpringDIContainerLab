package kr.or.ddit.case04.conf;

//import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScan.Filter;
import org.springframework.context.annotation.Configuration;
//import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.FilterType;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;

//import kr.or.ddit.case04.objs.controller.Case04DummyController;
//import kr.or.ddit.case04.objs.mapper.Case04DummyMapper;
//import kr.or.ddit.case04.objs.mapper.Case04DummyMapperImpl_Oracle;
//import kr.or.ddit.case04.objs.service.Case04DummyService;
//import kr.or.ddit.case04.objs.service.Case04DummyServiceImpl;
import lombok.extern.slf4j.Slf4j;

/**	
 * 	어플리케이션의 볼륨이 커지면,
 *  특정 패키지에 있으면서(*) 일정 조건에 맞는(*) 클래스를
 *  자동으로 Bean 등록할 방법이 필요.
 *  
 *  이 어노테이션 중 하나를 사용하면 컨테이너가 알아서 빈으로 등록해줌.
 *  하지만 컨테이너 뿐 아니라 개발자도 읽지 않낭
 *  기능은 똑같지만 개발 가독성을 위해 분류해놓은 셈.
 *  @Component: 나머지 떨거지들을 Bean에 등록할 때 사용.
 *  @Repository: Persistence Layer를 Bean에 등록할 때 사용.
 *  @Service: 비지니스로직을 담당하는 클래스를 Bean에 등록할 때 사용.
 *  @Controller: 컨트롤러 Layer를 Bean에 등록할 때 사용.
 *  @Configuration: 설정 파일 역할을 하는 클래스에 사용.
 * 	
 *  @ComponentScan(basePackages="<PACKAGENAME>", lazyInit="<BOOLEAN>")
 *  
 *  (1) @Primary (2) @Qualifier (3) 생성자 내의 매개변수명으로 Reflection
 *  
 *  Bean들간의 의존관계 형성.
 *  @AutoWired: 1st.타입으로 검색하고 주입. 2nd.Reflection (ParameterName | VariableName)
 *  @Qualifier("BeanID"): 구체적인 아이디를 기준으로 검색하고 주입. 
 *  └─생성자에는 기본적으로 생략. setter메소드에 붙이면 자동 주입됨.
 *  (set1) @Autowired & @Qualifier("service1")
 *  (set2) @Inject & @Named("service1")
 *  (set3) @Resource(name="service1") <<-속성들의 조합으로 주입할 Bean을 검색
 *  
 *  @Value: 문자열이나 숫자와 같은 리터럴(값)을 이용해 주입받을 때 사용됨.
 *  
 *  등록된 빈의 생명주기 콜백 결정.
 *     init method =+> @PostConstruct: 생성자 실행 이후 모든 주입이 완료된 뒤.
 *  destroy method =+> @PreDestroy: Scope에 따라 실행 시점이 다름.
 *  
 */
@Configuration //<--Marker Annotation을 기반으로 Scanning을 수행한다.
@ComponentScan(basePackages = "kr.or.ddit.case04.objs"//(*)특정패키지에있으면서
			   , lazyInit = false
			   , useDefaultFilters = /*false*/true
//			   , includeFilters = {
//				@Filter(type = FilterType.ANNOTATION, classes = Component.class)
//			   }
			   , excludeFilters = {
				@Filter(type = FilterType.ANNOTATION, classes = Controller.class)
			   })
@Slf4j
//@Lazy
public class Case04ComponentScanConfig {
	// 필요한 모든 객체를 빈으로 등록
	// 의존성 주입을 통해 빈들 간의 의존관계 형성
	
//	///mapper는 구현체로 등록을 했다.
//	@Bean
//	public Case04DummyMapperImpl_Oracle mapperOracle() {
//		log.info("▒▒ Mapper Injection Operated...TㅂT");
//		return new Case04DummyMapperImpl_Oracle();
//	}
//	
//	///service의 필수 의존객체는 인터페이스로 한다.
//	///인터페이스로 등록된 mapper는 없을 테지만,
//	///스프링 컨테이너는 이후 그 자식 구현체들을 찾아다녀서 구해 꽂는다.
//	@Bean(initMethod = "init")
//	public Case04DummyService service(Case04DummyMapper mapper) {
//		log.info("▒▒ Service Injection Operated...TㅂT");
//		Case04DummyService service = new Case04DummyServiceImpl(mapper);
//		return service;
//	}
//	
//	@Bean(initMethod = "init") <<<@PostConstruct
//	public Case04DummyController controller(Case04DummyService service) {
//		log.info("▒▒ Controller Injection Operated...TㅂT");
//		Case04DummyController controller = new Case04DummyController();
//		controller.setService(service);
//		return controller;
//	}
}
