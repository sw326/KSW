package m2.mvc.control;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import m2.mvc.model.ReplyService;
import mvc.domain.Reply;
import java.util.List;
import java.io.IOException;

@WebServlet("/M2Project/reply.do")
public class ReplyController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String m = request.getParameter("method");
		switch(m) {
			case "replySave": replySave(request, response); break;
            case "replyList": replyList(request, response); break;
		}
	}

	private void replySave(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String content = request.getParameter("content");
        String writer = request.getParameter("writer");
        String pwdReply = request.getParameter("pwdReply");
        long boardIdx = Long.parseLong(request.getParameter("boardIdx"));
        long parentIdx = Long.parseLong(request.getParameter("parentIdx"));

        Reply reply = new Reply(-1L, boardIdx, content, writer, pwdReply, parentIdx, null, 0, 0, null);

        ReplyService replyService = ReplyService.getInstance();
        replyService.insertS(reply);

        response.sendRedirect(request.getContextPath() + "/M2Project/rb-content.do?method=content&idx=" + boardIdx);        
    }

    private void replyList(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        long boardIdx = Long.parseLong(request.getParameter("boardIdx"));
        ReplyService replyService = ReplyService.getInstance();
        List<Reply> replyList = replyService.selectAll(boardIdx);
        request.setAttribute("replyList", replyList);
        request.getRequestDispatcher("/M2Project/rb-content.do?method=content&idx=" + boardIdx).forward(request, response);
    }
}
