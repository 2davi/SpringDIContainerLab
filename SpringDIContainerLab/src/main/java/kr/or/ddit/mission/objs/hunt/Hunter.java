package kr.or.ddit.mission.objs.hunt;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import kr.or.ddit.mission.objs.Cabbin;
import kr.or.ddit.mission.objs.gun.Gun;
import lombok.Getter;
import lombok.ToString;
@Scope("prototype")
@Component
@Getter
@ToString
public class Hunter {
	private Gun gun;
	
	@ToString.Exclude
	private HuntingDog dog;
	@ToString.Exclude
	private Cabbin cabbin;
	
	public Hunter(Gun gun) {
		super();
		this.gun = gun;
	}
	@Autowired
	public void changeGun(Gun gun){
		this.gun = gun;
	}
	@Autowired
	public void setCabbin(Cabbin cabbin) {
		this.cabbin = cabbin;
	}
	@Autowired
	public void setDog(HuntingDog dog) {
		this.dog = dog;
	}
}
