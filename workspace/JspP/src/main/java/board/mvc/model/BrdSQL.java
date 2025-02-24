package board.mvc.model;

class BrdSQL {
	final static String LIST = "select * from BOARD order by SEQ desc LIMIT ? OFFSET ?";
	final static String INSERT = "insert into BOARD(WRITER, EMAIL, SUBJECT, CONTENT, FNAME, OFNAME, FSIZE, RDATE) values(?,?,?,?,?,?,?,now())";
	final static String GETBOARD = "select * from BOARD where SEQ = ?";
	final static String DELETE = "delete from BOARD where SEQ=?";
	final static String UPDATE = "update BOARD set EMAIL=?, SUBJECT=?, CONTENT=?, FNAME=?, OFNAME=?, FSIZE=? where SEQ=?";
	final static String RECORDS = "select count(*) from BOARD";
}
