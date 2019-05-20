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
		//检查用户名
		if(user==null){
			result.setStatus(1);
			result.setMsg("用户名不存在");
			return result;
		}
		//检查密码
		if(!user.getC_user_password().equals(password)){
			result.setStatus(1);
			result.setMsg("密码错误");
			return result;
		}
		result.setStatus(0);
		result.setMsg("登录成功");
		result.setData(user);
		return result;
	}
	public ChatResult<User> Save(String userId, String userName,
			String password) {
		ChatResult<User> result=new ChatResult<User>();
		User hasuser=userDao.findById(userId);
		//检查用户
		if(hasuser!=null){
			result.setStatus(1);
			result.setMsg("用户名已被用");
			return result;
		}
		User user=new User();
		user.setC_user_id(userId);
		user.setC_user_name(userName);
		user.setC_user_password(password);
		userDao.Save(user);
		result.setStatus(0);
		result.setMsg("注册成功");
		result.setData(user);
		return result;
	}
	public ChatResult<User> Sou(String fuserId) {
		ChatResult<User> result=new ChatResult<User>();
		User user=userDao.findById(fuserId);
		if(user==null){
			result.setStatus(1);
			result.setMsg("sou无此人");
			return result;
		}
			result.setStatus(0);
			result.setData(user);
			result.setMsg("sou成功");
			return result;
	}

}
