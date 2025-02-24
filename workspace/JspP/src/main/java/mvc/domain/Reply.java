package mvc.domain;

import java.sql.Date;

public class Reply {
    private long idxReply;
    private long boardIdx;
    private String content;
    private String writer;
    private String pwdReply;
    private Long parentIdx;
    private Long rootIdx;
    private int depth;
    private int orderNo;
    private Date createdAt;

    public Reply() {}

    public Reply(long idxReply, long boardIdx, String content, String writer, 
                String pwdReply, Long parentIdx, Long rootIdx, int depth, 
                int orderNo, Date createdAt) {
        this.idxReply = idxReply;
        this.boardIdx = boardIdx;
        this.content = content;
        this.writer = writer;
        this.pwdReply = pwdReply;
        this.parentIdx = parentIdx;
        this.rootIdx = rootIdx;
        this.depth = depth;
        this.orderNo = orderNo;
        this.createdAt = createdAt;
    }

    public long getIdxReply() {
        return idxReply;
    }
    public void setIdxReply(long idxReply) {
        this.idxReply = idxReply;
    }

    public long getBoardIdx() {
        return boardIdx;
    }
    public void setBoardIdx(long boardIdx) {
        this.boardIdx = boardIdx;
    }

    public String getContent() {
        return content;
    }
    public void setContent(String content) {
        this.content = content;
    }

    public String getWriter() {
        return writer;
    }
    public void setWriter(String writer) {
        this.writer = writer;
    }

    public String getPwdReply() {
        return pwdReply;
    }
    public void setPwdReply(String pwdReply) {
        this.pwdReply = pwdReply;
    }

    public Long getParentIdx() {
        return parentIdx;
    }
    public void setParentIdx(Long parentIdx) {
        this.parentIdx = parentIdx;
    }

    public Long getRootIdx() {
        return rootIdx;
    }
    public void setRootIdx(Long rootIdx) {
        this.rootIdx = rootIdx;
    }

    public int getDepth() {
        return depth;
    }
    public void setDepth(int depth) {
        this.depth = depth;
    }

    public int getOrderNo() {
        return orderNo;
    }
    public void setOrderNo(int orderNo) {
        this.orderNo = orderNo;
    }

    public Date getCreatedAt() {
        return createdAt;
    }
    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }
}
