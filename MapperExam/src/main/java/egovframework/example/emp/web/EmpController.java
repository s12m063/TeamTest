package egovframework.example.emp.web;

import java.util.List;

import org.egovframe.rte.ptl.mvc.tags.ui.pagination.PaginationInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import egovframework.example.common.Criteria;
import egovframework.example.dept.service.DeptVO;
import egovframework.example.emp.service.EmpService;
import egovframework.example.emp.service.EmpVO;
import lombok.extern.log4j.Log4j2;
@Log4j2
@Controller
public class EmpController {
	@Autowired
	private EmpService empService;
	@GetMapping("/emp/emp.do")
	public String selectEmpList(@ModelAttribute Criteria criteria, Model model) {
//		등차자동계산클래스 : paginationInfo
//		필요정보: 1) 현재페이지번호 pageIndex 2)보일개수 pageUnit : 3
		PaginationInfo paginationInfo = new PaginationInfo();
		paginationInfo.setCurrentPageNo(criteria.getPageIndex());
		paginationInfo.setRecordCountPerPage(criteria.getPageUnit());
//		등차를 자동계산하면 : firstRecordIndex 필드에 있음
		criteria.setFirstIndex(paginationInfo.getFirstRecordIndex());
		List<?> emps=empService.selectEmpList(criteria);
		log.info("테스트 :"+emps);
		model.addAttribute("emps",emps);
//		페이지 번호 그리기 : 플러그인(전체 테이블 행개수 필요함)를 플러그인에 전해줘야 한다
		int totCnt=empService.selectEmpListTotCnt(criteria);
		paginationInfo.setTotalRecordCount(totCnt);
		log.info("테스트 : "+totCnt);
//		페이지 모든 정보는 :paginationInfo
		model.addAttribute("paginationInfo",paginationInfo);
		return "emp/emp_all";
	}
//	추가페이지열기
	@GetMapping("/emp/addition.do")
	public String createEmpView() {
		return "emp/add_emp";
	}
//	INSERT:저장버튼클릭시
	@PostMapping("/emp/add.do")
	public String insert(@ModelAttribute EmpVO empVO) {
//		deptVO 내용확인
		log.info("테스트3 :"+empVO);
//		서비스의 insert 실행
		empService.insert(empVO);
		return "redirect:/emp/emp.do";
	}
	@GetMapping("/emp/edition.do")
	public String updateEmpView(@RequestParam int eno, Model model) {
		EmpVO empVO = empService.selectEmp(eno);
		model.addAttribute("empVO",empVO);
		return "emp/update_emp";
	}
//	수정:버튼클릭시실행
	@PostMapping("/emp/edit.do")
	public String update(@RequestParam int eno,
			@ModelAttribute EmpVO empVO) {
		empService.update(empVO);
		return "redirect:/emp/emp.do";
	}
//  삭제
  @PostMapping("/emp/delete.do")
  public String delete(@ModelAttribute EmpVO empVO) {
//     서비스의 삭제 실행
     empService.delete(empVO);
     return "redirect:/emp/emp.do";
  }
}
