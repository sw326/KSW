package m2.mvc.model;

import java.util.List;

import mvc.domain.Reply;

public class ReplyService {
    private ReplyDAO replyDAO;

    public ReplyService() {
        replyDAO = new ReplyDAO();
    }

    private static final ReplyService instance = new ReplyService();

    public static ReplyService getInstance() {
        return instance;
    }

    public void insertS(Reply reply) {
        replyDAO.insert(reply);
    }

    public List<Reply> selectAll(long boardIdx) {
        return replyDAO.selectAll(boardIdx);
    }
}
