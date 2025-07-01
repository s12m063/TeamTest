/**
 * 
 */
package egovframework.example.gallery.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import egovframework.example.common.Criteria;
import egovframework.example.fileDb.service.impl.FileDbMapper;
import egovframework.example.gallery.service.GalleryService;
import egovframework.example.gallery.service.GalleryVO;

/**
 * @author user
 *
 */
@Service
public class GalleryServiceimpl implements GalleryService{
   @Autowired
   GalleryMapper galleryMapper;

//   전체조회
   @Override
   public List<?> selectGalleryList(Criteria criteria) {
      // TODO Auto-generated method stub
      return galleryMapper.selectGalleryList(criteria);
   }

@Override
public int selectGalleryListTotCnt(Criteria criteria) {
	// TODO Auto-generated method stub
	return galleryMapper.selectGalleryListTotCnt(criteria);
}

@Override
public int insert(GalleryVO galleryVO) {
	// TODO Auto-generated method stub
	return galleryMapper.insert(galleryVO);
}

@Override
public GalleryVO selectGallery(String uuid) {
	// TODO Auto-generated method stub
	return galleryMapper.selectGallery(uuid);
}

}
