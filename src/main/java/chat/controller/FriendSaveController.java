package chat.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import chat.entity.Friend;
import chat.service.FriendService;
import chat.util.ChatResult;

@Controller
@RequestMapping("/friend")
public class FriendSaveController {
	@Resource
	private FriendService friendService;
	
	@ResponseBody
	@RequestMapping("/save.do")
	public ChatResult<Friend> execute(String userId,String friendId){
		ChatResult<Friend> result=friendService.Save(userId,friendId);
		System.out.println("Save"+result);
		return result;
	}
}
