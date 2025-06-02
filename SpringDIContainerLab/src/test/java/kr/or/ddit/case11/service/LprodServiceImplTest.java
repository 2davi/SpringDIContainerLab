package kr.or.ddit.case11.service;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import kr.or.ddit.case11.conf.Case11MybatisSpringConfig;
import kr.or.ddit.case11.objs.mapper.LprodMapper;
import kr.or.ddit.vo.LprodVO;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringJUnitConfig(classes = Case11MybatisSpringConfig.class)
class LprodServiceImplTest {
	
	@Autowired
	LprodServiceImpl service;
	
	@Test
	void testReadLprodList() {
		log.info("■■■■■■■■■■■■■■■■주입된 service: {}", service);
		assertDoesNotThrow(() -> log.info("{}",service.readLprodList()));
	}

	@Test
	void testReadLprod() {
		assertDoesNotThrow(() -> {
			LprodVO lprod = service.readLprod("P501").get();
			log.info("{}, 상품 갯수: {}", lprod.getLprodGu(), lprod.getProdList().size());
			if(!lprod.getProdList().isEmpty())
				log.info("첫번째 상품: {}", lprod.getProdList().get(0));
		});
	}

}
