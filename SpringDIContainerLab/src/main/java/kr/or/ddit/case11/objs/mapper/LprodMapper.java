package kr.or.ddit.case11.objs.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import kr.or.ddit.vo.LprodVO;

/**	이제부터 우리는 Mapper INTERFACE를 등록할 때
 * 	@Repository 를 사용한다.
 * 
 * 	CONFIG => setAnnotationClass(Repository.class);
 * 
 */
@Repository
public interface LprodMapper {
//	@Select("""
//		SELECT LPROD_ID, L.LPROD_GU, LPROD_NAME, PROD_ID, PROD_NAME
//		  FROM LPROD L
//		  LEFT OUTER JOIN PROD P ON(P.LPROD_GU = L.LPROD_GU)
//		 ORDER BY LPROD_GU, PROD_ID
//			""")
	public List<LprodVO> selectLprodList();
	@Select("""
		SELECT LPROD_ID, L.LPROD_GU AS GU, LPROD_NAME, PROD_ID, PROD_NAME
		  FROM LPROD L
		  LEFT OUTER JOIN PROD P ON(P.LPROD_GU = L.LPROD_GU)
		 WHERE L.LPROD_GU = #{gu}
		 ORDER BY L.LPROD_GU, PROD_ID
			""")
	@ResultMap("lprodMap")
	public LprodVO selectLprod(@Param("gu") String lprodGu);
}
