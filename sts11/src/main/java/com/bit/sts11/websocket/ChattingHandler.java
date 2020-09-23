package com.bit.sts11.websocket;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

public class ChattingHandler extends TextWebSocketHandler {
	static Map<String, WebSocketSession> map= new HashMap<>();
	
	@Override
	public void afterConnectionEstablished(WebSocketSession session) throws Exception {
		session.sendMessage(new TextMessage(session.getId()+"님 입장하셨습니다"));
		map.put(session.getId(), session);
	}
	
	@Override
	protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
		System.out.println(message.getPayloadLength());
		Set<Entry<String, WebSocketSession>> entrys = map.entrySet();
		Iterator<Entry<String, WebSocketSession>> ite= entrys.iterator();
		while(ite.hasNext()) {
			Entry<String, WebSocketSession> entry=ite.next();
			entry.getValue().sendMessage(new TextMessage(session.getId()+">>"+message.getPayload()));
		}
	}
	
	@Override
	public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
		map.remove(session.getId());
	}
}
