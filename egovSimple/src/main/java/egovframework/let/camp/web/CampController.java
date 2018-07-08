package egovframework.let.camp.web;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.support.SessionStatus;
import org.springmodules.validation.commons.DefaultBeanValidator;

import egovframework.let.camp.service.CampDefaultVO;
import egovframework.let.camp.service.CampService;
import egovframework.let.camp.service.CampVO;
import egovframework.rte.fdl.property.EgovPropertyService;
import egovframework.rte.ptl.mvc.tags.ui.pagination.PaginationInfo;

@Controller
public class CampController {

	/** EgovSampleService */
	@Resource(name = "campService")
	private CampService campService;
	
	/*@Resource(name = "campTypeService")
	private CampTypeService campTypeService;*/

	/** EgovPropertyService */
	@Resource(name = "propertiesService")
	protected EgovPropertyService propertiesService;

	/** Validator */
	@Resource(name = "beanValidator")
	protected DefaultBeanValidator beanValidator;
	
	/**
	 * 글 목록 조회 (paging)
	 * @param campDefaultVO - 조회할 정보가 담긴 CampDefaultVO
	 * @param model
	 * @return "campList"
	 * @exception Exception
	 */
	@RequestMapping(value="/camp/campList.do")
	public String selectCampList(@ModelAttribute("campDefaultVO") CampDefaultVO campDefaultVO, ModelMap model) throws Exception {

		/** EgovPropertyService.sample */
		campDefaultVO.setPageUnit(propertiesService.getInt("pageUnit"));
		campDefaultVO.setPageSize(propertiesService.getInt("pageSize"));

		/** paging setting */
		PaginationInfo paginationInfo = new PaginationInfo();
		paginationInfo.setCurrentPageNo(campDefaultVO.getPageIndex());
		paginationInfo.setRecordCountPerPage(campDefaultVO.getPageUnit());
		paginationInfo.setPageSize(campDefaultVO.getPageSize());

		campDefaultVO.setFirstIndex(paginationInfo.getFirstRecordIndex());
		campDefaultVO.setLastIndex(paginationInfo.getLastRecordIndex());
		campDefaultVO.setRecordCountPerPage(paginationInfo.getRecordCountPerPage());

		List<?> campList = campService.selectCampList(campDefaultVO);
		model.addAttribute("resultList", campList);

		int totCnt = campService.selectCampListTotCnt(campDefaultVO);
		paginationInfo.setTotalRecordCount(totCnt);
		model.addAttribute("paginationInfo", paginationInfo);

		return "camp/campList";
	}
	
	/**
	 * 글 등록 화면 조회
	 * @param campDefaultVO - 목록 조회조건 정보가 담긴 VO
	 * @param model
	 * @return "campRegister"
	 * @exception Exception
	 */
	@RequestMapping(value = "/camp/addCamp.do", method = RequestMethod.GET)
	public String addCampView(@ModelAttribute("campDefaultVO") CampDefaultVO campDefaultVO, Model model) throws Exception {
		
		/*List<?> parkTypeList = parkTypeService.selectParkTypeList(parkSearchVO);
		model.addAttribute("parkTypeList", parkTypeList);*/
		
		model.addAttribute("campVO", new CampVO());
		return "camp/campRegister";
	}

	/**
	 * 글 등록
	 * @param campVO - 등록할 정보가 담긴 VO
	 * @param campDefaultVO - 목록 조회조건 정보가 담긴 VO
	 * @param status
	 * @return "forward:/campList.do"
	 * @exception Exception
	 */
	@RequestMapping(value = "/camp/addCamp.do", method = RequestMethod.POST)
	public String addCamp(@ModelAttribute("campDefaultVO") CampDefaultVO campDefaultVO, CampVO campVO, BindingResult bindingResult, Model model, SessionStatus status)	throws Exception {

		// Server-Side Validation
		beanValidator.validate(campVO, bindingResult);

		if (bindingResult.hasErrors()) {
			model.addAttribute("campVO", campVO);
			return "camp/campRegister";
		}

		campService.insertCamp(campVO);
		status.setComplete();
		return "forward:/campList.do";
	}

	/**
	 * 글 조회
	 * @param campVO - 조회할 정보가 담긴 VO
	 * @param campDefaultVO - 목록 조회조건 정보가 담긴 VO
	 * @param status
	 * @return @ModelAttribute("campVO") - 조회한 정보
	 * @exception Exception
	 */
	public CampVO selectCamp(CampVO campVO, @ModelAttribute("campDefaultVO") CampDefaultVO campDefaultVO) throws Exception {
		
		return campService.selectCamp(campVO);
	}

	
	/**
	 * 글 수정화면 조회
	 * @param code - 수정할 글 code
	 * @param campDefaultVO - 목록 조회조건 정보가 담긴 VO
	 * @param model
	 * @return "campRegister"
	 * @exception Exception
	 */
	@RequestMapping("/camp/updateCampView.do")
	public String updateCampView(@RequestParam("selectedNo") Integer no, @ModelAttribute("campDefaultVO") CampDefaultVO campDefaultVO, Model model) throws Exception {
		
		/*List<?> campTypeList = parkTypeService.selectParkTypeList(parkSearchVO);
		model.addAttribute("parkTypeList", parkTypeList);*/
		
		CampVO campVO = new CampVO();
		campVO.setNo(no);
		// 변수명은 CoC 에 따라 parkVO
		model.addAttribute(selectCamp(campVO, campDefaultVO));
		return "camp/campRegister";
	}

	
	/**
	 * 글 수정
	 * @param campVO - 수정할 정보가 담긴 VO
	 * @param campDefaultVO - 목록 조회조건 정보가 담긴 VO
	 * @param status
	 * @return "forward:/campRegister.do"
	 * @exception Exception
	 */
	@RequestMapping("/camp/updateCamp.do")
	public String updateCamp(@ModelAttribute("campDefaultVO") CampDefaultVO campDefaultVO, CampVO campVO, BindingResult bindingResult, Model model, SessionStatus status)	throws Exception {

		beanValidator.validate(campVO, bindingResult);

		if (bindingResult.hasErrors()) {
			model.addAttribute("campVO", campVO);
			return "camp/campRegister";
		}

		campService.updateCamp(campVO);
		status.setComplete();
		return "forward:/campList.do";
	}

	/**
	 * 글 삭제
	 * @param campVO - 삭제할 정보가 담긴 VO
	 * @param campDefaultVO - 목록 조회조건 정보가 담긴 VO
	 * @param status
	 * @return "forward:/campList.do"
	 * @exception Exception
	 */
	@RequestMapping("/camp/deleteCamp.do")
	public String deleteCamp(CampVO campVO, @ModelAttribute("campDefaultVO") CampDefaultVO campDefaultVO, SessionStatus status) throws Exception {
		campService.deleteCamp(campVO);
		status.setComplete();
		return "forward:/campList.do";
	}
	
}


