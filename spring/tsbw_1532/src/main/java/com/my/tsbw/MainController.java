package com.my.tsbw;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

// 실습 1 : 해당 클레스를 컨트롤로 만들어라. /tsbw 라우팅 처리하여
// "홈페이지" 문고 출력
// 스토리보드 -> 서비스의 메인 줄기 나눠서 -> 업무별로 컨트롤러 생성
@Controller
public class MainController {
	// 요청 : http://localhost:8080/tsbw
	@RequestMapping("/tsbw")
	@ResponseBody
	public String tsbw() {
		System.out.print("hi");
		return "홈페이지";		
	}
}
