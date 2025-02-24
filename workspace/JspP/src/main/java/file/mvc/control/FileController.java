package file.mvc.control;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;

import java.io.File;
import java.io.FileInputStream;
import java.io.OutputStream;
import java.io.IOException;
import java.util.Collection;

import file.mvc.fileset.Path;
import file.mvc.model.FileService;

@WebServlet("/file/file.do")
@MultipartConfig(
	fileSizeThreshold = 1024 * 1024 * 10,  // 10MB
	maxFileSize = 1024 * 1024 * 20,       // 20MB
	maxRequestSize = 1024 * 1024 * 50     // 50MB
)
public class FileController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	public void service(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		String m = request.getParameter("m");
		if(m != null) {
			m = m.trim();
			switch(m) {
				case "form": form(request, response); break;
				case "upload": upload(request, response); break;
				case "form_mt": form_mt(request, response); break;
				case "upload_mt": upload_mt(request, response); break;
				case "list": list(request, response); break;
				case "del": del(request, response); break;
				case "download": download(request, response); break;
				default: response.sendRedirect("file.do");
			}
		}else {
			list(request, response); 
		}
	}
	private void form(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		response.sendRedirect("form.jsp");
	}
	private void upload(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		String name = request.getParameter("name");
		Part filePart = request.getPart("file");
		
		FileService serivce = FileService.getInstance();
		serivce.saveFile(filePart);
			
		//String contextPath = this.getServletContext().getRealPath("");
		//System.out.println("contextPath: " + contextPath);
		//String uploadPath = contextPath + "upload"+File.separator+"tmp";
		//System.out.println("uploadPath: " + uploadPath);
		
		response.sendRedirect("file.do");
	}
	private void form_mt(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		response.sendRedirect("form_mt.jsp");
	}
	private void upload_mt(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		FileService serivce = FileService.getInstance();

		Collection<Part> col = request.getParts();
		for(Part filePart: col) {
			serivce.saveFile(filePart);
			//if(flag) System.out.println("업로드 성공");
			//else System.out.println("업로드 실패");
		}
		System.out.println("모두 업로드 완료");
		
		response.sendRedirect("file.do");
	}
	private void list(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		String uploadPath = Path.FILE_STORE;
		File uploadDir = new File(uploadPath);
		if(!uploadDir.exists()) {
			uploadDir.mkdirs();
		}
		
		File files[] = uploadDir.listFiles();
		request.setAttribute("files", files);
		
		String view = "list.jsp";
		RequestDispatcher rd = request.getRequestDispatcher(view);
		rd.forward(request, response);
	}
	private void del(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		String fname = request.getParameter("fname");
		File f = new File(Path.FILE_STORE, fname);
		if(f.exists()) f.delete();
		
		response.sendRedirect("file.do");
	}
	
	private void download(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		String fname = request.getParameter("fname");
		File file = new File(Path.FILE_STORE, fname);
		
		FileService service = FileService.getInstance();
		service.download(request, response, file);
		
		response.sendRedirect("file.do");
	}
}