/**
 * 
 */
package egovframework.example.auth.web;

import java.util.UUID;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import egovframework.example.auth.service.MemberService;
import egovframework.example.auth.service.MemberVO;

/**
 * 
 *
 */
@Controller
public class MemberController {
	@Autowired
	private MemberService memberService;
//	로그인화면열기
	@GetMapping("/login.do")
	public String loginView() {
		return "auth/login";
	}
//	로그인처리:보안목적
//	@GetMapping 1)조회(로그인도)=>id,암호(주소창에 표시)
//	@PostMapping 입력/수정/삭제=>id,암호(주소창에 표시안됨)
	@PostMapping("/loginProcess.do")//로그인시 postMapping을 쓰는 이유 id와 암호가 주소창에 표시 되기 때문에
	public String login(HttpSession session, @ModelAttribute MemberVO
			loginVO) throws Exception{
//		1)db에 입력된 유저가 있는지 확인:서비스의 로그인 메소드 실행
		MemberVO memberVO = memberService.authenticate(loginVO) ;
//		2)세션을 만든다:유저저장(세션은 정보를 임시로 저장하는 공간:서버컴퓨터spring에 저장된다)
		session.setAttribute("memberVO", memberVO);
//		db와 세션의 차이점 : db(영구적저장) vs 세션은(임시저장:컴퓨터재시작시사라진다)
//		2-2)보안코딩: csrf(사이트위조) 공격방어: 인증토큰(세션)
		session.setAttribute("CSRF_TOKEN", UUID.randomUUID().toString());
//		3)통과처리: 이동할 페이지 강제이동
		return "redirect:/";
	}
//	로그아웃 처리
	@GetMapping("/logout.do")
	public String logout(HttpSession session) {
//		세션전체삭제:세션 무효화
		session.invalidate();
		return "redirect:/login.do";	
	}
//	회원가입페이지열기
	@GetMapping("/register.do")
	public String registerView() {
		return "auth/register";
	}
//	회원가입처리
	@PostMapping("/register/addition.do")
	public String register(Model model, @ModelAttribute MemberVO
			memberVO) throws Exception{
//	서비스의 회원가입 메소드 실행
		memberService.register(memberVO);
//	성공메세지 jsp 전달
		model.addAttribute("msg","회원가입을 성공했습니다");
		return"auth/register";
	}
}
