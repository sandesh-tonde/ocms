package clg.bvu.ocms.dao;

import java.util.List;

import clg.bvu.ocms.model.Documents;

public interface DocumentDao {

	List<Documents> getDocumentData(Integer userId);

	int setDocumentPath(String path, String type, Integer userId);

	void updateDocumentStatus(Integer id, String status);

}
