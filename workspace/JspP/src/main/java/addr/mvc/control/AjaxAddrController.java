package addr.mvc.control;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import mvc.domain.Address;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import addr.mvc.model.AddrService;

@WebServlet("/ajax/ajax.do")
public class AjaxAddrController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	public void service(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		String m = request.getParameter("m");
		if(m != null) {
			m = m.trim();
			switch (m) {
				case "form": form(request, response); break;
				case "search01": search01(request, response); break;
				case "search02": search02(request, response); break;
				case "auto_form": auto_form(request, response); break;
				default: form(request, response);
			}
		}else {
			form(request, response);
		}
	}
	private void form(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		String view = "ajax.jsp";
		RequestDispatcher rd = request.getRequestDispatcher(view);
		rd.forward(request, response);
	}
	private void search01(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		String seqStr = request.getParameter("seq");
		long seq = checkSeq(seqStr);
		
		String addressJson = "";
		if(seq != -1L) {
			//addressJson = "{\"seq\":\"2\", \"name\":\"홍길동\", \"addr\":\"제주시\", \"rdate\":\"2025-02-17\"}";
			
			//서비스를 호출해서 리턴된 Address 객체를 json형태로 변환해 줌
			AddrService service = AddrService.getInstance();
			Address address = service.selectBySeqS(seq);
			System.out.println("#AjaxAddrController address: " + address);
			
			addressJson 
			= "{\"seq\":"+address.getSeq()
			+ ", \"name\":\""+address.getName()
			+"\", \"addr\":\""+ address.getAddr()
			+"\", \"rdate\":\""+address.getRdate()
			+"\"}";
		}
		
		try {
			response.setContentType("application/json;charset=utf-8");
			PrintWriter pw = response.getWriter();
			pw.print(addressJson);
		}catch(IOException ie) {}
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
	private void search02(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		String na = request.getParameter("na");
		
		String addressJson = "[]";
		if(na != null && na.length() != 0) {
			na = na.trim();
			AddrService service = AddrService.getInstance();
			ArrayList<Address> list = service.selectByNameS(na);
			//System.out.println("AjaxAddrController search02() list: " + list);
			if(list.size() != 0) {
				addressJson = "[";
				for(Address address: list) {
					addressJson 
					+= "{\"seq\":"+address.getSeq()
					+ ", \"name\":\""+address.getName()
					+"\", \"addr\":\""+ address.getAddr()
					+"\", \"rdate\":\""+address.getRdate()
					+"\"}";
					
					addressJson += ",";
				}
				addressJson = addressJson.substring(0, addressJson.length()-1);
				addressJson += "]";
			}
		}
		
		try {
			response.setContentType("application/json;charset=utf-8");
			PrintWriter pw = response.getWriter();
			pw.print(addressJson);
		}catch(IOException ie) {}
	}
	
	private void auto_form(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		String view = "autocomplete.jsp";
		RequestDispatcher rd = request.getRequestDispatcher(view);
		rd.forward(request, response);
	}
}