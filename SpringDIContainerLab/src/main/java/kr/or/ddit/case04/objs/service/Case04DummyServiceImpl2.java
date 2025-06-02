package kr.or.ddit.case04.objs.service;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

@Primary///<-동일타입 Bean객체 사이에서 최우선순위 주입 설정.
//BUT,, 주입할 녀석을 콕 집어 선택하는 건 주입받는 쪽에서 결정해야 하는 법.
@Service("service2")
public class Case04DummyServiceImpl2 implements Case04DummyService {
	
}
