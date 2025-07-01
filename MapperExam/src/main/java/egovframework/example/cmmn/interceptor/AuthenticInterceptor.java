/**
 * 
 */
package egovframework.example.cmmn.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

/**
 * @author user
 *1)interceptor클래스만들기
 *2)그 클래스를 실행할 메뉴를 등록하는 일
 *-> 로그인이 필요없는 메뉴와 : 회원가입페이지 로그인 등
 *->로그인이 필요한 메뉴 : 부서,사원...등 구분해서 등록해야 한다
 */
public class AuthenticInterceptor extends HandlerInterceptorAdapter {

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
//		TODO:로그인체크
		// 1)session 가져오기 
		//사용법 : request.getSession(옵션)-false(세션이 없으면 만들지 않음)
//		기본은 true이다
		HttpSession session = request.getSession(false);
		// 2)session에 memberVO가 없으면 강제이동(로그인페이지)
		if (session == null || session.getAttribute("memberVO") == null) {
			response.sendRedirect("/login.do");//로그인강제이동
			return false;
		}
//		TODO:보안코딩:POST(입력/수정/삭제) 일때만
//	    사용법: request.getMethod(): post인지 get인지 가져오는 메소드
		if ("POST".equals(request.getMethod())) {
//			1)세션에서 CSRF_TOKEN을 가져오기
			String sessionToken = (String) session.getAttribute("CSRF_TOKEN");
//			2)JSP에서 csrf이름으로 쿼리스트링 정보 가져오기
			String requestToken = request.getParameter("csrf");
//			3)1,2를 같은지 비교: 다르면 에러처리
            if (sessionToken == null || !sessionToken.equals(requestToken)) {
                throw new Exception("csrf 위반입니다.");
             }
		}
		
		return true;//통과(클릭한 메뉴를 볼수있음)
	}
//	우리 회원인지 판단해서(세션에 있는지) 아니면 로그인 페이지로 강제이동
//	맞으면 해당 메뉴 사용가능
//	preHandle 오버라이딩
//	request: (jsp->컨트롤러로 정보전송)
//	response:(컨트롤러->jsp 정보전송)
	
}
