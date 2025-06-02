package kr.or.ddit.case08.objs;

import java.util.List;
import java.util.Map;

import org.springframework.core.io.Resource;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class OriginalVO {
	public static int staticNumber=23;
	private List<String> list;
	private Map<String,Object> map;
	private String str;
	private Resource res;
	private int number;
	
}
