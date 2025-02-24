package login.mvc.control;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import login.mvc.model.LoginService;
import mvc.domain.Member;

import java.io.IOException;
import static login.mvc.model.LoginConst.*;

@WebServlet("/login/login.do")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String m = request.getParameter("m");
		if(m !=null) {
			m = m.trim();
			switch(m) {
			case "form": form(request, response); break;
			case "check": check(request, response); break;
			case "logout":logout(request, response); break;
			}
		}else {
			response.sendRedirect("../");
		}
	}
	private void form(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String view = "login.jsp";
		response.sendRedirect(view);
	}
	
	private void check(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// DB의 id/pw와 user의 id/pw를 비교
		//1. user의 id/pw 받음
		String email = request.getParameter("id");
		String pwd = request.getParameter("pwd");
		//유효성검사 ( Client: js, Server: java, DB: constraint )
		LoginService service = LoginService.getInstance();
		int result = service.check(email, pwd);
		System.out.println("check "+result);
		if(result == YES_ID_PWD) {
			Member m = service.getMemberS(email);
			HttpSession session = request.getSession();
			session.setAttribute("loginOkUser", m);
			
//			request.setAttribute("loggedIn", "true");
//		}else {
//			request.setAttribute("loggedIn", "false");
		}
		request.setAttribute("result", result);
		
		String view = "msg.jsp";
		RequestDispatcher rd = request.getRequestDispatcher(view);
		rd.forward(request, response);
		//System.out.println();
	}
	
	private void logout(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		if(session != null) {
			session.invalidate();
		}
		String view = "../";
		response.sendRedirect(view);
	}

}
