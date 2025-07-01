package egovframework.example.gallery.service.impl;

import java.util.List;

import org.egovframe.rte.psl.dataaccess.mapper.Mapper;

import egovframework.example.common.Criteria;
import egovframework.example.gallery.service.GalleryVO;

@Mapper
public interface GalleryMapper {
	public List<?> selectGalleryList(Criteria criteria);
	public int selectGalleryListTotCnt(Criteria criteria);//총갯수구하기
	public int insert(GalleryVO galleryVO);                 // insert
	public GalleryVO selectGallery(String uuid);            // 상세조회
}
