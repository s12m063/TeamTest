package egovframework.example.dept.service.impl;

import static org.junit.jupiter.api.Assertions.fail;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import egovframework.example.common.Criteria;
import egovframework.example.dept.service.DeptService;
import egovframework.example.dept.service.DeptVO;
import lombok.extern.log4j.Log4j2;
@ExtendWith(SpringExtension.class)
@ContextConfiguration(locations = {
      "classpath:/egovframework/spring/context-aspect.xml",
       "classpath:/egovframework/spring/context-common.xml",
       "classpath:/egovframework/spring/context-datasource.xml",
       "classpath:/egovframework/spring/context-idgen.xml",
       "classpath:/egovframework/spring/context-mapper.xml",
       "classpath:/egovframework/spring/context-sqlMap.xml",
       "classpath:/egovframework/spring/context-transaction.xml"
   })
@Log4j2
class DeptServiceimplTest {
	@Autowired
	DeptService deptService;
	
	@Test
	void testSelectDeptList() {
//		여기서 각 메소드별 테스트 하면 된다 : 전체조회
//		1)테스트 조건 설정
		Criteria criteria = new Criteria();
		criteria.setSearchKeyword("");//검색어
		criteria.setFirstIndex(3);//2페이지(등차수열3)
		criteria.setPageUnit(3);//화면에보일개수(3)
//		2)실제 메소드 실행
		List<?> list = deptService.selectDeptList(criteria);
//		3)검증(확인):로그,DB확인,assert~
		log.info(list);
	}
	@Test
	void testSelectDeptListTotCnt() {
//		여기서 각 메소드별 테스트 하면 된다 : 전체조회
//		1)테스트 조건 설정
		Criteria criteria = new Criteria();
		criteria.setSearchKeyword("");//검색어
//		2)실제 메소드 실행
		int count = deptService.selectDeptListTotCnt(criteria);
//		3)검증(확인):로그,DB확인,assert~
		log.info(count);
	}
	@Test
	void testInsert() {
//		1)테스트 조건 설정DeptVO(dno dname loc)
		DeptVO deptVO = new DeptVO(0,"개발부2","서울");
//		2)실제 메소드 실행
		deptService.insert(deptVO);
//		3)검증(확인):로그,DB확인,assert~
		
	}
	@Test
	void testSelectDept() {
//		junit테스트 3단계 1)given 2)whern 3)then
//		1)테스트 조건 설정DeptVO(dno dname loc)
		int dno=10;
//		2)실제 메소드 실행
		DeptVO deptVO = deptService.selectDept(dno);
//		3)검증(확인):로그,DB확인,assert~
		log.info(deptVO);
	}
	@Test
	void testUpdate() {
//		1)테스트 조건 설정DeptVO(dno dname loc)
		DeptVO deptVO = new DeptVO(10,"개발부","서울");
//		2)실제 메소드 실행
		deptService.update(deptVO);
//		3)검증(확인):로그,DB확인,assert~

	}
	@Test
	void testDelete() {
//		1)테스트 조건 설정DeptVO(dno dname loc)
		DeptVO deptVO = new DeptVO();
		deptVO.setDno(10);
//		2)실제 메소드 실행
		deptService.delete(deptVO);		
//		3)검증(확인):로그,DB확인,assert~

	}
}
