package kr.or.ddit.mission.objs;

import java.util.List;

import org.springframework.stereotype.Component;

import kr.or.ddit.mission.objs.hunt.Hunter;
import kr.or.ddit.mission.objs.hunt.HuntingDog;
import lombok.Data;
import lombok.RequiredArgsConstructor;
//@Component
@RequiredArgsConstructor
@Data
public class HunterGround_me {
	private final HuntingDog dog;
	private final Cabbin cabbin;
	private List<Hunter> hunters;
	
}
