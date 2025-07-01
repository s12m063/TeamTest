package egovframework.example.gallery.service;

import java.util.List;

import org.springframework.stereotype.Service;

import egovframework.example.common.Criteria;

@Service
public interface GalleryService {
	List<?> selectGalleryList(Criteria criteria);
	int selectGalleryListTotCnt(Criteria criteria);//총갯수구하기
	int insert(GalleryVO galleryVO);                 // insert
	GalleryVO selectGallery(String uuid);            // 상세조회
}
