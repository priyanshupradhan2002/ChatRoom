package com.example.chatapp.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;


@Configuration
@EnableWebSocketMessageBroker

public class WebSocketConfig implements WebSocketMessageBrokerConfigurer
{
	@Override
	public void configureMessageBroker(MessageBrokerRegistry config)
	{
		//configure the message broker to route message to the appropriate destination
		config.enableSimpleBroker("/topic");//For Subscribimg the topics
		config.setApplicationDestinationPrefixes("/app");//for sending message to the server
	}
	
    @Override
	public void registerStompEndpoints(StompEndpointRegistry registry)
	{
		registry.addEndpoint("/ws").withSockJS();
	}
}
