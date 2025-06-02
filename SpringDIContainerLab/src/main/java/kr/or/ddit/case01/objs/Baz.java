package kr.or.ddit.case01.objs;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Baz {
	
	public Baz() {
		log.info("■□■ {} 객체 생성", this.getClass().getSimpleName());
	}
	
}
