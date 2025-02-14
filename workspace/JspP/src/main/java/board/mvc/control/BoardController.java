package board.mvc.control;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import mvc.domain.Board;

import java.io.IOException;
import java.util.ArrayList;

import addr.mvc.model.AddrService;
import board.mvc.model.BrdService;

/**
 * Servlet implementation class BoardController
 */
@WebServlet("/board/brd.do")
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
			default: response.sendRedirect("brd.do");
			}
		}else {
			list(request, response);
		}
	}
	
	private void list(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException {
		
		BrdService service = BrdService.getInstance();
		ArrayList<Board> list = service.listS();
		request.setAttribute("list", list);
		
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
		Board board = new Board(-1L, writer, email, subject, content, null);
		
		BrdService service = BrdService.getInstance();
		boolean flag = service.insertS(board);
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
	        
	        Board board = new Board(seq, null, email, subject, content, null);
	        boolean flag = service.updateS(board);
	        request.setAttribute("flag", flag);
	        
	        String view = "msg.jsp";
	        RequestDispatcher rd = request.getRequestDispatcher(view);
	        rd.forward(request, response);
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













