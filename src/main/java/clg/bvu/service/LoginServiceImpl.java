package clg.bvu.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import clg.bvu.dao.LoginDao;
import clg.bvu.model.User;



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
