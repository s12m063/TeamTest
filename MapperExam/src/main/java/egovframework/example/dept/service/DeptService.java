package egovframework.example.dept.service;

import java.util.List;

import egovframework.example.common.Criteria;

public interface DeptService {
	 List<?> selectDeptList(Criteria criteria);//전체조회
	 int selectDeptListTotCnt(Criteria criteria);//총갯수구하기
	 int insert(DeptVO deptVO);//추가페이지 부서insert
	 DeptVO selectDept(int dno);//상세조회
	 int update(DeptVO deptVO);//update메소드
	 int delete(DeptVO deptVO);//DELETE메소드

}
