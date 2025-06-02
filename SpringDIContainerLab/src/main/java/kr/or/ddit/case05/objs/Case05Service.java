package kr.or.ddit.case05.objs;

import org.springframework.stereotype.Service;

import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
@Service("service")
public class Case05Service {
	private final Case05Dao dao; //<<--생성자의 파라미터 이름으로 사용된 변수명 => XML
	
	@PostConstruct
	public void start() {
		log.info("■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■ DAO INJECTED [{}]■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■", dao.getClass().getSimpleName());
	}
}
