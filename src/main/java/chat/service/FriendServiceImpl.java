package chat.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import chat.dao.FriendDao;
import chat.dao.GroupDao;
import chat.dao.UserDao;
import chat.entity.Friend;
import chat.entity.Group;
import chat.entity.User;
import chat.util.ChatResult;


@Service("friendService")
@Transactional
public class FriendServiceImpl implements FriendService{
	
	@Resource
	private FriendDao friendDao;
	@Resource
	private UserDao userDao;
	@Resource
	private GroupDao groupDao;
	public ChatResult<List<Friend>> Index2(String groupId) {
		ChatResult<List<Friend>> result=new ChatResult<List<Friend>>();
		List<Friend> list=new ArrayList<Friend>();
		list=friendDao.findByFriend(groupId);
		if(list==null){
			result.setStatus(1);
			result.setMsg("friend失败");
			return result;
		}
		result.setStatus(0);
		result.setMsg("friend成功");
		result.setData(list);
		System.out.println(list);
		return result;
	}
	public ChatResult<Friend> Save(String userId,String friendId) {
		ChatResult<Friend> result=new ChatResult<Friend>();
		User user1=new User();
		User user2=new User();
		List<Group> list1=new ArrayList<Group>();
		List<Group> list2=new ArrayList<Group>();
		Friend friend1=new Friend();
		Friend friend2=new Friend();
		System.out.println(userId+","+userDao+","+friendId);
		
		user1=userDao.findById(userId);
		list1=groupDao.findByGroup(userId);
		String groupId1=list1.get(0).getC_group_id();
		
		user2=userDao.findById(friendId);
		list2=groupDao.findByGroup(friendId);
		String groupId2=list2.get(0).getC_group_id();
		
		if(user1!=null||user2!=null){
		friend1.setC_friend_id(user1.getC_user_id());
		friend1.setC_friend_name(user1.getC_user_name());
		friend1.setC_user_id(user2.getC_user_id());
		friend1.setC_group_id(groupId2);
		friendDao.saveFriend(friend1);
		
		friend2.setC_user_id(user1.getC_user_id());
		friend2.setC_group_id(groupId1);
		friend2.setC_friend_id(user2.getC_user_id());
		friend2.setC_friend_name(user2.getC_user_name());
		friendDao.saveFriend(friend2);
		result.setMsg("save成功");
		result.setStatus(0);
		return result;
		}
		result.setMsg("save失败");
		result.setStatus(1);
		return null;
	}

}
