package board.mvc.control;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;
import mvc.domain.Board;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import board.mvc.model.BrdService;
import file.mvc.fileset.Path;
import file.mvc.model.FileService;

/**
 * Servlet implementation class BoardController
 */
@WebServlet("/board/brd.do")
@MultipartConfig(
	    fileSizeThreshold = 1024 * 1024, // 1 MB
	    maxFileSize = 1024 * 1024 * 10,  // 10 MB
	    maxRequestSize = 1024 * 1024 * 15 // 15 MB
	)
public class BoardController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void service(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		String m = request.getParameter("m");
		System.out.println(m);
		if(m != null) {
			m = m.trim();
			switch(m) {
			case "input": input(request, response); break;
			case "insert": insert(request, response); break;
			case "content": getBoard(request, response); break;
			case "delete": delete(request, response); break;
			case "update": update(request, response); break;
			case "download": download(request, response); break;
			default: response.sendRedirect("brd.do");
			}
		}else {
			list(request, response);
		}
	}
	
	private void list(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException {
		BrdService service = BrdService.getInstance();
		int curPage = request.getParameter("cp") 
				!= null ? Integer.parseInt(request.getParameter("cp")) : 1;
		int pageSize = request.getParameter("ps") 
				!= null ? Integer.parseInt(request.getParameter("ps")) : 10;
		
		ArrayList<Board> list = service.listS(curPage, pageSize);
		int totalRecords = service.getTotalRecords(); // 총 레코드 수가져오기
		int totalPages = (int) Math.ceil((double) totalRecords / pageSize); // 총 페이지 수 계산
		
		request.setAttribute("list", list);
		request.setAttribute("totalRecords", totalRecords);
		request.setAttribute("totalPages", totalPages);
		request.setAttribute("curPage", curPage);
		request.setAttribute("pageSize", pageSize);
		
		String view = "list.jsp";
		RequestDispatcher rd = request.getRequestDispatcher(view);
		rd.forward(request, response);
	}
	
	private void input(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.sendRedirect("input.jsp");
	}
	
	private void insert(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String writer = request.getParameter("writer");
		String email = request.getParameter("email");
		String subject = request.getParameter("subject");
		String content = request.getParameter("content");
		
		Part filePart = request.getPart("fname");
		
		FileService fileService = FileService.getInstance();
		FileService.FileInfo fileInfo = null;
		
		// 파일이 있을 경우에만 저장
		if(filePart != null && filePart.getSize() > 0) {
			fileInfo = fileService.saveFile(filePart);
		}
		
		Board board;
		if(fileInfo != null) {
			board = new Board(-1L, writer, email, subject, content, 
					fileInfo.savedFileName, 
					fileInfo.originalFileName, 
					fileInfo.fileSize, 
					null);
		}else {
			// 파일이 없을 경우
			board = new Board(-1L, writer, email, subject, content, null, null, 0, null);
		}
		
		BrdService brdService = BrdService.getInstance();
		boolean flag = brdService.insertS(board);
		request.setAttribute("flag", flag);
		
		
		String view = "msg.jsp";
		RequestDispatcher rd = request.getRequestDispatcher(view);
		rd.forward(request, response);
	}
	
	private void getBoard(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		BrdService service = BrdService.getInstance();
		long seq = Long.parseLong(request.getParameter("seq"));
		Board board = service.getBoardS(seq);
		request.setAttribute("board", board);
		
		String view = "content.jsp";
		RequestDispatcher rd = request.getRequestDispatcher(view);
		rd.forward(request, response);
	}
	
	private void delete(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String seqStr = request.getParameter("seq");
		long seq = checkSeq(seqStr);
		if(seq != -1L) {
			BrdService service = BrdService.getInstance();
			boolean flag = service.deleteS(seq);

			request.setAttribute("flag", flag);
		}

		String view = "msg.jsp";
		RequestDispatcher rd = request.getRequestDispatcher(view);
		rd.forward(request, response);
	}
	
	private void update(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String method = request.getMethod();
	    BrdService service = BrdService.getInstance();
	    String seqStr = request.getParameter("seq");
	    long seq = checkSeq(seqStr);
	    
	    if(method.equals("GET")) {
    		Board board = service.getBoardS(seq);
    		request.setAttribute("board", board);
	        String view = "update.jsp";
	        RequestDispatcher rd = request.getRequestDispatcher(view);
	        rd.forward(request, response);
	    } else { // POST
	        String email = request.getParameter("email");
	        String subject = request.getParameter("subject");
	        String content = request.getParameter("content");
	        String fname = request.getParameter("fname");
			String ofname = request.getParameter("ofname");
			int fsize = Integer.parseInt(request.getParameter("fsize")); 
	        
			Part filePart = request.getPart("fname");
	        Board board = new Board(seq, null, email, subject, content, fname, ofname, fsize, null);
	        boolean flag = service.updateS(board, filePart);
	        request.setAttribute("flag", flag);
	        
	        String view = "msg.jsp";
	        RequestDispatcher rd = request.getRequestDispatcher(view);
	        rd.forward(request, response);
	    }
	}
	
	private void download(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		String seqStr = request.getParameter("seq");
	    
	    // seqStr이 null이거나 비어 있는지 확인
	    if (seqStr == null || seqStr.trim().isEmpty()) {
	        response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Invalid request: seq parameter is missing.");
	        return; // 메서드 종료
	    }

	    long seq;
	    try {
	        seq = Long.parseLong(seqStr); // seqStr을 Long으로 변환
	    } catch (NumberFormatException e) {
	        response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Invalid request: seq parameter is not a valid number.");
	        return; // 메서드 종료
	    }
	    BrdService service = BrdService.getInstance();
	    Board board = service.getBoardS(seq); // 게시물 정보 가져오기
	    if (board != null) {
	        String fname = board.getFname(); // 파일 이름 가져오기
	        File file = new File(Path.FILE_STORE, fname);
	        
	        FileService fileService = FileService.getInstance();
	        fileService.download(request, response, file);
	    } else {
	        response.sendError(HttpServletResponse.SC_NOT_FOUND);
	    }
	}
	
	private long checkSeq(String seqStr) {
		if(seqStr == null) {
			return -1L;
		}else {
			seqStr = seqStr.trim();
			if(seqStr.length() == 0) {
				return -1L;
			}else {
				try {
					long seq = Long.parseLong(seqStr);
					return seq;
				}catch(NumberFormatException ne) {
					return -1L;
				}
			}
		}
	}
}













