package kr.or.ddit.case08.conf;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;

import kr.or.ddit.case08.objs.DestVO;
import kr.or.ddit.case08.objs.OriginalVO;
/**
 * Map과 관련된 이슈
 * Map 타입을 주입 받을때엔 타입과 빈 아이디가 모두 일치하도록 주입 받아야함(타입과 bin의 id가 모두 일치해야 안전하게 주입 받을 수 있음.)
 * 		--> 그 이외의 경우 스프링 컨테이너의 빈팩토리를 map으로 주입 받을 수 있음.(bean factory는 map은 아니지만 강제로 map으로 변환해서 들어오게 됨)
 * 			--> 순환 참조의 문제 발생 가능성이 있음
 * 
 * @Value 어노테이션의 싱글값으로 spEL을 사용할 수 있음.
 * property placeholder : ${프로퍼티명}, 컨테이너의 프로퍼티 소스에 있는 프로퍼티에 접근. 수업시간에 많이 사용하지 않을거임.
 * spEL의 형태 :#{빈id}, #{빈id.프로퍼티명}, #{빈id['프로퍼티명']}
 * --> jsp EL과 문법 구조는 비슷함
 * 	주의!
 * 		'+', '*' : jsp에서는 산술연산만 처리함.
 * 		조건식?참:거짓 jsp와 spEL에서 모두 지원됨.
 * 		spEL은 엘비스 연산자로 처리하기도 함. - js의 널병합 연산자와 유사함.
 * 		ex) a=null;
 * 			b = a!=null? a : "기본값";
 * 			JS 널병합 연산 ==> b = a ?? "기본값"
 * 			spEL 엘비스 연산자 ==> b = a ?: "기본값"
 * 			동작하는 형태는 비슷함. 기호가 바뀐거 뿐임. 외우자.
 * 		static 구성 요소에 대한 접근 지원.
 * 			spEL ? T(kr.or.ddit.case08.objs.OriginalVO) // Spring만 가지고 있는 연산구조
 * 					 == OriginalVO.class
 * 					T(kr.or.ddit.case08.objs.OriginalVO).staticNumber ==> 바로 접근
 * 					T(class qualified name).static프로퍼티명
 */
@Configuration
public class Case08ExpressionLanguageConfig {
	@Bean
	public List<String> list(){
		return List.of("값1","값2");
	}
	@Bean
	public List<String> nonUseList(){
		return new ArrayList<>();
	}
	
	@Bean
	public Map<String, Object> map(){
		return Map.of("key1","value1","key-2","value2");
	}
	
	
	@Bean
	public OriginalVO original(
			List<String> list,
			Map<String, Object> map,
			@Value("값이당")String str,
			@Value("classpath:logback.xml")Resource res // 이건 어디에 있는 어떤 리소스를 표현해줘야해서 bean으로 등록 못하나봄.
			, @Value("34")int number
			) {
		return new OriginalVO(list,map,str,res,number);
	}
	
	// 여기에서 표현식은 #{}이렇게 사용됨. jsp랑 비슷하게 접근 가능 jsp의 EL과 비슷하게 접근.
	// 둘중에 하나라도 확실한 문자열이 있으면 문자열로 해주고 (문자열 +를 해주던 아니면 문자열*를 해준던)둘다 숫자이면 연산을 해줌.
	@Bean
	public DestVO dest(
			@Value("#{original.str ?: '기본값이당..'}") String str 
//			@Value("#{original.str * 3}") String str // 이것도 되네? 값이 복사되서 3번 나옴. 
//			@Value("#{original.str + 3}") String str // 이건 concat연산이 되어서 나옴. null 일때엔 ADD가 되지않음.
//			@Value("#{T(org.apache.commons.lang3.StringUtils).isNotBlank(orignal.str) ? original.str : '기본값이당'")String str
//			@Value("#{T(org.apache.commons.lang3.StringUtils).isNotBlank(orignal.str) ?: '기본값이당'")String str
			,@Value("#{original['res']}") Resource res
			,@Value("#{T(kr.or.ddit.case08.objs.OriginalVO).staticNumber * 10}") int number
//			,@Value("#{original.list[1]}")String secondStr // 배열이나 리스트나 이렇게 접근함 자바나.
			,@Value("#{original.list.get(1)}")String secondStr // 배열이나 리스트나 이렇게 접근함 자바나.
			,@Value("#{original.map.key1}")String key1Value
			,@Value("#{original.map['key-2']}")String key2Value
//			,@Value("#{original.map.get('key-2')}")String key2Value
			, @Value("#{T(java.time.LocalDate).now}")LocalDate today
			, @Value("#{T(java.time.LocalDateTime).now}")LocalDateTime now
			) {
		return new DestVO(str, res, number,secondStr,key1Value,key2Value,today,now);
	}
}
