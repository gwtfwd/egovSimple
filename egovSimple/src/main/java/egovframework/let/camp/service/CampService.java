package egovframework.let.camp.service;

import java.util.List;

import egovframework.let.camp.service.CampDefaultVO;


public interface CampService {

	/**
	 * 글 목록 조회
	 * @param campDefaultVO - 조회할 정보가 담긴 VO
	 * @return 글 목록
	 * @throws Exception
	 */
	List<?> selectCampList(CampDefaultVO campDefaultVO) throws Exception;
	
	/**
	 * 글 총 개수 조회
	 * @param parkVO - 조회할 정보가 담긴 VO
	 * @return 글 총 개수
	 */
	int selectCampListTotCnt(CampDefaultVO campDefaultVO);
	
	/**
	 * 등록
	 * @param vo - 등록할 정보가 담긴 CampVO
	 * @return 등록 결과
	 * @exception Exception
	 */
	String insertCamp(CampVO vo) throws Exception;

	/**
	 * 글 조회
	 * @param vo - 조회할 정보가 담긴 CampVO
	 * @return 조회한 글
	 * @exception Exception
	 */
	CampVO selectCamp(CampVO vo) throws Exception;
	
	/**
	 * 수정
	 * @param vo - 수정할 정보가 담긴 CampVO
	 * @return void형
	 * @exception Exception
	 */
	void updateCamp(CampVO vo) throws Exception;

	/**
	 * 삭제
	 * @param vo - 삭제할 정보가 담긴 CampVO
	 * @return void형
	 * @exception Exception
	 */
	void deleteCamp(CampVO vo) throws Exception;

	
}
