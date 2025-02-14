package board.mvc.model;

class BrdSQL {
	final static String LIST = "select * from BOARD order by SEQ desc";
	final static String INSERT = "insert into BOARD(WRITER, EMAIL, SUBJECT, CONTENT, RDATE) values(?,?,?,?,now())";
	final static String GETBOARD = "select * from BOARD where SEQ = ?";
	final static String DELETE = "delete from BOARD where SEQ=?";
	final static String UPDATE = "update BOARD set EMAIL=?, SUBJECT=?, CONTENT=? where SEQ=?";
}
