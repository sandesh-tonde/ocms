package clg.bvu.ocms.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import clg.bvu.ocms.dao.LoginDao;
import clg.bvu.ocms.model.User;



@Service("LoginServiceImpl")
public class LoginServiceImpl implements LoginService {
	
	private LoginDao loginDao;

	@Autowired
	@Qualifier("LoginDaoImpl")
	public void setUserDetailsDao(LoginDao loginDao) {
		this.loginDao = loginDao;
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED, rollbackFor=Exception.class)
	public User validateLogin(User user) {
		return loginDao.validateLogin(user);
	}
}
