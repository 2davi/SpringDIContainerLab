package kr.or.ddit.case11.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import kr.or.ddit.case11.objs.mapper.LprodMapper;
import kr.or.ddit.vo.LprodVO;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class LprodServiceImpl {
	
	private final LprodMapper mapper;
	
	public List<LprodVO> readLprodList() {
		return mapper.selectLprodList();
	}
	public Optional<LprodVO> readLprod(String lprodGu) {
		return Optional.ofNullable(mapper.selectLprod(lprodGu));
	}
}
