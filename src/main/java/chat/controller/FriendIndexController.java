package chat.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import chat.entity.Friend;
import chat.service.FriendService;
import chat.util.ChatResult;

@RequestMapping("/friend")
@Controller
public class FriendIndexController {
	
	@Resource
	private FriendService friendService;
	
	@ResponseBody
	@RequestMapping("/index2.do")
	public ChatResult<List<Friend>> execute(String groupId){
		ChatResult<List<Friend>> result=friendService.Index2(groupId);
		System.out.println("friend result:"+result);
		return result;
	}
}
