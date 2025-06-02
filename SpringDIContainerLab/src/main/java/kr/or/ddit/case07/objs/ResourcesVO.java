package kr.or.ddit.case07.objs;

import org.springframework.core.io.Resource;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Data
public class ResourcesVO {
	private final Resource fR;
	private final String str;
	private final Integer number;
	private Resource cR;
	private Resource wR;
}
