package chat.test.websocket;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;

@ServerEndpoint(value="/huiWebSocket/{loginName}")
public class huiWebSocket {
	private Session session;
	private String userName;
	public static Map<String,Session> user3=new HashMap<String,Session>();
	public static Map<String,Session> getSocket(){
		return user3;
	}
	public static void setSocket(Map<String,Session> user) {
		huiWebSocket.user3=user;
	}
	@OnOpen
	public void openSocket(Session session,@PathParam("loginName")String loginName){
		this.session=session;
		userName=loginName;
		user3.put(userName, session);
		System.out.println("连接成功"+userName);
	}
	@OnMessage
	public void messageSocket(String message){
		String[] arr=message.split(",");
		String friendName=arr[0];
		Session session=user3.get(friendName);
		Session session2=user3.get(userName);
		System.out.println("friendName:"+friendName);
		System.out.println(arr[1]);
		try {
			if(session==null){
				session2.getBasicRemote().sendText("1");
			}else{
			session.getBasicRemote().sendText(userName+","+arr[1]);}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
