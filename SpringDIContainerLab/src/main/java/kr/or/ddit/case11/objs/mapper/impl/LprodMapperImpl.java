package kr.or.ddit.case11.objs.mapper.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.stereotype.Repository;

import kr.or.ddit.case11.objs.mapper.LprodMapper;
import kr.or.ddit.vo.LprodVO;
import lombok.RequiredArgsConstructor;

//@Repository
@RequiredArgsConstructor
public class LprodMapperImpl implements LprodMapper {

//	private final SqlSessionFactory sessionFactory;
	private final SqlSession session;
	
	@Override
	public List<LprodVO> selectLprodList() {
		LprodMapper proxy = session.getMapper(LprodMapper.class);
		return proxy.selectLprodList();
	}

	@Override
	public LprodVO selectLprod(String lprodGu) {
		return null;
	}

}
