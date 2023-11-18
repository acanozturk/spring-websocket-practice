package com.practice.websocketpractice.data.entity;

import com.practice.websocketpractice.data.enumeration.ChatMessageType;
import com.practice.websocketpractice.util.Constant;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = Constant.Collection.CHAT_MESSAGES)
@Data
@EqualsAndHashCode(callSuper = true)
public final class ChatMessage extends AuditedEntity {

    @Id
    private String id;
    
    private String sender;
    
    private String content;
    
    private ChatMessageType chatMessageType;
    
}
