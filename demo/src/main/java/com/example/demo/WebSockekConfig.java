package com.example.demo;

import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;

public class WebSockekConfig implements WebSocketMessageBrokerConfigurer {

	public void configureMessageBroker(MessageBrokerRegistry configuration) {

		configuration.enableSimpleBroker("/message");
		configuration.setApplicationDestinationPrefixes("/app");

	}

	public void configureStompEndpoint (StompEndpointRegistry configuration) {
		configuration.addEndpoint("/gs-guide-websocket").withSockJS();
		
	}

}
