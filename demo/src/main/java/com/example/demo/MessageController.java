package com.example.demo;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.util.HtmlUtils;

@Controller
public class MessageController {
	
	
	@MessageMapping("/sendMessage")
	@SendTo("/message/wording")
	public TextMessage manageMessage(TextMessage inputMessage) {
		
		
		return new TextMessage ("This is the response from server. This is your message" + HtmlUtils.htmlEscape(inputMessage.getContent()));
	}
	
	

}
