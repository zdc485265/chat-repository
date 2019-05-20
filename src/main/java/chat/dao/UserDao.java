package chat.dao;

import java.util.List;

import chat.entity.User;

public interface UserDao {
	public User findById(String userId);
	public void Save(User user); 
	public List<User> findByGroup(String userId);
}
