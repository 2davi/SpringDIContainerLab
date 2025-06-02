package kr.or.ddit.vo;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

@Data
@EqualsAndHashCode(of="lrpodGu")
@NoArgsConstructor
public class LprodVO implements Serializable {
	private Integer lprodId;
	private String lprodGu;
	private String lprodName;
	private String prodId;
	private String prodName;
	
	private List<ProdVO> prodList;
}
