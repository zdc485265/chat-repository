package chat.dao;

import java.util.List;

import chat.entity.Friend;

public interface FriendDao {
	public List<Friend> findByFriend(String groupId);
	public void saveFriend(Friend friend);
}
