package kr.or.ddit.case06.objs.user;

import org.springframework.stereotype.Controller;

import jakarta.inject.Inject;
import kr.or.ddit.case06.objs.parent.CommonService;

//상황가정:: 회원정보 조회용 컨트롤러
@Controller
public class UserController {
	@SuppressWarnings("unused")
	private CommonService service;
	@Inject
	public void setService(CommonService service) {
		this.service = service;
	}
}
