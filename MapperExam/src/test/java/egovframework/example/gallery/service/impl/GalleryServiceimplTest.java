package egovframework.example.gallery.service.impl;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import egovframework.example.common.Criteria;
import egovframework.example.gallery.service.GalleryService;
import egovframework.example.gallery.service.GalleryVO;
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
class GalleryServiceimplTest {
	@Autowired
	GalleryService galleryService;
	@Test
	void testSelectGalleryList() {
//		여기서 각 메소드별 테스트 하면 된다 : 전체조회
//		1)테스트 조건 설정
		Criteria criteria = new Criteria();
		criteria.setSearchKeyword("");//검색어
		criteria.setFirstIndex(0);//1페이지(등차수열3)
		criteria.setPageUnit(3);//화면에보일개수(3)
//		2)실제 메소드 실행
		List<?> list = galleryService.selectGalleryList(criteria);
//		3)검증(확인):로그,DB확인,assert~
		log.info(list);
}
	@Test
	void testSelectGalleryListTotCnt() {
//		여기서 각 메소드별 테스트 하면 된다 : 전체조회
//		1)테스트 조건 설정
		Criteria criteria = new Criteria();
		criteria.setSearchKeyword("");//검색어
//		2)실제 메소드 실행
		int count = galleryService.selectGalleryListTotCnt(criteria);
//		3)검증(확인):로그,DB확인,assert~
		log.info(count);
	}
	@Test
	void testInsert() {
	}

	@Test
	void testSelectGallery() {
//      1) 테스트 조건(given):
      String uuid="12345671";
//      2) 실제 메소드실행(when)
      GalleryVO galleryVO=galleryService.selectGallery(uuid);
//      3) 검증(확인)(then): 로그 , DB 확인, assert~ (DB확인)   
      log.info(galleryVO);
	}
}