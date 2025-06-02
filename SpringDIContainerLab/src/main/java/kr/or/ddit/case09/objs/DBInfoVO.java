package kr.or.ddit.case09.objs;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Data
@Builder
public class DBInfoVO {
	private String driverClassName;
	private String url;
	private String username;
	private String password;
	private boolean autoCommit;
	private int minimumIdle;
	private int maximumPoolSize;
	private long connectionTimeout; // 시간의 단위를 표현할때엔 밀리세컨드면 long으로 잡는다
}
