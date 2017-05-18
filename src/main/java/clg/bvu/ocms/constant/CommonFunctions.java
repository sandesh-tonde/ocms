package clg.bvu.ocms.constant;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

import org.springframework.web.multipart.MultipartFile;

public class CommonFunctions {
	
	public static String writeDocumentAndGetFileDB_Path(MultipartFile file) throws IOException{
		byte[] bytes = file.getBytes();
	    String orignalFileName = file.getOriginalFilename();
		int index = orignalFileName.lastIndexOf(".");
		String fileName=UUID.randomUUID().toString()+orignalFileName.substring(index);
		File serverFile = new File(Constant.FILE_PATH+ fileName);
		BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(serverFile));
		stream.write(bytes);
		stream.close();
		return fileName;
	}
	 public static Date convertToDate(String stringDate){
		
	        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("MM/dd/yyyy H:mm a");
	        try
	        {
	        	String[] dateData =stringDate.split(" ");
	        	String m=dateData[dateData.length-1];
	        	if(m.equalsIgnoreCase("PM")){
	        		String time = dateData[dateData.length-2];//05/18/2017 2:25 PM
	        		int hrs=Integer.parseInt(time.split(":")[0]);
	        		if(hrs <12)
	        			hrs=hrs+12;
	        		dateData[dateData.length-2]=hrs+":"+time.split(":")[1];
	        		String newstringDate ="";
	        		for(String tmp :dateData)
	        			newstringDate=newstringDate+" "+tmp;
	        		
	        		Date date = simpleDateFormat.parse(newstringDate.trim());

		            System.out.println("date : "+date);
		            return date;
	        	}
	            Date date = simpleDateFormat.parse(stringDate);

	            System.out.println("date : "+date);
	            return date;
	        }
	        catch (ParseException ex)
	        {
	            System.out.println("Exception "+ex);
	        }
	        return new Date();
	 }

}
