package kr.or.ddit.case08.objs;

import java.time.LocalDate;
import java.time.LocalDateTime;

import org.springframework.core.io.Resource;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class DestVO {
	private String str;
	private Resource res;
	private int number;
	
	private String secondStr;
	private String key1Value;
	private String key2Value;
	
	private LocalDate today;
	private LocalDateTime now;
}
