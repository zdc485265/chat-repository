package chat.service;

import java.util.List;

import chat.entity.Friend;
import chat.util.ChatResult;

public interface FriendService {
	public ChatResult<List<Friend>> Index2(String groupId);
	public ChatResult<Friend> Save(String userId,String frienId);
}
