package kr.or.ddit.case08.objs;

import java.util.Map;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Data;

//@Component
@Data //getter나 setter가 없으면 EL실행 불가능
@AllArgsConstructor
public class SimpleVO {
	private Map<String,Object> map;
	private String str;
}
