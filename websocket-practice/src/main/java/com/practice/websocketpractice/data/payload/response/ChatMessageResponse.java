package com.practice.websocketpractice.data.payload.response;

public record ChatMessageResponse(String from, String text, String date, String time) {
    
}
