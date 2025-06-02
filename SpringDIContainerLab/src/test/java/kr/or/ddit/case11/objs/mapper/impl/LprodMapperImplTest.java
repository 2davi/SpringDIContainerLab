package kr.or.ddit.case11.objs.mapper.impl;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import kr.or.ddit.case11.conf.Case11MybatisSpringConfig;
import kr.or.ddit.case11.objs.mapper.LprodMapper;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringJUnitConfig(classes=Case11MybatisSpringConfig.class)
class LprodMapperImplTest {

	@Autowired
	LprodMapper mapper; 
	
	@Test
	void testSelectLprodList() {
		log.info("■■■■■■■■■■■■■■■■■ 주입된 mapper: {}", mapper);
		
		mapper.selectLprodList()
			  .forEach(lvo -> log.info("{}", lvo)); 
	}

	@Test
	void testSelectLprod() {
		assertNotNull(mapper.selectLprod("P101"));
	}

}
