package kr.or.ddit.mission.objs.hunt;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import jakarta.annotation.Resource;
import kr.or.ddit.mission.objs.Cabbin;
import kr.or.ddit.mission.objs.gun.Gun;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;
//@Scope("prototype")
//@Component
@AllArgsConstructor
@Data
public class Hunter_me {
	private final Gun gun;
	
	private HuntingDog dog;
	private Cabbin cabbin;
	

}
