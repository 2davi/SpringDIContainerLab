package kr.or.ddit.mission.conf;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import kr.or.ddit.mission.objs.Cabbin;
import kr.or.ddit.mission.objs.HunterGround;
import kr.or.ddit.mission.objs.hunt.Hunter;
import kr.or.ddit.mission.objs.hunt.HuntingDog;

/**
 * 지금부터 사냥 게임을 만들건데 사냥게임 모델링을 할것임.
 * 
 * 1. Hunter (싱글턴으로 하면 안됨.) VO
 * 2. HumterGround : 사냥터에는 여러명의 사냥꾼이 존재 할 수 있음. 모든 객체를 가지고 있는 객체 Controller
 * 3. Gun : 사냥꾼은 각자 자기의 총을 소유함. - 사용법 동일 Service
 * 		ShotGun : gun의 확장
 * 		Riffle : 사용법 동일 (*) 선택하지 않으면 기본 총. 우선권을 가지고 있어야함.
 * 4. HuntiongDog : 한마리의 사냥개를 여러 사냥꾼이 공유함. ?
 * 5. Cabbin : 하나의 오두막을 공유함. 쉬는 공간.?
 * 
 * 
 */
//@Configuration
//@ComponentScan(basePackages = "kr.or.ddit.mission.objs")
public class MissionConfig_me {

}
