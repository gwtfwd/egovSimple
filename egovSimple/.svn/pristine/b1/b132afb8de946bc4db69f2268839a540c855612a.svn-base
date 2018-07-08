package egovframework.let.camp.service.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import egovframework.let.camp.service.CampDefaultVO;
import egovframework.let.camp.service.CampVO;
import egovframework.rte.psl.dataaccess.EgovAbstractDAO;



@Repository("campDAO")
public class CampDAO extends EgovAbstractDAO {

	/**
	 * 글 목록 조회
	 * @param searchMap - 조회할 정보가 담긴 Map
	 * @return 글 목록
	 * @throws Exception
	 */
	public List<?> selectCampList(CampDefaultVO campDefaultVO) throws Exception {
		return list("campDAO.selectCampList", campDefaultVO);
	}
	
	/**
	 * 글 총 개수 조회
	 * @param searchMap - 조회할 정보가 담긴 Map
	 * @return 글 총 개수
	 */
	public int selectCampListTotCnt(CampDefaultVO campDefaultVO){
		return (Integer) select("campDAO.selectCampListTotCnt", campDefaultVO);
	}
	
	/**
	 * 등록
	 * @param vo - 등록할 정보가 담긴 CampVO
	 * @return 등록 결과
	 * @exception Exception
	 */
	public String insertCamp(CampVO vo) throws Exception {
		return (String) insert("campDAO.insertCamp", vo);
	}

	/**
	 * 글 조회
	 * @param vo - 조회할 정보가 담긴 ParkVO
	 * @return 조회한 글
	 * @exception Exception
	 */
	public CampVO selectCamp(CampVO vo) throws Exception {
		return (CampVO) select("campDAO.selectCamp", vo);
	}


	/**
	 * 수정
	 * @param vo - 수정할 정보가 담긴 CampVO
	 * @return void형
	 * @exception Exception
	 */
	public void updateCamp(CampVO vo) throws Exception {
		update("campDAO.updateCamp", vo);
	}

	/**
	 * 삭제
	 * @param vo - 삭제할 정보가 담긴 CampVO
	 * @return void형
	 * @exception Exception
	 */
	public void deleteCamp(CampVO vo) throws Exception {
		delete("campDAO.deleteCamp", vo);
	}

	
	
	
	
}

