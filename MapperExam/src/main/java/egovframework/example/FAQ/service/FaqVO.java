package egovframework.example.FAQ.service;

import egovframework.example.common.Criteria;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
@Getter
@Setter
@AllArgsConstructor //모든필드 생성자
@NoArgsConstructor  //모두없는 생성자
@ToString
@EqualsAndHashCode(callSuper = false)
public class FaqVO extends Criteria{
	private int fno;
	private String title;
	private String content;
}
