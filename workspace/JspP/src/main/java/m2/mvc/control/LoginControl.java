package m2.mvc.control;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import m2.mvc.model.LoginService;
import mvc.domain.Users;
import jakarta.servlet.http.HttpSession;

import static m2.mvc.model.LoginConst.*;

@WebServlet("/M2Project/login.do")
public class LoginControl extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	public void service(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        String m = request.getParameter("method");
        if(m == null) m = "login";

        switch(m) {
            case "login": login(request, response); break;
            case "loggedIn": loggedIn(request, response); break;
            case "logout": logout(request, response); break;
        }
    }

    public void login(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        request.getRequestDispatcher("login.jsp").forward(request, response);
    }

    public void loggedIn(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        String id = request.getParameter("id");
        String pwd = request.getParameter("pwd");
        
        // 디버깅 로그 추가
        System.out.println("Received parameters - ID: " + id + ", PWD: " + pwd);
        
        // null 체크 추가
        if(id == null || pwd == null) {
            System.out.println("ID or PWD is null");
            response.getWriter().write("FAILED");
            return;
        }

        LoginService service = LoginService.getInstance();
        int result = service.check(id, pwd);
        
        response.setContentType("text/plain;charset=UTF-8");
        System.out.println("Login check result: " + result);
        
        if(result == LOGGED_IN) {
            Users user = service.getUsers(id);
            HttpSession session = request.getSession();
            session.setAttribute("loggedIn", user);
            response.getWriter().write("LOGGED_IN");
        } else {
            response.getWriter().write("FAILED");
        }
    }

    public void logout(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        request.getRequestDispatcher("main.jsp").forward(request, response);
    }
}
