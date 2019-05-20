package chat.service;

import java.util.List;
import chat.entity.Group;
import chat.util.ChatResult;

public interface GroupService {
	public ChatResult<List<Group>> Index1(String userId);
}
