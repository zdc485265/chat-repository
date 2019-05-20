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
public class UserLoginController {
	@Resource
	private UserService userService;
	
	@RequestMapping("/login.do")
	@ResponseBody
	public ChatResult<User> execute(String name,String password){
		
		System.out.println("name:"+name+"password:"+password);
		ChatResult result=userService.Login(name, password);
		return result;
	}
}
