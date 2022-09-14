package me.testmain.demospringsecurityform.account;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LogInOutController {

	@GetMapping("/login")
	public String loginForm() {
		/*
		 * POST 요청을 SpringSecurity 에서 제공하는 UsernamePasswordAuthenticationFilter 를 사용한다.
		 * */
		return "login"; 
	}
}
