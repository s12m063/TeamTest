package egovframework.example.emp.service.impl;


import static org.junit.jupiter.api.Assertions.fail;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import egovframework.example.common.Criteria;
import egovframework.example.emp.service.EmpService;
import egovframework.example.emp.service.EmpVO;
import jdk.internal.org.jline.utils.Log;
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
class EmpServiceImplTest {
	@Autowired
	EmpService empService;
	@Test
	void testSelectEmpList() {
//		여기서 각 메소드별 테스트 하면 된다 : 전체조회
//		1)테스트 조건 설정
		Criteria criteria = new Criteria();
		criteria.setSearchKeyword("");
		criteria.setFirstIndex(3);//2페이지(등차수열3)
		criteria.setPageUnit(3);//화면에보일개수(3)

//		2)실제 메소드 실행
		List<?> list = empService.selectEmpList(criteria);
//		3)검증(확인):로그,DB확인,assert~
		log.info(list);
	}
	@Test
	void testSelectEmpListTotCnt() {
//		여기서 각 메소드별 테스트 하면 된다 : 전체조회
//		1)테스트 조건 설정
		Criteria criteria = new Criteria();
		criteria.setSearchKeyword("");//검색어
//		2)실제 메소드 실행
		int count = empService.selectEmpListTotCnt(criteria);
//		3)검증(확인):로그,DB확인,assert~
		log.info(count);
	}
	@Test
	void testInsert() {
		EmpVO empVO = new EmpVO();
		empVO.setEname("홍길동");
		empVO.setJob("부장");
		empVO.setManager(8000);
		empVO.setHiredate("2025-06-24");
		empVO.setSalary(5000);
		empVO.setCommission(1000);
		empVO.setDno(10);
		empService.insert(empVO);
	}
	@Test
	void testSelectEmp() {
		int eno=8000;
		EmpVO empVO = empService.selectEmp(eno);
		log.info(empVO);
	}
	@Test
	void testUpdate() {
	EmpVO empVO = new EmpVO(8000,"홍길동","백수",7788,"2025-05-25",3000,300,10);
	empService.update(empVO);
	}
	@Test
	void testDelete() {
		EmpVO empVO = new EmpVO();
		empVO.setEno(8001);
		empService.delete(empVO);
	}
}