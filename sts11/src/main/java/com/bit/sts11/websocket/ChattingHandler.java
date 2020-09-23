package com.bit.sts11.websocket;

import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

public class ChattingHandler extends TextWebSocketHandler {
	
	@Override
	public void afterConnectionEstablished(WebSocketSession session) throws Exception {
		session.sendMessage(new TextMessage("입장하셨습니다"));
	}
	
	@Override
	public void handleMessage(WebSocketSession session, WebSocketMessage<?> message) throws Exception {
		session.sendMessage(message);
	}
	
	@Override
	public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {

	}
}
