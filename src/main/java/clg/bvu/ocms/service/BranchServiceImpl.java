package clg.bvu.ocms.service;

import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import clg.bvu.ocms.dao.BranchDao;
import clg.bvu.ocms.model.Branch;

@Service("BranchServiceImpl")
public class BranchServiceImpl implements BranchService {
	
	private BranchDao branchDao;

	@Autowired
	@Qualifier("BranchDaoImpl")
	public void setBranchDetailsDao(BranchDao branchDao) {
		this.branchDao = branchDao;
	}

	@Transactional(propagation = Propagation.REQUIRED, rollbackFor=Exception.class)
	@Override
	public String getBraches() {
		List<Branch> branches = branchDao.getBraches();
		JSONArray jsonArray= new JSONArray();
		for(Branch b : branches){
			
			try {
				JSONObject json = new JSONObject();
				json.put("branchId", b.getBranchId());
				json.put("branchName", b.getBranchName());
				json.put("availableSeats", b.getAvailableSeats());
				json.put("seats", b.getSeats());
				jsonArray.put(json);
			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return jsonArray.toString();
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED, rollbackFor=Exception.class)
	public String saveBranch(String branchName, Integer availableSeats,
			Integer totalSeats) {
		Branch branch = new Branch();
		branch.setBranchName(branchName);
		branch.setSeats(totalSeats);
		branch.setAvailableSeats(availableSeats);
		branchDao.saveBranch(branch);
		return new JSONObject().toString();
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED, rollbackFor=Exception.class)
	public String deleteBranch(Integer id) {
		branchDao.deleteBranch(id);
		return new JSONObject().toString();
	}

	
	


}
