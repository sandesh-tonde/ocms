package clg.bvu.ocms.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import clg.bvu.ocms.model.User;
import clg.bvu.ocms.service.LoginService;

@Controller
@RequestMapping(value="/LoginController")
public class LoginController {
	
private LoginService loginService;
	
	@Autowired
	@Qualifier("LoginServiceImpl")
	public void setUserDetailsService(LoginService loginService) {
		this.loginService = loginService;
	}
	
	@RequestMapping(value="/login",method=RequestMethod.POST)
	private  String login(@RequestParam(value="username",required=true) String userName,
			@RequestParam(value="password",required=true) String password,
			HttpServletRequest request){
			User user= new User();
			user.setUserName(userName);
			user.setPassword(password);
			User u=loginService.validateLogin(user);
			if(u != null){
				request.getSession().setAttribute("user_id", u.getUserId());
				request.getSession().setAttribute("user_name", u.getName());
				request.getSession().setAttribute("user", u);
				if(u.getUserType().equalsIgnoreCase("student"))
					return "studentHome";
				else if(u.getUserType().equalsIgnoreCase("admin"))
					return "adminHome";
			}
			
			request.getSession().setAttribute("msg", "Invalid UserName or Password");
			return "login";
				
	}
	
	@RequestMapping(value="/logout",method=RequestMethod.GET)
	private  String logout(HttpServletRequest request)
	{
			request.getSession().invalidate();
			return "login";

	}

	
}
