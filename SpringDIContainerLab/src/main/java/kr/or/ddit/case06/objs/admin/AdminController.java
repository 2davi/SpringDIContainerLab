package kr.or.ddit.case06.objs.admin;

import org.springframework.stereotype.Controller;

import kr.or.ddit.case06.objs.parent.CommonService;
import lombok.RequiredArgsConstructor;

@Controller
//상황가정:: 회원정보 조회용 컨트롤러
@RequiredArgsConstructor
public class AdminController {
	@SuppressWarnings("unused")
	private final CommonService service;
}
