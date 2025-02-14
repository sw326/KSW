package addr.mvc.control;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import mvc.domain.Address;

import java.io.IOException;
import java.util.ArrayList;

import addr.mvc.model.AddrService;
import board.mvc.model.BrdService;

/**
 * Servlet implementation class AddrController
 */
@WebServlet("/address/addr.do")
public class AddrController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String m = request.getParameter("m");
		if(m != null) {
			m = m.trim();
			switch(m) {
			case "input": input(request, response); break;
			case "insert": insert(request, response); break;
			case "del": del(request, response); break;
			default: response.sendRedirect("addr.do");			}
		}else {
			list(request, response);
		}
	}
	private void list(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException  {
		AddrService service = AddrService.getInstance();
		ArrayList<Address> list = service.listS();
		request.setAttribute("list", list);
		
		String view = "list.jsp";
		RequestDispatcher rd = request.getRequestDispatcher(view);
		rd.forward(request, response);
	}
	
	private void input(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException  {
		response.sendRedirect("input.jsp");
	}
	
	private void insert(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException  {
		String name = request.getParameter("name");
		String addr = request.getParameter("addr");
		Address address = new Address(-1L, name, addr, null);
		
		AddrService service = AddrService.getInstance();
		boolean flag = service.insertS(address);
		request.setAttribute("flag", flag);
		
		String view = "msg.jsp";
		RequestDispatcher rd = request.getRequestDispatcher(view);
		rd.forward(request, response);
	}
	
	private void del(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException  {
		String seqStr = request.getParameter("seq");
		long seq = checkSeq(seqStr);
		if(seq != -1L) {
			AddrService service = AddrService.getInstance();
			service.deleteS(seq);
		}
		
		response.sendRedirect("addr.do");
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
