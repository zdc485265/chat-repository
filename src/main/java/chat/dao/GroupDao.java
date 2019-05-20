package chat.dao;

import java.util.List;

import chat.entity.Group;

public interface GroupDao {
	public List<Group> findByGroup(String userId);
}
