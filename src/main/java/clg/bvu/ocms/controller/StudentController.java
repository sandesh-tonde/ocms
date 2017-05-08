package clg.bvu.ocms.controller;

import javax.servlet.http.HttpServletRequest;

import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import clg.bvu.ocms.service.BranchService;
import clg.bvu.ocms.service.DocumentService;
import clg.bvu.ocms.service.PreferencesService;
import clg.bvu.ocms.service.UserService;

@Controller
@RequestMapping(value="/StudentController")
public class StudentController {
	
private UserService userService;
private DocumentService documentrService;
private PreferencesService preferencesService;
private BranchService branchService;
	
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
	
	@Autowired
	@Qualifier("PreferencesServiceImpl")
	public void setPreferencesService(PreferencesService preferencesService) {
		this.preferencesService = preferencesService;
	}
	
	@Autowired
	@Qualifier("BranchServiceImpl")
	public void setBranchService(BranchService branchService) {
		this.branchService = branchService;
	}
	
	@RequestMapping(value="/getUserDetails",method=RequestMethod.POST)
	@ResponseBody
	private  String getUserDetails(HttpServletRequest request){
		try{
			Integer userId=(Integer)request.getSession().getAttribute("user_id");
			return userService.getUserData(userId);
		}
		catch(Exception e){
			JSONObject json = new JSONObject();
			try {
				json.put("msg", "Session Time Out Please Login");
			} catch (JSONException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			return json.toString();
		}
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
	
	@RequestMapping(value="/getPreferencesDetails",method=RequestMethod.POST)
	@ResponseBody
	private  String getPreferencesDetails(HttpServletRequest request){
		Integer userId=(Integer)request.getSession().getAttribute("user_id");		
		return preferencesService.getPreferences(userId);
	}

	@RequestMapping(value="/getBranchesDetails",method=RequestMethod.POST)
	@ResponseBody
	private  String getBranchesDetails(HttpServletRequest request){
		Integer userId=(Integer)request.getSession().getAttribute("user_id");		
		return branchService.getBraches();
	}
	
	@RequestMapping(value="/savePreferences",method=RequestMethod.POST)
	@ResponseBody
	private  String savePreferences(@RequestParam(value="option1",required=true) Integer option1
			,@RequestParam(value="option2",required=true) Integer option2
			,@RequestParam(value="option3",required=true) Integer option3
			,HttpServletRequest request){
		Integer userId=(Integer)request.getSession().getAttribute("user_id");		
		return preferencesService.savePreferences(option1,option2,option3,userId);
	}
	
}
