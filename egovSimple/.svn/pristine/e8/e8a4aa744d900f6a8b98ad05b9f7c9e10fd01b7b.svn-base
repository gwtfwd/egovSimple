package egovframework.let.camp.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import egovframework.let.camp.service.CampDefaultVO;
import egovframework.let.camp.service.CampService;
import egovframework.let.camp.service.CampVO;
import egovframework.rte.fdl.cmmn.EgovAbstractServiceImpl;
import egovframework.rte.fdl.idgnr.EgovIdGnrService;


@Service("campService")

public class CampServiceImpl extends EgovAbstractServiceImpl implements CampService {

	private static final Logger LOGGER = LoggerFactory.getLogger(CampServiceImpl.class);
	
	/** ParkDAO */
	// TODO ibatis 사용
	@Resource(name = "campDAO")
	
	private CampDAO campDAO;
	// TODO mybatis 사용
	//  @Resource(name="sampleMapper")
	//	private SampleMapper sampleDAO;
	
	/** ID Generation *//*
	@Resource(name = "campIdGnrService")
	private EgovIdGnrService campIdGnrService;*/
	
	
	/**
	 * 글 목록 조회
	 * @param campDefaultVO - 조회할 정보가 담긴 VO
	 * @return 글 목록
	 * @throws Exception
	 */
	public List<?> selectCampList(CampDefaultVO campDefaultVO) throws Exception {
		return campDAO.selectCampList(campDefaultVO);
	}
	
	/**
	 * 글 총 개수 조회
	 * @param campDefaultVO - 조회할 정보가 담긴 VO
	 * @return 글 총 개수
	 */
	@Override
	public int selectCampListTotCnt(CampDefaultVO campDefaultVO){
		return campDAO.selectCampListTotCnt(campDefaultVO);
	}
	
	/**
	 * 등록
	 * @param vo - 등록할 정보가 담긴 CampVO
	 * @return 등록 결과
	 * @exception Exception
	 */
	@Override
	public String insertCamp(CampVO vo) throws Exception {
		LOGGER.debug(vo.toString());

		//** ID Generation Service *//*
		/*Integer no = campIdGnrService.getNextStringNo();
		vo.setNo(no);
		LOGGER.debug(vo.toString());*/

		return campDAO.insertCamp(vo);
	}
	
	/**
	 * 글 조회
	 * @param vo - 조회할 정보가 담긴 CampVO
	 * @return 조회한 글
	 * @exception Exception
	 */
	@Override
	public CampVO selectCamp(CampVO vo) throws Exception {
		CampVO resultVO = campDAO.selectCamp(vo);
		if (resultVO == null)
			throw processException("info.nodata.msg");
		return resultVO;
	}

	/**
	 * 수정
	 * @param vo - 수정할 정보가 담긴 CampVO
	 * @return void형
	 * @exception Exception
	 */
	@Override
	public void updateCamp(CampVO vo) throws Exception {
		campDAO.updateCamp(vo);
	}

	/**
	 * 삭제
	 * @param vo - 삭제할 정보가 담긴 CampVO
	 * @return void형
	 * @exception Exception
	 */
	@Override
	public void deleteCamp(CampVO vo) throws Exception {
		campDAO.deleteCamp(vo);
	}

}
