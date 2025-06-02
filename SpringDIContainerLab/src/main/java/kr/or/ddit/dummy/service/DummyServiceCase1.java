package kr.or.ddit.dummy.service;

import java.util.Map;
import java.util.Map.Entry;

import org.springframework.stereotype.Service;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.Resource;
import kr.or.ddit.dummy.dao.DummyDAO;
import kr.or.ddit.dummy.dao.DummyDAOFactory;
//import kr.or.ddit.dummy.dao.DummyDAOImpl_MariaDB;
import kr.or.ddit.dummy.dao.DummyDAOImpl_Oracle;
import lombok.extern.slf4j.Slf4j;

@Service("service")
@Slf4j
public class DummyServiceCase1 {
	//1. 필요 객체(의존객체)를 new키워드로 직접 생성. 결합력 최상(전형적인 망한 코드)
	@SuppressWarnings("unused")
	private DummyDAO _dao = new DummyDAOImpl_Oracle();

	//2. FactoryObject 적용: factory 객체와의 의존관계로 결합력 위치가 이동할 뿐
	@SuppressWarnings("unused")
	private DummyDAO __dao = DummyDAOFactory.getDummyDAO();
	
	//3. StrategyPattern 적용: `전략의 주입자` 필요
	//전략으로 사용되는 애들(이 경우, service)에게는 결합력이 없엉.
	//대신에 그것들을 관리(주입)하는 주입자가 모든 결합력을 떠안게 됨.
	//전략패턴을 확장해서 만들어진 것이 SPRING.. 그놈의 결합력을 낮추기 위해
	private DummyDAO dao;
	@Resource(name="daoOracle")
	public void setDao(DummyDAO dao) { this.dao = dao; }
	
	@PostConstruct
	public void init() {
		log.info("주입된 dao: {}", dao);
	}
	
	public StringBuffer readDummy(String pk) {
		Map<String, Object> rawData = dao.selectDummy(pk);
		StringBuffer information = new StringBuffer();
		for(Entry<String, Object> entry: rawData.entrySet()) {
			String key = entry.getKey();
			Object value = entry.getValue();
			information.append(
				String.format("■□■ %s - %s\n", key, value)
			);
		}
		information.append("이 재료들을 지지고 볶아서 김치찌개를 만듦.");
		return information;
	}
}
