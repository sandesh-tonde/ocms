package clg.bvu.ocms.dao;

import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import clg.bvu.ocms.model.User;




@Repository(value="LoginDaoImpl")
public class LoginDaoImpl implements LoginDao {

	@Autowired
	private HttpSession httpSession;
	
	private Logger log = Logger.getLogger(LoginDaoImpl.class.getClass());
	
	private SessionFactory sessionFactory;
	
	@Autowired
	@Qualifier("sessionFactory")
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	@Override
	public User validateLogin(User user)
	{
		Session session =sessionFactory.getCurrentSession();
		User u=null;
		try 
		{
			Criteria criteria = session.createCriteria(User.class)
					.add(Restrictions.eq("userName", user.getUserName()))
					.add(Restrictions.eq("password", user.getPassword()));
			u=(User) criteria.uniqueResult();
			
		}
		catch(DataAccessException e)
		{
			e.printStackTrace();
			log.error(e);	
		}
		catch (Exception e) 
		{
			e.printStackTrace();
			log.error(e);
		}
		return u;
		
	}

}
