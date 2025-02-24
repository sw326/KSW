package m2.mvc.model;

public class ReboardSQL {
	// ReboardSQL.java
	final static String LIST = "SELECT * FROM reboard " +
			"ORDER BY COALESCE(root_idx, idx) desc, " + // root_idx가 NULL이면 자신의 idx 사용
			//"parent_idx asc, " + // 같은 그룹 내에서 부모 순서대로
			"order_no asc"; // 같은 부모 아래에서 순서대로

	final static String INSERT = "INSERT INTO reboard (subject, content, writer, email, homepage, pwd, " +
			"parent_idx, root_idx, depth, order_no, hit, filename, created_at) " +
			"VALUES (?, ?, ?, ?, ?, ?, NULL, NULL, 0, " +
			"(SELECT COALESCE(MAX(order_no) + 1, 0) FROM reboard r2 WHERE root_idx IS NULL), " + // 최상위 글들 중 마지막 순서
			"0, ?, NOW())";

	final static String REWRITE_INSERT = "INSERT INTO reboard (subject, content, writer, email, homepage, pwd, " +
			"parent_idx, root_idx, depth, order_no, hit, filename, created_at) " +
			"VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, 0, ?, NOW())";

	final static String SELECT_BY_IDX = "SELECT * FROM reboard WHERE IDX = ?";

	final static String UPDATE_HIT = "UPDATE reboard SET HIT = HIT + 1 WHERE IDX = ?";

	final static String DELETE = "DELETE FROM reboard WHERE IDX = ?";

	final static String UPDATE = "UPDATE reboard SET subject = ?, content = ?, writer = ?, email = ?, homepage = ?, pwd = ?, filename = ? WHERE IDX = ?";

	final static String UPDATE_ORDER_NO = "UPDATE reboard SET order_no = order_no + 1 " +
			"WHERE root_idx = ? " +
			"AND order_no >= ? " +
			"ORDER BY order_no DESC"; // 순서 보장을 위해 역순으로 업데이트
}
