package clg.bvu.ocms.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import clg.bvu.ocms.service.DocumentService;
import clg.bvu.ocms.service.UserService;

@Controller
@RequestMapping(value="/StudentController")
public class StudentController {
	
private UserService userService;
private DocumentService documentrService;
	
	@Autowired
	@Qualifier("UserServiceImpl")
	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	
	@Autowired
	@Qualifier("DocumentServiceImpl")
	public void setDocumentService(DocumentService documentrService) {
		this.documentrService = documentrService;
	}
	
	@RequestMapping(value="/getUserDetails",method=RequestMethod.POST)
	@ResponseBody
	private  String getUserDetails(HttpServletRequest request){
		Integer userId=(Integer)request.getSession().getAttribute("user_id");
		return userService.getUserData(userId);
	}
	
	@RequestMapping(value="/getDocumentsDetails",method=RequestMethod.POST)
	@ResponseBody
	private  String getDocumentsDetails(HttpServletRequest request){
		Integer userId=(Integer)request.getSession().getAttribute("user_id");
		return documentrService.getDocumentData(userId);
	}
	
	@RequestMapping(value="/uploadDocument",method=RequestMethod.POST)
	@ResponseBody
	private  String uploadDocument(@RequestParam(value="document_file",required=true) MultipartFile file
			,@RequestParam(value="document_type",required=true) String type
			,HttpServletRequest request){
		Integer userId=(Integer)request.getSession().getAttribute("user_id");		
		return documentrService.uploadDocument(file,type,userId);
	}

	
}
