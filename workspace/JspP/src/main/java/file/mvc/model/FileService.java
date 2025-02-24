package file.mvc.model;

import java.io.*;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import file.mvc.control.FileController;
import file.mvc.fileset.Path;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
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
	
	public static class FileInfo{
		public String savedFileName; 	// fname
		public String originalFileName; // ofname
		public int fileSize; 			// fsize
	}
	
	public FileInfo saveFile(Part filePart) {
		String originalFileName = getSubmittedFileName(filePart);
		if(originalFileName == null || originalFileName.trim().length() == 0) {
			return null;
		}
		
//		long fSize = filePart.getSize();
//		long maxFileSize = FileController.class.getAnnotation(MultipartConfig.class).maxFileSize();
//		System.out.println("#fSize: " + fSize + ", maxFileSize: " + maxFileSize);
		
		String uploadPath = Path.FILE_STORE;
		File uploadDir = new File(uploadPath);
		if(!uploadDir.exists()) {
			uploadDir.mkdirs();
		}
		
		File saveFile = new File(uploadDir, originalFileName);
		saveFile = duplicateCheck(saveFile, originalFileName);
		String savedFileName = saveFile.getName();
		
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
			FileInfo fileInfo = new FileInfo();
            fileInfo.savedFileName = savedFileName;
            fileInfo.originalFileName = originalFileName;
            fileInfo.fileSize = (int)filePart.getSize();
			
			return fileInfo;
		}catch(IOException ie) {
			return null;
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
	
	public void download(HttpServletRequest request, HttpServletResponse response, File file) {
		try {
			String fname = file.getName();
			response.setContentType("application/octet-stream"); 
			String Agent=request.getHeader("USER-AGENT");
			if( Agent.indexOf("MSIE") >= 0 ){
				int i = Agent.indexOf( 'M', 2 );
				String IEV = Agent.substring( i + 5, i + 8 );
				if( IEV.equalsIgnoreCase("5.5") ){
					response.setHeader("Content-Disposition", "filename=" + new String( fname.getBytes("utf-8"), "8859_1") );
				}else{
					response.setHeader("Content-Disposition", "attachment;filename="+new String(fname.getBytes("utf-8"),"8859_1"));
				}
			}else{
				response.setHeader("Content-Disposition", "attachment;filename=" + new String( fname.getBytes("utf-8"), "8859_1") );
			}
			
			if(file.exists() && file.isFile()) {
				FileInputStream fis = null;
				BufferedInputStream bis = null;
				OutputStream os = null;
				BufferedOutputStream bos = null;
				try {
					fis = new FileInputStream(file);
					bis = new BufferedInputStream(fis, 2048);
					os = response.getOutputStream();
					bos = new BufferedOutputStream(os, 2048);
					
					int i = 0;
					byte b[] = new byte[1024];
					while ((i=bis.read(b)) != -1){
						bos.write(b, 0, i);
					}
					bos.flush();
				}catch(IOException ie) {
					
				}finally{
					try {
						if(bos != null)bos.close();
						if(os != null)os.close();
						if(bis != null)bis.close();
						if(fis != null)fis.close();
					}catch(IOException ie) {}
				}
			}
			
//			if(file.exists()) {
//				response.setContentType("application/octet-stream");
//				response.setHeader("content-Disposition", "attechment; filename=\""+fname+"\"");
//				response.setContentLength((int)file.length());
//				
//				try (FileInputStream in = new FileInputStream(file);
//			         OutputStream out = response.getOutputStream()) {
//		            byte[] buffer = new byte[4096];
//		            int bytesRead;
//		            while ((bytesRead = in.read(buffer)) != -1) {
//		                out.write(buffer, 0, bytesRead);
//		            }
//		        }
//			}
		}catch(UnsupportedEncodingException uee) {}
	}
	
	private File duplicateCheck(File saveFile, String fileName) {
		String fNameNoExtention = "";
		String extension = "";
		
		int idx = fileName.lastIndexOf(".");
		if(idx > 0) {
			fNameNoExtention = fileName.substring(0, idx);
			extension = fileName.substring(idx);
		}else {
			fNameNoExtention = fileName;
		}
		
		int count = 1;
		while(saveFile.exists()) {
			saveFile = new File(Path.FILE_STORE, fNameNoExtention + " ("+count+")"+extension);
			count++;
		}
		
		return saveFile;
	}

	public void deleteFile(String fname) {
		File file = new File(Path.FILE_STORE, fname);
		if(file.exists() && file.isFile()) {
			file.delete();
		}
	}
}

/*
(참고) [] 나 {} 가 포함된 파일이름을 다운로드 에러 발생 -> 해결은 server.xml의 다음을 수정 -> relaxedQueryChars="[]{}" 추가

<Connector connectionTimeout="20000" maxParameterCount="1000" port="8080" protocol="HTTP/1.1" redirectPort="8443" relaxedQueryChars="[]{}"/>
 */