package kr.or.ddit.vo;

import java.util.Objects;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * 	Domain Layer: 테이블의 스키마(엔터티 구조)를 반영함.
 * 	JavaBean규약에 따라 개발되어야 함. -> lombok 활용중.
 * 	
 * 
 */
@Data
@EqualsAndHashCode(of="mtType")
@NoArgsConstructor //기본생성자
@AllArgsConstructor //모든 필드를 갖는 생성자
public class MbtiVO {
	private Integer mtSort;
	private String mtType;
	private String mtTitle;
	private String mtContent;
}
