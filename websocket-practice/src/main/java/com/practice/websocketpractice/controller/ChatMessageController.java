package com.practice.websocketpractice.controller;

import com.practice.websocketpractice.data.payload.request.ChatMessageRequest;
import com.practice.websocketpractice.data.payload.response.ChatMessageResponse;
import com.practice.websocketpractice.service.ChatMessageService;
import com.practice.websocketpractice.util.Constant;
import lombok.AllArgsConstructor;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

@Controller
@AllArgsConstructor
public class ChatMessageController {

    private final ChatMessageService chatMessageService;

    @MessageMapping(Constant.Endpoint.CHAT)
    @SendTo(Constant.Topic.CHAT_MESSAGES)
    public ChatMessageResponse sendMessage(final ChatMessageRequest chatMessageRequest) {
        return chatMessageService.sendMessage(chatMessageRequest);
    }

}
