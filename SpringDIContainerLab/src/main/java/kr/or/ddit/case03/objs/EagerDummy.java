package kr.or.ddit.case03.objs;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class EagerDummy {

	private EagerSingletonDummy esd;
	
	public void setEsd(EagerSingletonDummy esd) {
		this.esd = esd;
		log.info("■■■■■■setter injection 실행");
	}
	
	public EagerDummy() {
		log.info("{} 하하하ㅏ하하하하하하하하하핳하하하하하핳ㅎ핳", this.getClass().getName());
	}
	
	public void start() {
		log.info("■■■start메소드 실행, 주입된 객체의 주소: {}", esd.hashCode());
	}
	
	public void /*expire*/awqeoihfd() {
		log.info("■■■expire메소드 실행");
	}
	
	//위 메소드처럼 정해진 시그니처 없이 멋대로 이름붙일 수 있는 것들도 POJO라 함.
	
}
