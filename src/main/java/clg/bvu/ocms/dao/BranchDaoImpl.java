package clg.bvu.ocms.dao;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import clg.bvu.ocms.model.Branch;
import clg.bvu.ocms.model.Documents;

@Repository(value="BranchDaoImpl")
public class BranchDaoImpl implements BranchDao {
	
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
	public List<Branch> getBraches() {
		Session session =sessionFactory.getCurrentSession();
		Criteria criteria = session.createCriteria(Branch.class);
		List<Branch> branches= criteria.list();
		return branches;
	}

	@Override
	public void saveBranch(Branch branch) {
		Session session =sessionFactory.getCurrentSession();
		try{
			session.save(branch);
		} catch(Exception e)
		{
			e.printStackTrace();
		}
		
	}

	@Override
	public void updateBranches(List<Branch> branch) {
		Session session =sessionFactory.getCurrentSession();
		try{
			for(Branch b :branch){
			session.update(b);
			}
		} catch(Exception e)
		{
			e.printStackTrace();
		}
		
	}
	
}
