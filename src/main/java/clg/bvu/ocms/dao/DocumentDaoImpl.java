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

import clg.bvu.ocms.model.Documents;
import clg.bvu.ocms.model.User;

@Repository(value="DocumentDaoImpl")
public class DocumentDaoImpl implements DocumentDao {
	
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
	public List<Documents> getDocumentData(Integer userId) {
		Session session =sessionFactory.getCurrentSession();
		Criteria criteria = session.createCriteria(Documents.class , "Documents")
				.createAlias("Documents.user", "User")
				.add(Restrictions.eq("User.userId", userId));
				
		List<Documents> doc= criteria.list();
		return doc;
		
	}

	@Override
	public int setDocumentPath(String path, String type, Integer userId) {
		Session session =sessionFactory.getCurrentSession();
		try{
			User u=(User) session.load(User.class, userId);
			Documents doc =new Documents();
			doc.setUser(u);
			doc.setPath(path);
			doc.setType(type);
			doc.setStatus("Varification Pending");
			session.save(doc);
			return 1;
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public void updateDocumentStatus(Integer id, String status) {
		Session session =sessionFactory.getCurrentSession();
		try {
			Documents doc = (Documents) session.load(Documents.class, id);
			doc.setStatus(status);
			session.save(doc);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
