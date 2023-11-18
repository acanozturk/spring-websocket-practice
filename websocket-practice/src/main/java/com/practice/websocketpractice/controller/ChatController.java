package com.practice.websocketpractice.controller;

import com.practice.websocketpractice.data.payload.request.ChatMessageRequest;
import com.practice.websocketpractice.data.payload.response.ChatMessageResponse;
import com.practice.websocketpractice.service.ChatService;
import com.practice.websocketpractice.util.Constant;
import lombok.AllArgsConstructor;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessageHeaderAccessor;
import org.springframework.stereotype.Controller;

@Controller
@AllArgsConstructor
public class ChatController {

    private final ChatService chatService;

    @MessageMapping(Constant.Endpoint.JOIN)
    @SendTo(Constant.Topic.CHAT)
    public ChatMessageResponse joinRoom(@Payload final ChatMessageRequest chatMessageRequest,
                                        final SimpMessageHeaderAccessor headerAccessor) {
        headerAccessor.getSessionAttributes().put("username", chatMessageRequest.getSender());
        return chatService.sendMessage(chatMessageRequest);
    }

    @MessageMapping(Constant.Endpoint.CHAT)
    @SendTo(Constant.Topic.CHAT)
    public ChatMessageResponse sendMessage(@Payload final ChatMessageRequest chatMessageRequest) {
        return chatService.sendMessage(chatMessageRequest);
    }

}
