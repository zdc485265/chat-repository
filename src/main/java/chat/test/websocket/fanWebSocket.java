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
@ServerEndpoint(value="/fanWebSocket/{loginId}")
public class fanWebSocket {
	private String userId;
	private Session session;
	public static Map<String,Session> user2=new HashMap<String,Session>();
	public static Map<String,Session> getSessionUser(){
		return user2;
	}
	public static void setSessionUser(Map<String,Session> user){
		fanWebSocket.user2=user;
	}
	@OnOpen
	public void openSocket(Session session,@PathParam("loginId")String loginId){
		userId=loginId;
		this.session=session;
		user2.put(userId,session);
		System.out.println("连接成功"+userId);
	}
	@OnMessage
	public void messageSocket(String message){
		String friendId=message;
		Session session=user2.get(friendId);
		System.out.println("userId:"+userId);
		System.out.println("friendId:"+friendId);
		
		try {

			session.getBasicRemote().sendText(userId);

		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	@OnClose
	public void closeSocket(){
		System.out.println("关闭连接2");
	}
}
