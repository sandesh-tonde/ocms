package clg.bvu.ocms.dao;

import java.util.List;

import clg.bvu.ocms.model.Branch;

public interface BranchDao {

	List<Branch> getBraches();

	void saveBranch(Branch branch);

}
