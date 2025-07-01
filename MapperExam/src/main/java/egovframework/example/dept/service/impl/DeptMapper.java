package egovframework.example.dept.service.impl;

import java.util.List;

import org.egovframe.rte.psl.dataaccess.mapper.Mapper;

import egovframework.example.common.Criteria;
import egovframework.example.dept.service.DeptVO;

//Mybatis(마이바티스) 1)인터페이스(메소드명) 2)xml:sql문작성
//sql작성할 인터페이스
//DeptVO
@Mapper
public interface DeptMapper {
	public List<?> selectDeptList(Criteria criteria);//전체조회
	public int selectDeptListTotCnt(Criteria criteria);//총갯수구하기
	public int insert(DeptVO deptVO);//추가페이지 부서insert
	public DeptVO selectDept(int dno);//상세조회
	public int update(DeptVO deptVO);//update메소드
	public int delete(DeptVO deptVO);//DELETE메소드
}
