package egovframework.example.common;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import lombok.extern.log4j.Log4j;

@Log4j
@ControllerAdvice//컨트롤러에서 에러가발생하면 무조건 여기로 오게하는 어노테이션
//전역에러처리
public class CommonException {
//모든에러가 발생하면 이 메소드가 실행된다
//  컨트롤러에서 어떤 에러가 발생하더라도 이 함수가 실행됨
    @ExceptionHandler(Exception.class)//Exception.class특정예외클래스:특정예외클래스에해당하는에러가발생하면밑에메소드가실행된다
    public String internalServerErrorException(Exception e
    		, Model model
    		) {
        String errors = e.getMessage();//에러내용을 변수에 넣어서 모델에 전송한다 
        log.info("에러: " + errors);
        model.addAttribute("errors", errors);//에러를 모델에 담기
        
        return "errors";//jsp명
    }
}