package kr.or.ddit.case04.objs.service;

import org.springframework.stereotype.Service;

import jakarta.annotation.PostConstruct;
import kr.or.ddit.case04.objs.mapper.Case04DummyMapper;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service("service1")
public class Case04DummyServiceImpl implements Case04DummyService {
	
	// 필수 의존 객체: mapper
	private final Case04DummyMapper mapper;

	//@AutoWired. 생성자에는 이 어노테이션 설정이 기본으로 쓰여서, 생략돼있는 셈.
	public Case04DummyServiceImpl(Case04DummyMapper /*mapper*/daoOracle) {
		super();
		this.mapper = daoOracle;
		log.info("▒▒ [{}] Injection & Constructor Operated...^0^, {}", this.getClass().getSimpleName(), mapper);
	}
	
	// 해당 의존 객체의 주입이 완료된 이후, 주입된 객체를 로그로 출력
	@PostConstruct
	public void init() {
		log.info("▒▒ CALLBACK Injected Mapper: [{}]", mapper.getClass().getName());
	}
}
