package chat.service;


import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import chat.dao.UserDao;
import chat.entity.User;
import chat.util.ChatResult;
import chat.service.UserService;

@Service("userService")
@Transactional
public class UserServiceImpl implements UserService{
	
	@Resource
	private UserDao userDao;
	public ChatResult<User> Login(String name, String password) {
		ChatResult<User> result=new ChatResult<User>();
		User user=userDao.findById(name);
		//����û���
		if(user==null){
			result.setStatus(1);
			result.setMsg("�û���������");
			return result;
		}
		//�������
		if(!user.getC_user_password().equals(password)){
			result.setStatus(1);
			result.setMsg("�������");
			return result;
		}
		result.setStatus(0);
		result.setMsg("��¼�ɹ�");
		result.setData(user);
		return result;
	}
	public ChatResult<User> Save(String userId, String userName,
			String password) {
		ChatResult<User> result=new ChatResult<User>();
		User hasuser=userDao.findById(userId);
		//����û�
		if(hasuser!=null){
			result.setStatus(1);
			result.setMsg("�û����ѱ���");
			return result;
		}
		User user=new User();
		user.setC_user_id(userId);
		user.setC_user_name(userName);
		user.setC_user_password(password);
		userDao.Save(user);
		result.setStatus(0);
		result.setMsg("ע��ɹ�");
		result.setData(user);
		return result;
	}
	public ChatResult<User> Sou(String fuserId) {
		ChatResult<User> result=new ChatResult<User>();
		User user=userDao.findById(fuserId);
		if(user==null){
			result.setStatus(1);
			result.setMsg("sou�޴���");
			return result;
		}
			result.setStatus(0);
			result.setData(user);
			result.setMsg("sou�ɹ�");
			return result;
	}

}
