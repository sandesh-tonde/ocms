package clg.bvu.ocms.service;

public interface BranchService {

	String getBraches();

	String saveBranch(String branchName, Integer availableSeats,
			Integer totalSeats);

}
