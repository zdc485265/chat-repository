package chat.controller;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;




import chat.entity.Group;
import chat.service.GroupService;
import chat.util.ChatResult;

@Controller
@RequestMapping("/group")
public class GroupIndexController {
	
	@Resource
	private GroupService groupService;
	
	@ResponseBody
	@RequestMapping("/index1.do")
	public ChatResult<List<Group>> execute(String userId){
		ChatResult<List<Group>> result=groupService.Index1(userId);
		System.out.println(result);
		return result;
		
	}
}
