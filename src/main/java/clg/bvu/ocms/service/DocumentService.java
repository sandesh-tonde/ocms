package clg.bvu.ocms.service;

import org.springframework.web.multipart.MultipartFile;


public interface DocumentService {

	String getDocumentData(Integer userId);

	String uploadDocument(MultipartFile file, String type, Integer userId);

	String updateDocumentStatus(Integer id, String status);

}
