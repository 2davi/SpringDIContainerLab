package kr.or.ddit.mission;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import kr.or.ddit.mission.objs.HunterGround;
import kr.or.ddit.mission.objs.HunterGround_me;
import kr.or.ddit.mission.objs.hunt.Hunter;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class MissionPlayground_me {
	public static void main(String[] args) {
//		HuntingGround를 주입박소 로그로 출력
//		몇명의 사냥꾼이 어떤 총을 가지고 있는지...
		ConfigurableApplicationContext context = 
				new AnnotationConfigApplicationContext("kr.or.ddit.mission.conf");
		context.registerShutdownHook();
		HunterGround_me ground = context.getBean(HunterGround_me.class);
		List<Hunter> hunters = new ArrayList<Hunter>();
		for(int i =0; i<10;i++) {
			hunters.add(context.getBean(Hunter.class));
		}
		ground.setHunters(hunters);
		log.info("사냥꾼의 수 : {}",ground.getHunters().size());
		for(Hunter hunter : ground.getHunters() ) {
			log.info("사냥꾼의 총의 종류 : {}",hunter.getGun().getClass().getSimpleName());
		}
		log.info("사냥 개의 정보: {}", ground.getDog().getClass().getSimpleName());
		log.info("오두막의 정보: {}", ground.getCabbin().getClass().getSimpleName());
	}
}
