package com.example.demo;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.util.HtmlUtils;

@Controller
public class LoginController {
	
	@MessageMapping("/login")
	@SendTo("/login/response")
	public LoginResponse textMessage(Login login) {
		
		System.out.println("Login: " + login);
		
		String result = "";
		boolean userNameResult = (login.getUserName()).equals("admin");
		boolean passwordResult = (login.getPassword()).equals("1234");
		boolean conditionalResult = userNameResult && passwordResult;
		System.out.println("Result conditional: "  + userNameResult + " " + passwordResult +" " + conditionalResult );
		
		if (conditionalResult) {
			result += " - Correct";
		} else  {
			result += " - Incorrect";
		}
		
		LoginResponse loginResponse = new LoginResponse ("Login: " + HtmlUtils.htmlEscape(login.getUserName()) + result);
		return loginResponse;
	}
	
	

}
