/**
 * 
 */
package egovframework.example.gallery.service;

import org.springframework.web.multipart.MultipartFile;

import egovframework.example.common.Criteria;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * @author user
 * 퀴즈: 필드(MultipartFile image 추가)
 *     생성자 2개 추가
 *      1) String galleryTitle, byte[] galleryData
 *      2) String uuid, String galleryTitle, byte[] galleryData
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class GalleryVO extends Criteria{
	private String galleryTitle;
	private String uuid;
	private byte[] galleryData;
	private MultipartFile image;// 내부 목적 사용
	private String galleryFileUrl;
//	필드2개
	public GalleryVO(String galleryTile, byte[] galleryData) {
		super();
		this.galleryTitle = galleryTitle;
		this.galleryData = galleryData;
	}
//	필드3개
	public GalleryVO(String galleryTile, String uuid, byte[] galleryData) {
		super();
		this.galleryTitle = galleryTitle;
		this.uuid = uuid;
		this.galleryData = galleryData;
	}
}