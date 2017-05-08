package clg.bvu.ocms.service;

import java.io.IOException;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import clg.bvu.ocms.constant.CommonFunctions;
import clg.bvu.ocms.constant.Constant;
import clg.bvu.ocms.dao.DocumentDao;
import clg.bvu.ocms.model.Documents;


@Service("DocumentServiceImpl")
public class DocumentServiceImpl implements DocumentService {

	private DocumentDao documentDao;

	@Autowired
	@Qualifier("DocumentDaoImpl")
	public void setUserDetailsDao(DocumentDao documentDao) {
		this.documentDao = documentDao;
	}

	
	@Override
	@Transactional(propagation = Propagation.REQUIRED, rollbackFor=Exception.class)
	public String getDocumentData(Integer userId) {
		List<Documents> documents=documentDao.getDocumentData(userId);
		if(documents != null){
			JSONArray jsonArray = new JSONArray();
			for(Documents doc : documents){
			JSONObject json = new JSONObject();	
			try {
				json.put("type", doc.getType());
				json.put("path", doc.getPath());
				json.put("status", doc.getStatus());
				jsonArray.put(json);
			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			}
			return jsonArray.toString();
		}
		return null;
	}


	@Override
	@Transactional(propagation = Propagation.REQUIRED, rollbackFor=Exception.class)
	public String uploadDocument(MultipartFile file,String type,Integer userId) {
		try {
			String fileName=CommonFunctions.writeDocumentAndGetFileDB_Path(file);
			String path=Constant.DATABASE_IMAGE_PATH+fileName;
			int i=documentDao.setDocumentPath(path,type,userId);
			if(i==1){
				JSONObject json =new JSONObject();
				try {
					json.put("msg", "File Uploaded Sucessfully");
				} catch (JSONException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				return json.toString();
			} else {
				JSONObject json =new JSONObject();
				try {
					json.put("msg", "File Uploading Errors");
				} catch (JSONException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				return json.toString();
				
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}


	@Override
	@Transactional(propagation = Propagation.REQUIRED, rollbackFor=Exception.class)
	public String updateDocumentStatus(Integer id, String status) {
		documentDao.updateDocumentStatus(id,status);
		return new JSONObject().toString();
	}


	
}
