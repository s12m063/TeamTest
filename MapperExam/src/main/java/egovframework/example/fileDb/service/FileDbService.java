package egovframework.example.fileDb.service;

import java.util.List;

import egovframework.example.common.Criteria;

public interface FileDbService {
	List<?> selectFileDbList(Criteria criteria);//전체조회
	int selectFileDbListTotCnt(Criteria criteria);//총갯수구하기
	int insert(FileDbVO fileDbVO);//insert
	FileDbVO selectFileDb(String uuid);            // 상세조회
	int delete(String uuid);						//삭제 
}
