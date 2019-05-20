package chat.service;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import chat.dao.GroupDao;
import chat.entity.Group;
import chat.util.ChatResult;


@Service("groupService")
@Transactional
public class GroupServiceImpl implements GroupService{
	
	@Resource
	private GroupDao groupDao;
	
	public ChatResult<List<Group>> Index1(String userId) {
		ChatResult<List<Group>> result=new ChatResult<List<Group>>();
		List<Group> list=new ArrayList<Group>();
		list=groupDao.findByGroup(userId);
		if(list==null){
			result.setStatus(1);
			result.setMsg("groupʧ��");
			return result;
		}
		result.setStatus(0);
		result.setMsg("group�ɹ�");
		result.setData(list);
		System.out.println("list:");
		System.out.println(list);
		return result;
	}

}
