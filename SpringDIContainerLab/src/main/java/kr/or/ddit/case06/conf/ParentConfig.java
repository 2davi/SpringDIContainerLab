package kr.or.ddit.case06.conf;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScan.Filter;
import org.springframework.context.annotation.FilterType;
import org.springframework.stereotype.Controller;

@ComponentScan(basePackages = "kr.or.ddit.case06.objs"
			   ,excludeFilters = {@Filter(type=FilterType.ANNOTATION, classes = Controller.class)} )
//3개의 Bean 등록. (p-service, a&u-controller)
public class ParentConfig {

}
