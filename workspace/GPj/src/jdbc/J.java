package jdbc;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.*;

import java.awt.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.sql.*;
import java.util.*;

public class J extends JFrame {
	private String oracle = "oracle.jdbc.OracleDriver";
	private String oracleUrl;
	private String user;
	private String password;
	Connection con;

	Container c;
	JTable t;
	JScrollPane sp;
	Vector<String> columnNames;
	Vector<Vector<Object>> rowData;
	TableModel dm;

	JTextField deptnoField;
	JTextField dNameField;
	JTextField locField;

	private JTextField searchField;
    private JComboBox<String> searchCombo;

	private void loadSettings() throws Exception{
		System.out.println("Current working directory: " + System.getProperty("user.dir"));
		try (BufferedReader br = new BufferedReader(new FileReader("D:\\KSW\\workspace\\GPj\\src\\jdbc\\settings.txt"))){
			oracleUrl = br.readLine();
			user = br.readLine();
			password = br.readLine();

			if(oracleUrl == null || user == null || password == null){
				throw new Exception("설정 파일 형식이 올바르지 않습니다.");
			}			
		}
	}

	J() {
		try {
			loadSettings();

			Class.forName(oracle);
			con = DriverManager.getConnection(oracleUrl, user, password);
			if (con != null) {
				showDept();
				init();
			} else {
				pln("연결 실패");
			}
		} catch (ClassNotFoundException ce) {
			pln("" + ce);
		} catch (SQLException se) {
			pln("" + se);
		}catch(Exception e){
			pln("설정 파일 읽기 실패: "+e);
		}
	}

	void showDept() {
		columnNames = new Vector<>(Arrays.asList("DEPTNO", "DNAME", "LOC"));

		rowData = new Vector<>();
		try {
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT DEPTNO, DNAME, LOC FROM DEPT ORDER BY DEPTNO");
			while (rs.next()) {
				Vector<Object> v = new Vector<>();
				v.add(rs.getInt("DEPTNO"));
				v.add(rs.getString("DNAME"));
				v.add(rs.getString("LOC"));
				rowData.add(v);
			}
			rs.close();
			stmt.close();
		} catch (SQLException se) {
			pln("데이터베이스 오류: " + se);
		}

		dm = new DefaultTableModel(rowData, columnNames);
	}

	void init() {
		Container cp = getContentPane();
		JPanel topPanel = createTopPanel();
		JPanel bottomPanel = createBottomPanel();

		cp.add(topPanel, BorderLayout.NORTH);
		cp.add(createScrollPane(), BorderLayout.CENTER);
		cp.add(bottomPanel, BorderLayout.SOUTH);

		setUI();
		setupTableSelectionListener();
		setupSearchLisetener();
	}
	private JPanel createTopPanel(){
		JPanel topPanel = new JPanel(new GridLayout(1, 2));

		searchCombo = new JComboBox<>();
		for (int i = 0; i < dm.getColumnCount(); i++) {
			searchCombo.addItem(dm.getColumnName(i));
		}
		searchField = new JTextField();

		topPanel.add(searchCombo);
		topPanel.add(searchField);
		return topPanel;
	}

	private JPanel createBottomPanel(){
		JPanel bottomPanel = new JPanel();
		bottomPanel.setLayout(new GridLayout(2, 3));

		deptnoField = new JTextField();
		dNameField = new JTextField();
		locField = new JTextField();

		JButton btn1 = new JButton("추가");
		JButton btn2 = new JButton("수정");
		JButton btn3 = new JButton("삭제");

		btn1.addActionListener(e -> insert());
		btn2.addActionListener(e -> update());
		btn3.addActionListener(e -> delete());

		bottomPanel.add(deptnoField);
		bottomPanel.add(dNameField);
		bottomPanel.add(locField);
		bottomPanel.add(btn1);
		bottomPanel.add(btn2);
		bottomPanel.add(btn3);
		return bottomPanel;
	}

	private JScrollPane createScrollPane(){
		t = new JTable(dm);
		return new JScrollPane(t);
	}

