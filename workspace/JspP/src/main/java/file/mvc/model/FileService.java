package file.mvc.model;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

import file.mvc.control.FileController;
import file.mvc.fileset.Path;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.http.Part;

public class FileService {
	//private FileDAO dao;  //DB사용시만 
	
	private static final FileService instance = new FileService();
	private FileService() {
		//dao = new FileDAO();
	}
	public static FileService getInstance() {
		return instance;
	}
	
	public boolean saveFile(Part filePart) {
		//System.out.println("FileService saveFile() filePart: " + filePart);
		String fileName = getSubmittedFileName(filePart);
		System.out.println("#fileName: " + fileName);
		
		long fSize = filePart.getSize();
		long maxFileSize = FileController.class.getAnnotation(MultipartConfig.class).maxFileSize();
		System.out.println("#fSize: " + fSize + ", maxFileSize: " + maxFileSize);
		
		String uploadPath = Path.FILE_STORE;
		File uploadDir = new File(uploadPath);
		if(!uploadDir.exists()) {
			uploadDir.mkdirs();
		}
		
		File saveFile = new File(uploadDir, fileName);
		InputStream is = null;
		FileOutputStream fos = null;
		try {
			is = filePart.getInputStream(); //Source 
			fos = new FileOutputStream(saveFile); //Destination 
			byte bs[] = new byte[1024];
			int i = 0;
			while((i=is.read(bs)) != -1) {
				fos.write(bs, 0, i);
			}
			fos.flush();
			
			return true;
		}catch(IOException ie) {
			return false;
		}finally {
			try {
				if(is != null) is.close();
				if(fos != null) fos.close();
			}catch(IOException ie) {}
		}
	}
	private String getSubmittedFileName(Part part) {
		String header = part.getHeader("content-disposition");
		for(String cd : header.split(";")) {
			if(cd.trim().startsWith("filename")) {
				String fileName = cd.substring(cd.indexOf('=') + 1).trim().replace("\"", "");
				return fileName.substring(fileName.lastIndexOf('/') + 1).substring(fileName.lastIndexOf('\\') + 1);
			}
		}
		return null;
	}
}