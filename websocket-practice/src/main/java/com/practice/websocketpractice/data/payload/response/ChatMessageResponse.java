package com.practice.websocketpractice.data.payload.response;

import com.practice.websocketpractice.data.enumeration.ChatMessageType;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public final class ChatMessageResponse {

    private String sender;
    private String content;
    private ChatMessageType chatMessageType;
    private String date;
    private String time;
    
}
