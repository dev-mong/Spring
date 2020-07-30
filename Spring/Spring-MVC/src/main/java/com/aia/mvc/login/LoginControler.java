package com.aia.mvc.login;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.aia.mvc.login.model.LoginRequest;

@Controller
@RequestMapping("/login/login") //http://localhost:8080/mvc/login/login
public class LoginControler {
	
	//get 방식의 요청에 대한 처리 -> 로그인 폼 페이지 
	@RequestMapping(method = RequestMethod.GET)
	public String getLoginForm() {
		
		return "login/login";
		// /WEB-INF/views/login/login.jsp
	}
	
	//POST 방식 요청 처리 메서드 
	@RequestMapping(method = RequestMethod.POST)
	public String login(HttpServletRequest request, 
			@RequestParam("uid") String userId, 
			@RequestParam("upw") String userPw,
			@ModelAttribute("login") LoginRequest loginRequest
			) {

		String uid = request.getParameter("uid");
		String upw = request.getParameter("upw");
		
		System.out.println(uid + ' '+upw );
		
		System.out.println("----------------------------");
		
		System.out.println(userId);
		System.out.println(userPw);
		
		System.out.println(" ------------------------");
		System.out.println(loginRequest.getUid());
		System.out.println(loginRequest.getUpw());
		
		
		
		return "login/login";
	}
	
}
