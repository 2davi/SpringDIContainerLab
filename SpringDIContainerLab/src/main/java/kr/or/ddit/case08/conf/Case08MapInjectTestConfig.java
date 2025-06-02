package kr.or.ddit.case08.conf;

import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

import kr.or.ddit.case08.objs.OthersVO;
import kr.or.ddit.case08.objs.SimpleVO;
import lombok.extern.slf4j.Slf4j;

@ComponentScan(basePackages = "kr.or.ddit.case08.objs")
@Slf4j
public class Case08MapInjectTestConfig {
	@Bean
	public StringBuffer dummy2(
			Map<String, Object> beanFactory
			,@Value("${username}") String username
			//${} ==> property placeholder ?? 헷갈려 죽겠는데? 뭐야 얜. 
			// 이 기호는 Spring안에 SystemProperties와 Value가있음 저건 프로퍼티 안에 있는 소스에 접근하려고함.
			// 그럴때 이러한 기호를 사용함. 시스템 자원에 접근할때 ${}를 사용하고 있음.
	) {
		log.info("username : {}",username);
		log.info("bean factory size : {}", beanFactory.size());
		beanFactory.forEach((k,v)->{
			log.info("{} =========> {}", k,v);
		});
		return null;
	}
	@Bean
	public Map<String, Object> map(){
		return Map.of("k1",34,"k2","value");
	}
	@Bean
	public SimpleVO dummy(
			Map<String, Object> map 
			,@Value("TEXT") String str
			) {
		map.forEach((k,v)->{
			log.info("{} ===> {}",k,v);
		});
		return new SimpleVO(map,str); 
	}
//	@Bean
//	public SimpleVO dummy(
//			Map<String, Object> hashMap //bean factory가 주입됬음. 이때엔 simpleVO는 여기 없음. 검색조건이 완전히 일치되지 않아서 벌어지는 일임. bean factory는 Map처럼 k,v를 가지고 있음 그걸 먼저 넣어줌. 내가 만든게 아니더라도.강제로 
//			//bean Factory가 map으로 변경되어서 들어가게 되버림.
//			,@Value("TEXT") String str
//			) {
//		hashMap.forEach((k,v)->{
//			log.info("{} ===> {}",k,v);
//		});
//		return new SimpleVO(hashMap,str); //실행된 이후 값이 늘어남. 
//	}
	@Bean // 이걸 등록하려는 시점엔 hashMap의 사이즈는 늘어나있는 상태. 더미가 들어가있음.
	public OthersVO others(
			@Value("#{dummy.str}")String str // 여기서 더미를 써먹음. 등록된 빈들중 더미 접근. property로 접근.
											// 빈팩토리 안에 더미가 또 들어감. 계속 들어감. 내 안에서 계속 더미를 참조.
			) {
		return new OthersVO(str);
	}
}
