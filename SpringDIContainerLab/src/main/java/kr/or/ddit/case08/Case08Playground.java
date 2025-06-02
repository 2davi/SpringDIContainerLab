package kr.or.ddit.case08;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Case08Playground {
	public static void main(String[] args) {
		System.getenv().forEach((k,v)->{
			log.info("{} = {}" , k,v);
		});
	}
}
