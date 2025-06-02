package kr.or.ddit.case04.objs.mapper;

import org.springframework.stereotype.Repository;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Repository("daoOracle")
public class Case04DummyMapperImpl_Oracle implements Case04DummyMapper {

	public Case04DummyMapperImpl_Oracle() {
		log.info("▒▒ [{}] Constructor Operated...^0^", this.getClass().getSimpleName());
	}
	//제일 먼저 해야할 일은, 해당 클래스에 필요한 `필수 의존 객체`를 주입.
	//해당 의존 객체의 주입이 완료된 이후, 주입된 객체를 로그로 출력.
	
}
