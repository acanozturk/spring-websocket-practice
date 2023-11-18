package com.practice.websocketpractice.service;

import com.practice.websocketpractice.data.mapper.ChatMessageMapper;
import com.practice.websocketpractice.data.payload.request.ChatMessageRequest;
import com.practice.websocketpractice.data.payload.response.ChatMessageResponse;
import com.practice.websocketpractice.repository.ChatMessageRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ChatServiceImpl implements ChatService {

    private final ChatMessageRepository chatMessageRepository;

    @Override
    public ChatMessageResponse sendMessage(final ChatMessageRequest chatMessageRequest) {
        return ChatMessageMapper.INSTANCE.mapToResponse(chatMessageRequest);
    }

}
