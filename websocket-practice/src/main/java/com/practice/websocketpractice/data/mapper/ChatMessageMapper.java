package com.practice.websocketpractice.data.mapper;

import com.practice.websocketpractice.data.entity.ChatMessage;
import com.practice.websocketpractice.data.payload.request.ChatMessageRequest;
import com.practice.websocketpractice.data.payload.response.ChatMessageResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ChatMessageMapper {

    ChatMessageMapper INSTANCE = Mappers.getMapper(ChatMessageMapper.class);

    @Mapping(source = "sender", target = "createdBy")
    @Mapping(source = "sender", target = "updatedBy")
    ChatMessage mapToEntity(ChatMessageRequest chatMessageRequest);

    @Mapping(target = "date", expression = "java(com.practice.websocketpractice.util.DateTimeUtil.getCurrentDate())")
    @Mapping(target = "time", expression = "java(com.practice.websocketpractice.util.DateTimeUtil.getCurrentTime())")
    ChatMessageResponse mapToResponse(ChatMessageRequest chatMessageRequest);
    
}
