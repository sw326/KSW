package file.mvc.control;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.*;

import java.io.File;
import java.io.IOException;
import java.util.Collection;

import file.mvc.model.FileService;

/**
 * Servlet implementation class FileController
 */
@WebServlet("/file/file.do")
@MultipartConfig(
		fileSizeThreshold = 1024 * 1024 * 10,  // 10MB
		maxFileSize = 1024 * 1024 * 20,       // 20MB
		maxRequestSize = 1024 * 1024 * 50     // 50MB
	)
public class FileController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String m = request.getParameter("m");
		if(m!=null) {
			m = m.trim();
			switch(m) {
			case "form": form(request, response); break;
			case "upload": upload(request, response); break;
			case "form_mt": form_mt(request, response); break;
			case "upload_mt": upload_mt(request, response); break;
			}
		}else {
			
		}
	}
	private void form(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.sendRedirect("form.jsp");
	}
	
	private void upload(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("name");
		Part filePart = request.getPart("file");
		
		FileService service = FileService.getInstance();
		boolean flag = service.saveFile(filePart);
		System.out.println(flag);
		if(flag) {
			System.out.println("업로드 성공");
		}else {
			System.out.println("업로드 실패");
		}
		
//		String contextPath = this.getServletContext().getRealPath("");
//		System.out.println(contextPath);
//		String uploadPath = contextPath + "upload" + File.separator + "tmp";
//		System.out.println(uploadPath);
	}
	
	private void form_mt(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.sendRedirect("form_mt.jsp");
	}
	
	private void upload_mt(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Collection<Part> col = request.getParts();
		FileService service = FileService.getInstance();
		
		for(Part part:col) {
			if(part.getSubmittedFileName() != null
					&& !part.getSubmittedFileName().isEmpty());
			if(part.getSize() > 0) {
				boolean flag = service.saveFile(part);
				if(flag) {
					System.out.println("업로드 성공");
				}else {
					System.out.println("업로드 실패");
				}				
			}
		}		
	}
}
