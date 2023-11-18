package com.practice.websocketpractice.service;

import com.practice.websocketpractice.data.payload.request.ChatMessageRequest;
import com.practice.websocketpractice.data.payload.response.ChatMessageResponse;

public interface ChatService {
    
    ChatMessageResponse sendMessage(ChatMessageRequest chatMessageRequest);
    
}
