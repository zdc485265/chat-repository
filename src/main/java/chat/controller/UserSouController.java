package chat.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import chat.entity.User;
import chat.service.UserService;
import chat.util.ChatResult;

@RequestMapping("/user")
@Controller
public class UserSouController {
	
	@Resource
	private UserService userService;
	
	@ResponseBody
	@RequestMapping("/sou.do")
	public ChatResult<User> execute(String fuserId){
		ChatResult<User> result=userService.Sou(fuserId);
		System.out.println("sou½á¹û£º"+result);
		
		return result;
	}
}
