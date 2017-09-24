package cn.spirithone.blog.oauth.controller;

import javax.enterprise.inject.Model;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import cn.spirithone.blog.oauth.dto.UserDto;

/**
 * 通用登陆控制器
 * @author Shawn_Hou
 *
 */
@Controller
@RequestMapping("/user")
public class UserController {
	
	@RequestMapping("/login")
	public String login(UserDto userDto) {
		if(userDto != null){
			
		}
		return "user/login";
	}
}
