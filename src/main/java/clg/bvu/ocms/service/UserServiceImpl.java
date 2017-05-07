package clg.bvu.ocms.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import clg.bvu.ocms.constant.CommonFunctions;
import clg.bvu.ocms.dao.UserDao;
import clg.bvu.ocms.model.Documents;
import clg.bvu.ocms.model.User;


@Service("UserServiceImpl")
public class UserServiceImpl implements UserService {
	
	private UserDao userDao;

	@Autowired
	@Qualifier("UserDaoImpl")
	public void setUserDetailsDao(UserDao userDao) {
		this.userDao = userDao;
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED, rollbackFor=Exception.class)
	public String getUserData(Integer userId) {
		
		User user=userDao.getUserData(userId);
		JSONObject JSON;//=new JSONObject();
		try {
			JSON=new JSONObject();
			JSON.put("id", user.getUserId());
			JSON.put("name", user.getName());
			JSON.put("rank", user.getRank());
			JSON.put("age", user.getAge());
			JSON.put("city", user.getCity());
			JSON.put("country", user.getCountry());
			JSON.put("seatNo", user.getSeatNo());
			JSON.put("councellingDate", user.getCouncellingDate());
			JSON.put("startTime", user.getStartTime());
			JSON.put("endTime", user.getEndTime());
			return JSON.toString();
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED, rollbackFor=Exception.class)
	public String getBatchWiseUserDetails(Integer batch) {
		List<User> users =userDao.getBatchWiseUserDetails(batch);
		
		JSONArray jsonArray = new JSONArray();
		for(User user : users){
			JSONObject JSON =new JSONObject();
			try {
				JSON.put("id", user.getUserId());
				JSON.put("name", user.getName());
				JSON.put("rank", user.getRank());
				JSON.put("age", user.getAge());
				JSON.put("city", user.getCity());
				JSON.put("country", user.getCountry());
				JSON.put("seatNo", user.getSeatNo());
				if(user.getCouncellingDate() != null)
					JSON.put("councellingDate", user.getCouncellingDate());
				else
					JSON.put("councellingDate", "-");
				if(user.getStartTime() != null)
					JSON.put("startTime", user.getStartTime());
				else
					JSON.put("startTime", "-");
				if(user.getEndTime() != null)
					JSON.put("endTime", user.getEndTime());
				else
					JSON.put("endTime","-");
				if(user.getPreference() != null)
					if(user.getPreference().getResult() != null)
					JSON.put("result", user.getPreference().getResult());
					else
					JSON.put("result","-");
				else
					JSON.put("result","-");
				if(user.getDocuments() != null){
					List<Documents> docs =user.getDocuments();
					JSONArray docsArray = new JSONArray();
					
					for(Documents doc : docs){
						JSONObject docJson =new JSONObject();
						try{
						docJson.put("type", doc.getType());
						docJson.put("path", doc.getPath());
						docJson.put("status", doc.getStatus());
						docsArray.put(docJson);
						}
						catch (Exception e){
							e.printStackTrace();
						}
					}
					JSON.put("docArray",docsArray);
				}
			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			jsonArray.put(JSON);
		}
		return jsonArray.toString();
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED, rollbackFor=Exception.class)
	public String setUserTimeSlot(String startDAte, String endDate,
			String[] userIds) {
		Date sDate= CommonFunctions.convertToDate(startDAte);
		Date eDate= CommonFunctions.convertToDate(endDate);
		List<Integer> userId= new ArrayList<Integer>();
		for(String id : userIds){
			userId.add(Integer.parseInt(id.trim()));
		}
		userDao.setUserTimeSlot(sDate,eDate,userId);
		return new JSONObject().toString();
	}

}
