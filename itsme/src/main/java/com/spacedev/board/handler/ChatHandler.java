package com.spacedev.board.handler;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import lombok.extern.log4j.Log4j2;


@Component
@Log4j2
public class ChatHandler extends TextWebSocketHandler{
	
	private static List<WebSocketSession> sessionList = new ArrayList<>();
	Map<String, WebSocketSession> userSession = new HashMap<>();
	
	// message
	@Override
	protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
		
		String senderId = (String) session.getAttributes().get("sessionId");
		String payload = message.getPayload();
		
		// send message every session(client)
		for(WebSocketSession s : sessionList) {
			// s.sendMessage(message);
			s.sendMessage(new TextMessage(senderId + ":" + payload));
		}
	}
	
	// connection established
	@Override
	public void afterConnectionEstablished(WebSocketSession session) throws Exception {
		sessionList.add(session);
		
		System.out.println("afterConnection session : " + session.getAttributes());
		String senderId = session.getId();
		userSession.put(senderId, session);
	
		TextMessage msg = new TextMessage("님이 접속했습니다.");
		
		handleTextMessage(session, msg);
		log.info(session + " client connected");
	}
	
	// connection closed
	@Override
	public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
		
		sessionList.remove(session);

		TextMessage msg = new TextMessage("님이 퇴장했습니다.");
		handleTextMessage(session, msg);
		
		log.info(session + "client disconnected");
	}

}
