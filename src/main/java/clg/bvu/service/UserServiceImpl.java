package clg.bvu.service;

import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import clg.bvu.dao.UserDao;
import clg.bvu.model.User;


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

}
