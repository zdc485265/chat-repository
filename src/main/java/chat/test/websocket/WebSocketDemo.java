package chat.test.websocket;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.websocket.OnClose;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;

@ServerEndpoint(value="/addWebSocket/{loginId}")
public class WebSocketDemo {
	private Session session;
	private String userId;
	public static Map<String,Session> user = new HashMap<String,Session>();
	public static Map<String,Session> getSessionUser(){
		return user;
	}
	public static void setSessionUser(Map<String,Session> user){
		WebSocketDemo.user=user;
	}
	@OnOpen
	public void openSocket(Session session,@PathParam("loginId") String loginId){
		this.session=session;
		userId=loginId;
		user.put(userId,session);
		System.out.println("连接成功"+userId);
	}
	
	@OnMessage
	public void dealSocket(String message){
		String friendId=message;
		Session session=user.get(friendId);
		System.out.println("处理数据"+session);
		System.out.println("userName:"+userId);
		System.out.println("friendName:"+friendId);
		try {
			session.getBasicRemote().sendText(userId);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	@OnClose
	public void closeSocket(){
		System.out.println("关闭连接");
	}
}