	private void setupTableSelectionListener(){
		// 테이블에 ListSelectionListener 추가
		t.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent e){
				// 선택이 변경되는 중간에 이벤트 처리하지 않음
				if(!e.getValueIsAdjusting()){
					int row = t.getSelectedRow();
					if(row != -1){
						String deptno = t.getValueAt(row, 0).toString();
						String dname = t.getValueAt(row, 1).toString();
						String loc = t.getValueAt(row, 2).toString();

						deptnoField.setText(deptno);
						dNameField.setText(dname);
						locField.setText(loc);
					}
				}
			}
		});
	}

	void setUI() {
		setTitle("디비디비딥");
		setSize(300, 400);
		setVisible(true);
		setLocationRelativeTo(null);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}

	boolean getField() {
		try {
			int deptno = Integer.parseInt(deptnoField.getText());
			String dname = dNameField.getText().trim();
			String loc = locField.getText().trim();

			if (dname.trim().isEmpty() || loc.trim().isEmpty()) {
				JOptionPane.showMessageDialog(this,
						"모든 필드를 입력해주세요.", "확인",
						JOptionPane.INFORMATION_MESSAGE);
				return false;
			}
			return true;
		} catch (NumberFormatException ne) {
			JOptionPane.showMessageDialog(this,
					"부서번호는 숫자여야 합니다.",
					"오류",
					JOptionPane.ERROR_MESSAGE);
					return false;
		}
	}

	void insert() {
		if(!getField()) return;
		try {
			int deptno = Integer.parseInt(deptnoField.getText());
			String dname = dNameField.getText().trim();
			String loc = locField.getText().trim();

			String sql = "INSERT INTO DEPT VALUES(?, ?, ?)";
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, deptno);
			pstmt.setString(2, dname);
			pstmt.setString(3, loc);

			int i = pstmt.executeUpdate();
			if (i > 0) {
				JOptionPane.showMessageDialog(this,
						"부서가 추가되었습니다.", "확인",
						JOptionPane.INFORMATION_MESSAGE);
				showDept();
				t.setModel(dm);
				clearFields();
			}
			pstmt.close();
		} catch (SQLException se) {
			JOptionPane.showConfirmDialog(this, "SQL 오류: " + se.getMessage());
		} catch (NumberFormatException ne) {
			JOptionPane.showMessageDialog(this, "부서번호는 숫자여야 합니다.");
		}
	}

	void update() {
		if(!getField()) return;
		try {
			int deptno = Integer.parseInt(deptnoField.getText());
			String dname = dNameField.getText().trim();
			String loc = locField.getText().trim();

			String sql = "UPDATE DEPT SET DNAME=?, LOC=? WHERE DEPTNO=?";
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1, dname);
			pstmt.setString(2, loc);
			pstmt.setInt(3, deptno);

			int i = pstmt.executeUpdate();
			if (i > 0) {
				JOptionPane.showMessageDialog(this,
						"부서정보가 수정되었습니다.", "확인",
						JOptionPane.INFORMATION_MESSAGE);
				showDept();
				t.setModel(dm);
				clearFields();
			} else {
				JOptionPane.showMessageDialog(this,
						"수정할 부서가 없습니다.",
						"오류",
						JOptionPane.ERROR_MESSAGE);
			}
			pstmt.close();
		} catch (SQLException se) {
			JOptionPane.showConfirmDialog(this, "SQL 오류: " + se.getMessage());
		} catch (NumberFormatException ne) {
			JOptionPane.showMessageDialog(this, "부서번호는 숫자여야 합니다.");
		}
	}

	void delete() {
		if(!getField()) return;
		try {
			int deptno = Integer.parseInt(deptnoField.getText());

			int confirm = JOptionPane.showConfirmDialog(this, "정말 삭제하시겠습니까?",
					"삭제", JOptionPane.YES_NO_OPTION);

			if (confirm == JOptionPane.YES_OPTION) {
				String sql = "DELETE FROM DEPT WHERE DEPTNO=?";
				PreparedStatement pstmt = con.prepareStatement(sql);
				pstmt.setInt(1, deptno);

				int i = pstmt.executeUpdate();
				if (i > 0) {
					JOptionPane.showMessageDialog(this,
							"부서정보가 삭제되었습니다.", "확인",
							JOptionPane.INFORMATION_MESSAGE);
					showDept();
					t.setModel(dm);
					clearFields();
				}else {
					JOptionPane.showMessageDialog(this, 
						"삭제할 부서가 없습니다.", 
						"오류", 
						JOptionPane.ERROR_MESSAGE);
				}
				pstmt.close();
			}
		} catch(SQLException se) {
			JOptionPane.showMessageDialog(this, 
				"SQL 오류: " + se.getMessage(), 
				"오류", 
				JOptionPane.ERROR_MESSAGE);
		} catch(NumberFormatException ne) {
			JOptionPane.showMessageDialog(this, 
				"부서번호는 숫자여야 합니다.", 
				"오류", 
				JOptionPane.ERROR_MESSAGE);
		}
	}

	private void setupSearchLisetener(){
		searchField.getDocument().addDocumentListener(new DocumentListener() {
			public void changedUpdate(DocumentEvent e) { search();}
			public void removeUpdate(DocumentEvent e) { search();}
			public void insertUpdate(DocumentEvent e) { search();}
		});
	}

	void search(){
		javax.swing.Timer timer = new javax.swing.Timer(300, e->{
			String searchText = searchField.getText();
			if(searchText.trim().isEmpty()){
				showDept();
				t.setModel(dm);
				return;
			}
			select();
		});
		timer.setRepeats(false);
		timer.start();
	}

	void select (){
		String searchText = searchField.getText();
		String selectedColumn = (String)searchCombo.getSelectedItem();
		try {
			String sql = "SELECT DEPTNO, DNAME, LOC FROM DEPT WHERE "+
				selectedColumn + " LIKE ?";
				PreparedStatement pstmt = con.prepareStatement(sql);
				pstmt.setString(1, "%"+searchText+"%");

				ResultSet rs = pstmt.executeQuery();
				// 기존 데이터 클리어
				rowData.clear();

				// 새로운 검색 결과 추가
				while (rs.next()) {
					Vector<Object> v = new Vector<>();
					v.add(rs.getInt("DEPTNO"));
					v.add(rs.getString("DNAME"));
					v.add(rs.getString("LOC"));
					rowData.add(v);
				}

				// 테이블 모델 갱신
				dm = new DefaultTableModel(rowData, columnNames);
				t.setModel(dm);
				
				rs.close();
				pstmt.close();

			} catch (SQLException se) {
				pln("검색 오류: " + se);
			}
		}

	void clearFields() {
		deptnoField.setText("");
		dNameField.setText("");
		locField.setText("");
	}

	void pln(String str) {
		System.out.println(str);
	}

	public static void main(String args[]) {
		new J();
	}
}