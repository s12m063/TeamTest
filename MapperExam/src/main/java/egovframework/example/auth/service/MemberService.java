package egovframework.example.auth.service;

import org.springframework.stereotype.Service;


public interface MemberService {
	MemberVO authenticate(MemberVO loginVO)throws Exception;//로그인메소드
	void register(MemberVO memberVO)throws Exception;//회원가입
}

