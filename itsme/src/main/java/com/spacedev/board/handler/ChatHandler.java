package com.spacedev.board.handler;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
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
public class ChatHandler extends TextWebSocketHandler {

	private static List<WebSocketSession> sessionList = new ArrayList<>();
	Map<String, WebSocketSession> userSession = new HashMap<>();

	// message
	@Override
	protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
		// master status
		String masterStatus = null;
		if(userSession.containsKey("master")) {
			masterStatus = "online";
		} else {
			masterStatus = "offline";
		}
		
		// message content
		String senderId = (String) session.getAttributes().get("sessionId");
		String payload = message.getPayload();

		// sending time
		LocalDateTime currentTime = LocalDateTime.now();
		String time = currentTime.format(DateTimeFormatter.ofPattern("hh:mm a, E"));

		// message
		TextMessage msgToMe = new TextMessage(senderId + "&" + payload + "&" + time + "&" + masterStatus + "&true");
		TextMessage msgToOther = new TextMessage(senderId + "&" + payload + "&" + time + "&" + masterStatus + "&false");
		
		
		// as master, send a message to all
		if (senderId.equals("master")) {
			// send message every session(client)
			for (WebSocketSession s : sessionList) {
				if (s.equals(session)) {
					s.sendMessage(msgToMe); // send to myself
				} else {
					s.sendMessage(msgToOther); // send to other
				}
			}
		} else {	// as a guest send a message to master
			session.sendMessage(msgToMe);
			
			// if master logined, send a message
			if(userSession.containsKey("master"))  {
				userSession.get("master").sendMessage(msgToOther);
			}
		} // end else
	}

	// connection established
	@Override
	public void afterConnectionEstablished(WebSocketSession session) throws Exception {

		// save into session list
		sessionList.add(session);

		// save into userSession map
		String senderId = (String) session.getAttributes().get("sessionId");
		userSession.put(senderId, session);

		// enter message
		TextMessage msg = new TextMessage(senderId + " 님이 접속했습니다.");
		handleTextMessage(session, msg);

		log.info(session + " client connected");
	}

	// connection closed
	@Override
	public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {

		String senderId = (String) session.getAttributes().get("sessionId");
		sessionList.remove(session);
		userSession.remove(senderId);

		// exit message
		TextMessage msg = new TextMessage(senderId + " 님이 퇴장했습니다.");
		handleTextMessage(session, msg);

		log.info(session + "client disconnected");
	}

}
