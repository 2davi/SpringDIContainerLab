package kr.or.ddit.case04.objs.controller;

import org.springframework.context.annotation.Scope;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import jakarta.annotation.Resource;
//import jakarta.inject.Inject;
//import jakarta.inject.Named;
import kr.or.ddit.case04.objs.service.Case04DummyService;
import lombok.extern.slf4j.Slf4j;


@Slf4j
@Controller
@Scope("prototype")
public class Case04DummyController {
	// 가정!!! 부가적인 옵션으로 의존 객체 Service를 주입하려 한다.
	//주입 여부에 따라 주입된 객체를 로그로 출력.
	private Case04DummyService service;

	public Case04DummyController() {
		log.info("▒▒ [{}] Setter Operated...", this.getClass().getSimpleName());
	}
	
//-	@Autowired
//-	@Qualifier("service1")
///	@Inject
///	@Named("service1")
	@Resource(name = "service1")
	public void setService(Case04DummyService service) {
		log.info("=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+ {}", service);
		this.service = service;
	}
	
	@PostConstruct
	public void init() {
		if(service!=null) log.info("▒▒ CALLBACK Injected Service: [{}]", service.getClass().getSimpleName());
	}
	
	@PreDestroy
	public void fuckfuckfuck() {
		log.info("■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■ DESTROY {} ■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■", this.getClass().getSimpleName());
	}
}
