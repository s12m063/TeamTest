package egovframework.example.FAQ.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import egovframework.example.FAQ.service.FaqService;
import egovframework.example.common.Criteria;
import lombok.extern.log4j.Log4j2;
@Log4j2//이건**로그를 찍는 도구 log.info()를쓸수있게해주는표시
@Controller//컨트롤러 교통정리 경찰관 요청을 받는 경찰관//이클래스는컬트롤러야라고스프링에게 알려주는표시
public class FaqController {

		@Autowired//스프링이 자동으로 DeptService객체를넣어준다
		private FaqService faqService;//실제일을처리하는도우미비서이다 경찰이전화하면비서가자료를가져다주는느낌

		@GetMapping("/faq/faq.do")//Model model 데이터를 화면jsp로 보내주는 가방
		public String selectFaqList(@ModelAttribute Criteria criteria, Model model) {
			log.info(criteria);
//			서비스한테부서목록줘라고 요청한다
			List<?> list = faqService.selectFaqList(criteria);//서비스에게 데이터 요청
			log.info(list);
//			받은 목록을 model 가방에 담는다
			model.addAttribute("list", list);//list를 jsp 화면에 보냄
//			마지막줄은 dept_all.jsp 보여줘라는 뜻이다
			return "faq/faq_all";//보여줄 jsp 화면이름
		}
}