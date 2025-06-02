package kr.or.ddit.case07.conf;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;

import kr.or.ddit.case07.objs.ResourcesVO;

@Configuration
public class Case07ResourceLoadingConfig {
		
	@Bean
	public ResourcesVO resVO( @Value("file:D:\\00.medias\\images\\cute9.JPG") Resource fR
							, @Value("classpath:kr/or/ddit/case05/conf/Case05-Context.xml") Resource vR
							, @Value("https://commons.apache.org/proper/commons-io/dependency-info.html") Resource wR
							, @Value("어쩔티비") String str
							, @Value("4") int number) {
		ResourcesVO resVO = new ResourcesVO(fR, str, number);
		resVO.setCR(vR);
		resVO.setWR(wR);
		
		return resVO;
	}
}
