package egovframework.example.emp.service;

import java.util.List;

import egovframework.example.common.Criteria;

public interface EmpService {
	 List<?> selectEmpList(Criteria criteria);//전체조회
	 int selectEmpListTotCnt(Criteria criteria);//총갯수구하기
	 int insert(EmpVO empVO);
	 EmpVO selectEmp(int eno);
	 int update(EmpVO empVO);
	 int delete(EmpVO empVO);
}
