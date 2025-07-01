package egovframework.example.fileDb.service.impl;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import egovframework.example.common.Criteria;
import egovframework.example.fileDb.service.FileDbService;
import egovframework.example.fileDb.service.FileDbVO;

@Service
public class FileDbServiceimpl implements FileDbService{
	
	@Autowired
	FileDbMapper fileDbMapper;
	
	@Override
	public List<?> selectFileDbList(Criteria criteria) {
		// TODO Auto-generated method stub
		return fileDbMapper.selectFileDbList(criteria);
	}
	@Override
	public int selectFileDbListTotCnt(Criteria criteria) {
		// TODO Auto-generated method stub
		return fileDbMapper.selectFileDbListTotCnt(criteria);
	}
//	
	@Override
	public int insert(FileDbVO fileDbVO) {
//		1)uuid만들기(기본키):자바에서 중복안되게 만들어주는 글자(랜덤)
		String newUuid =UUID.randomUUID().toString();
//		2)다운로드url을만들어야한다 
		String downloadURL = generateDownloadUrl(newUuid);
//		3)filedbvo에 새로만든 uuid와 url을 저장
		fileDbVO.setUuid(newUuid);
		fileDbVO.setFileUrl(downloadURL);
//		4)db insert
		return fileDbMapper.insert(fileDbVO);
	}
//	다운로드url을 만들어주는 메소드 url:웹브라우저주소창 또는 img 태그 -> 해당하는 컨트롤러 메소드가 임지를 전송해 줌
	   public String generateDownloadUrl(String uuid) {
//	       인터넷주소체계:http://localhost:8080/경로(path)?쿼리스트링 
//		   기본주소 (ContextPath): http://localhost:8080
//		   url을 만들어주는 클래스:ServletUriComponentsBuilder
		   return ServletUriComponentsBuilder      
	          .fromCurrentContextPath()//기본주소만들어준다
	          .path("/fileDb/download.do")//경로를붙여주는함수
	          .query("uuid="+uuid)//?uuid=+uuid값 쿼리스트링을붙여주는함수
	          .toUriString();//조합
//		   http://localhost:8080/fileDb/download.do?uuid=uuid값
	   }
	@Override
	public FileDbVO selectFileDb(String uuid) {
		// TODO Auto-generated method stub
		return fileDbMapper.selectFileDb(uuid);
	}
	@Override
	public int delete(String uuid) {
		// TODO Auto-generated method stub
		return fileDbMapper.delete(uuid);
	}
	
}