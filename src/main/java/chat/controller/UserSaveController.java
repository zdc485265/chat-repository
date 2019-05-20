package chat.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import chat.entity.User;
import chat.service.UserService;
import chat.util.ChatResult;


@Controller
@RequestMapping("/user")
public class UserSaveController{
	@Resource
	private UserService userService;
	
	@ResponseBody
	@RequestMapping("/add.do")
	public ChatResult<User> execute(String userId,String userName,String password){
		
		System.out.println("userId:"+userId+"userName:"+userName+"password:"+password);
		ChatResult<User> result=userService.Save(userId, userName, password);
		return result;
		
	}

}
