package clg.bvu.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import clg.bvu.service.UserService;

@Controller
@RequestMapping(value="/StudentController")
public class StudentController {
	
private UserService userService;
	
	@Autowired
	@Qualifier("UserServiceImpl")
	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	
	@RequestMapping(value="/getUserDetails",method=RequestMethod.POST)
	@ResponseBody
	private  String getUserDetails(HttpServletRequest request){
		Integer userId=(Integer)request.getSession().getAttribute("user_id");
		return userService.getUserData(userId);
	}

}
