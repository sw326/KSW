package m2.mvc.control;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;
import m2.mvc.model.ReboardService;
import mvc.domain.Reboard;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import file.mvc.fileset.Path;
import file.mvc.model.FileService;

@WebServlet(urlPatterns = {
        "/M2Project/rb-list.do",
        "/M2Project/rb-content.do",
        "/M2Project/rb-write.do",
        "/M2Project/rb-insert.do",
        "/M2Project/rb-edit.do",
        "/M2Project/rb-update.do",
        "/M2Project/rb-delete.do",
        "/M2Project/rb-rewrite.do",
        "/M2Project/rb-reply-save.do",
        "/M2Project/rb-reply-del.do",
        "/M2Project/rb-download.do"
})
@MultipartConfig(fileSizeThreshold = 1024 * 1024, // 1 MB
        maxFileSize = 1024 * 1024 * 10, // 10 MB
        maxRequestSize = 1024 * 1024 * 15 // 15 MB
)
public class ReboardController extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String uri = request.getRequestURI();
        String command = uri.substring(uri.lastIndexOf("/") + 1, uri.lastIndexOf(".do"));
        String method = request.getParameter("method");

        try {
            switch (command) {
                case "rb-list":
                    if ("list".equals(method)) {
                        list(request, response);
                    }
                    break;

                case "rb-content":
                    if ("content".equals(method)) {
                        content(request, response);
                        updateHit(request, response);
                    }
                    break;

                case "rb-write":
                    if ("write".equals(method)) {
                        write(request, response);
                    }
                    break;

                case "rb-insert":
                    if ("insert".equals(method)) {
                        insert(request, response);
                    }
                    break;

                case "rb-rewrite":
                    if ("rewrite".equals(method)) {
                        rewrite(request, response);
                    }
                    if ("insert".equals(method)) {
                        rewriteInsert(request, response);
                    }
                    break;

                case "rb-download":
                    if ("download".equals(method)) {
                        download(request, response);
                    }
                    break;

                case "rb-delete":
                    if ("delete".equals(method)) {
                        delete(request, response);
                    }
                    break;

                case "rb-edit":
                    if ("edit".equals(method)) {
                        edit(request, response);
                    }
                    break;

                case "rb-update":
                    if ("update".equals(method)) {
                        update(request, response);
                    }
                    break;

                default:
                    response.sendRedirect(request.getContextPath() + "/main.do");
            }
        } catch (Exception e) {
            log("Error in ReboardController: " + e.getMessage(), e);
            response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
        }
    }

    private void list(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ReboardService reService = ReboardService.getInstance();
        ArrayList<Reboard> list = reService.listS();

        request.setAttribute("list", list);

        String view = "list.jsp";
        request.getRequestDispatcher(view).forward(request, response);
    }

    private void content(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        ReboardService reService = ReboardService.getInstance();
        Reboard reboard = reService.contentS(Long.parseLong(request.getParameter("idx")));
        request.setAttribute("reboard", reboard);

        String view = "content.jsp";
        request.getRequestDispatcher(view).forward(request, response);
    }

    private void write(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String view = "write.jsp";
        request.getRequestDispatcher(view).forward(request, response);
    }

    private void insert(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String subject = request.getParameter("subject");
        String content = request.getParameter("content");
        String writer = request.getParameter("writer");
        String email = request.getParameter("email");
        String homepage = request.getParameter("homepage");
        String pwd = request.getParameter("pwd");

        Part filePart = request.getPart("fileName");
        FileService fileService = FileService.getInstance();
        FileService.FileInfo fileInfo = null;

        if (filePart != null && filePart.getSize() > 0) {
            fileInfo = fileService.saveFile(filePart);
        }

        Reboard reboard;
        if (fileInfo != null) {
            reboard = new Reboard(-1L, subject, content, writer, email, homepage, pwd, null, null, 0, 0, 0,
                    fileInfo.savedFileName, null);
        } else {
            reboard = new Reboard(-1L, subject, content, writer, email, homepage, pwd, null, null, 0, 0, 0, null, null);
        }

        ReboardService reService = ReboardService.getInstance();
        reService.insertS(reboard);

        response.sendRedirect(request.getContextPath() + "/M2Project/rb-list.do?method=list");
    }

    private void rewrite(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        ReboardService reService = ReboardService.getInstance();
        Reboard reboard = reService.contentS(Long.parseLong(request.getParameter("idx")));
        request.setAttribute("reboard", reboard);

        String view = "rewrite.jsp";
        request.getRequestDispatcher(view).forward(request, response);
    }

    private void rewriteInsert(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String subject = request.getParameter("subject");
        String content = request.getParameter("content");
        String writer = request.getParameter("writer");
        String email = request.getParameter("email");
        String homepage = request.getParameter("homepage");
        String pwd = request.getParameter("pwd");
        long parentIdx = Long.parseLong(request.getParameter("parentIdx"));

        Part filePart = request.getPart("fileName");
        FileService fileService = FileService.getInstance();
        FileService.FileInfo fileInfo = null;

        if (filePart != null && filePart.getSize() > 0) {
            fileInfo = fileService.saveFile(filePart);
        }

        ReboardService reService = ReboardService.getInstance();
        Reboard parentReboard = reService.contentS(parentIdx);

        long rootIdx = parentReboard.getRootIdx() == 0 ? parentIdx : parentReboard.getRootIdx();
        int newOrderNo = parentReboard.getOrderNo() + 1;

        // reService.updateOrderNo(
        // parentReboard.getRootIdx(),
        // parentReboard.getOrderNo()
        // );

        Reboard reboard;
        reboard = new Reboard(-1L, subject, content, writer, email, homepage, pwd,
                parentIdx, rootIdx, parentReboard.getDepth() + 1, newOrderNo,
                0, fileInfo != null ? fileInfo.savedFileName : null, null);

        reService.rewriteInsertS(reboard, parentIdx);

        response.sendRedirect(request.getContextPath() + "/M2Project/rb-list.do?method=list");
    }

    private void download(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String fileName = request.getParameter("fileName");
        File file = new File(Path.FILE_STORE, fileName);

        FileService fileService = FileService.getInstance();
        fileService.download(request, response, file);
    }

    private void updateHit(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        ReboardService reService = ReboardService.getInstance();
        reService.updateHitS(Long.parseLong(request.getParameter("idx")));
    }

    private void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ReboardService reService = ReboardService.getInstance();
        reService.deleteS(Long.parseLong(request.getParameter("idx")));

        response.sendRedirect(request.getContextPath() + "/M2Project/rb-list.do?method=list");
    }

    private void edit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ReboardService reService = ReboardService.getInstance();
        Reboard reboard = reService.editS(Long.parseLong(request.getParameter("idx")));
        request.setAttribute("reboard", reboard);

        String view = "edit.jsp";
        request.getRequestDispatcher(view).forward(request, response);
    }

    private void update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String idx = request.getParameter("idx");
        String subject = request.getParameter("subject");
        String content = request.getParameter("content");
        String writer = request.getParameter("writer");
        String email = request.getParameter("email");
        String homepage = request.getParameter("homepage");
        String pwd = request.getParameter("pwd");

        Part filePart = request.getPart("fileName");
        FileService fileService = FileService.getInstance();
        FileService.FileInfo fileInfo = null;

        if (filePart != null && filePart.getSize() > 0) {
            fileInfo = fileService.saveFile(filePart);
        }

        Reboard reboard;
        if (fileInfo != null) {
            reboard = new Reboard(Long.parseLong(idx), subject, content, writer, email, homepage, pwd, null, null, 0, 0,
                    0,
                    fileInfo.savedFileName, null);
        } else {
            reboard = new Reboard(Long.parseLong(idx), subject, content, writer, email, homepage, pwd, null, null, 0, 0,
                    0,
                    null, null);
        }

        ReboardService reService = ReboardService.getInstance();
        reService.updateS(reboard);

        response.sendRedirect(request.getContextPath() + "/M2Project/rb-list.do?method=list");
    }
}
