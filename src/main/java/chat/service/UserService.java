package chat.service;


import chat.entity.User;
import chat.util.ChatResult;

public interface UserService {
	public ChatResult<User> Login(String name,String password);
	public ChatResult<User> Save(String userId,String userName,String password);
	public ChatResult<User> Sou(String fuserId);
}
