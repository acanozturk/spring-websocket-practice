package com.practice.websocketpractice.data.payload.request;

import com.practice.websocketpractice.data.enumeration.ChatMessageType;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public final class ChatMessageRequest {

    private String sender;
    private String content;
    private ChatMessageType chatMessageType;

}
