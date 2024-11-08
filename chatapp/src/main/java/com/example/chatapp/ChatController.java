package com.example.chatapp;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessagingTemplate;

@Controller

public class ChatController
{
    private final SimpMessagingTemplate messagingTemplate;
    
    public ChatController(SimpMessagingTemplate messagingTemplate)
    {
    	this.messagingTemplate=messagingTemplate;
    }
    
    @GetMapping("/")
    public String index()
    {
    	return "chat";//Returns The Html View When USer Visit
    }
    
    @MessageMapping("/chat")
    public void sendMessage(String message)
    {
    	messagingTemplate.convertAndSend("/topic/messages", message);
    }
}
