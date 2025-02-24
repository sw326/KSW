package mvc.domain;

import java.sql.Date;

public class Reboard {
	private long idx;
	private String subject;
	private String content;
	private String writer;
	private String email;	
	private String homepage;
	private String pwd;
	private Long parentIdx;
	private Long rootIdx;
	private int depth;
	private int orderNo;
	private int hit;
	private String fileName;
	private Date createdAt;
	
	public Reboard() {}

	public Reboard(long idx, String subject, String content, String writer, String email, String homepage, String pwd,
			Long parentIdx, Long rootIdx, int depth, int orderNo, int hit, String fileName, Date createdAt) {
		this.idx = idx;
		this.subject = subject;
		this.content = content;
		this.writer = writer;
		this.email = email;
		this.homepage = homepage;
		this.pwd = pwd;
		this.parentIdx = parentIdx;
		this.rootIdx = rootIdx;
		this.depth = depth;
		this.orderNo = orderNo;
		this.hit = hit;
		this.fileName = fileName;
		this.createdAt = createdAt;
	}

	public long getIdx() {
		return idx;
	}

	public void setIdx(long idx) {
		this.idx = idx;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getHomepage() {
		return homepage;
	}

	public void setHomepage(String homepage) {
		this.homepage = homepage;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
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

	public int getHit() {
		return hit;
	}

	public void setHit(int hit) {
		this.hit = hit;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}
	
}
