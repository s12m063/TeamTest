package egovframework.example.emp.service.impl;

import java.util.List;

import org.egovframe.rte.psl.dataaccess.mapper.Mapper;

import egovframework.example.common.Criteria;
import egovframework.example.emp.service.EmpVO;

//Mybatis(마이바티스) 1)인터페이스(메소드명) 2)xml:sql문작성
//sql작성할 인터페이스
//DeptVO
@Mapper
public interface EmpMapper {
	public List<?> selectEmpList(Criteria criteria);//전체조회
	public int selectEmpListTotCnt(Criteria criteria);//총갯수구하기
	public int insert(EmpVO empVO);
	public EmpVO selectEmp(int eno);
	public int update(EmpVO empVO);
	public int delete(EmpVO empVO);
}
