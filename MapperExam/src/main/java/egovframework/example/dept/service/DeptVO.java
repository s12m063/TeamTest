/**
 * 
 */
package egovframework.example.dept.service;

import egovframework.example.common.Criteria;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * @author user
 *DB 부서 테이블의 정보를 임시 저장하는 클래스
 *자바표기법:카멜표기법(컬럼명):단어(소문자)+단어(첫글자대문자)
 *자바필드 == 테이블 컬럼
 *메소드는 Getter Setter 생성자들을(모든필드,모두없는 2개) 만들면 된다 = lombok 어노테이션으로 사용
 *부가기능 ToString() 오버라이딩, Equals, HashCode 오버라이딩
 *(참고)@EqualsAndHashCode(callSuper = false) 상속했을때 부모필드 제외 equals hashcode 만들어준다
 */
@Getter
@Setter
@AllArgsConstructor //모든필드 생성자
@NoArgsConstructor  //모두없는 생성자
@ToString
@EqualsAndHashCode(callSuper = false)
public class DeptVO extends Criteria{
//	DNO	NUMBER
//	DNAME	VARCHAR2(255 BYTE)
//	LOC	VARCHAR2(255 BYTE)
	private int dno; //부서번호 (기본키,시퀀스)
	private String dname; //부서명 
	private String loc; //부서위치 
}
