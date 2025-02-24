package addr.mvc.model;

class AddrSQL {
	final static String LIST = "select * from ADDRESS order by SEQ desc";
	final static String INSERT = "insert into ADDRESS(NAME, ADDR, RDATE) values(?,?,now())";
	final static String DELETE = "delete from ADDRESS where SEQ=?";
	
	//for Ajax
	final static String SELECT_BY_SEQ = "select * from ADDRESS where SEQ=?";
	final static String SELECT_BY_NAME = "select * from ADDRESS where NAME like ? order by NAME";
}
