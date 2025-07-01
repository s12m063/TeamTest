/**
 *
 */
 
$("#addForm").validate({
  rules: {
    // 유효성 검사 규칙
    	ename: {       // id별명
      required: true, // 필수 입력
      minlength: 2,   // 최소 입력 길이
    },
        job: {       // id별명
      required: true, // 필수 입력
      minlength: 2,   // 최소 입력 길이
    },
        manager: {       // id별명(숫자)
      required: true, // 필수 입력
      digits: true, // 숫자 형태로만 입력 가능하도록 설정
    },
        hiredate: {       // id별명(날짜)
      required: true, // 필수 입력
      date: true,         // 날짜 포맷(yyyy-MM-dd)
    },
        salary: {       // id별명
      required: true, // 필수 입력
      minlength: 2,   // 최소 입력 길이
    },
        commission: {       // id별명
      required: true, // 필수 입력
      digits: true, // 숫자 형태로만 입력 가능하도록 설정
    },
    	dno: {           //id별명
      required: true, // 필수 입력
      digits: true, // 숫자 형태로만 입력 가능하도록 설정
    }
  },
  messages: {
    // 오류값 발생시 출력할 메시지 수동 지정
    	ename: {   // id별명
      required: "필수 입력 항목입니다.",//화면에 보일 메세지
      minlength: "최소 {0}글자 이상 입력하세요.",//화면에 보일 메세지
    },
        job: {   // id별명
      required: "필수 입력 항목입니다.",//화면에 보일 메세지
      minlength: "최소 {0}글자 이상 입력하세요.",//화면에 보일 메세지
    },
        manager: {   // id별명
      required: "필수 입력 항목입니다.",//화면에 보일 메세지
      digits: "반드시 숫자만 입력하세요.",
    },
        hiredate: {   // id별명
      required: "필수 입력 항목입니다.",//화면에 보일 메세지
      digits: "날짜 포맷(yyyy-MM-dd)만 입력하세요.",
    },
        salary: {   // id별명
      required: "필수 입력 항목입니다.",//화면에 보일 메세지
      digits: "반드시 숫자만 입력하세요.",
    },
        commission: {   // id별명
      required: "필수 입력 항목입니다.",//화면에 보일 메세지
      digits: "반드시 숫자만 입력하세요.",
    },
    	dno: {
      required: "필수 입력 항목입니다.",
      digits: "반드시 숫자만 입력하세요.",
    }
  }
});
