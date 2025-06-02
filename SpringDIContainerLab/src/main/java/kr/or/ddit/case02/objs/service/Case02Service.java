package kr.or.ddit.case02.objs.service;

import kr.or.ddit.case02.objs.dao.Case02DAO;
import lombok.RequiredArgsConstructor;
import lombok.Setter;


@RequiredArgsConstructor //<--final상수 생성자 필수 필드로 등록 ^0^
@Setter
/*^y^*/
public class Case02Service {
	private final Case02DAO dao;
	private StringBuffer option;
}
