package kr.or.ddit.mission.objs;

import java.util.List;

import org.springframework.stereotype.Component;

import kr.or.ddit.mission.objs.hunt.Hunter;
import kr.or.ddit.mission.objs.hunt.HuntingDog;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@ToString
@AllArgsConstructor
public class HunterGround {
	private HuntingDog dog;
	private Cabbin cabbin;
	private List<Hunter> hunters;
	public void enter(Hunter hunter) {
		hunters.add(hunter);
	}
	
}
