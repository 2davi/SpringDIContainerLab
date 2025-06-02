package kr.or.ddit.case06.conf;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;
import org.springframework.context.annotation.ComponentScan.Filter;
import org.springframework.stereotype.Controller;

@ComponentScan(basePackages = "kr.or.ddot.case06.objs.admin"
			   , useDefaultFilters = false
			   , includeFilters = {@Filter(type =FilterType.ANNOTATION, classes = Controller.class )}
			   , lazyInit = true)
public class AdminConfig {

}
