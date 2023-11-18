package com.practice.websocketpractice.service;

import com.practice.websocketpractice.data.payload.request.ChatMessageRequest;
import com.practice.websocketpractice.data.payload.response.ChatMessageResponse;
import com.practice.websocketpractice.repository.ChatMessageRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

@Service
@AllArgsConstructor
public class ChatMessageServiceImpl implements ChatMessageService {
    
    private final ChatMessageRepository chatMessageRepository;
    
    @Override
    public ChatMessageResponse sendMessage(final ChatMessageRequest chatMessageRequest) {
        return new ChatMessageResponse(
                chatMessageRequest.from(),
                chatMessageRequest.text(),
                LocalDate.now().format(DateTimeFormatter.ofPattern("dd-MM-yyyy")),
                LocalTime.now().toString()
        );
    }
    
}
