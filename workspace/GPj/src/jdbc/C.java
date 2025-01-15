package jdbc;

import javax.swing.*;
import javax.swing.table.*;

import java.awt.*;
import java.util.*;

public class C extends JFrame{
	JTable t; // JTable(TableModel dm)
	
	Vector<String> columnNames;
	Vector<Vector<Object>> rowData;
	TableModel dm;
	
	C(){
		columnNames = new Vector<>();
		columnNames.add("no");
		columnNames.add("name");
		columnNames.add("date");
		
		rowData = new Vector<>();
		Vector<Object> v1 = new Vector<>();
		Vector<Object> v2 = new Vector<>();
		Vector<Object> v3 = new Vector<>();
		Vector<Object> v4 = new Vector<>();
		Vector<Object> v5 = new Vector<>();
		Vector<Object> v6 = new Vector<>();
		Vector<Object> v7 = new Vector<>();
		Vector<Object> v8 = new Vector<>();
		Vector<Object> v9 = new Vector<>();
		v1.add(10);v1.add("hong1");v1.add("25/01/01");
		v2.add(20);v2.add("hong2");v2.add("25/01/02");
		v3.add(30);v3.add("hong3");v3.add("25/01/03");
		v4.add(40);v4.add("hong4");v4.add("25/01/04");
		v5.add(50);v5.add("hong5");v5.add("25/01/05");
		v6.add(60);v6.add("hong6");v6.add("25/01/06");
		v7.add(70);v7.add("hong7");v7.add("25/01/07");
		v8.add(80);v8.add("hong8");v8.add("25/01/08");
		v9.add(90);v9.add("hong9");v9.add("25/01/09");
		rowData.add(v1);
		rowData.add(v2);
		rowData.add(v3);
		rowData.add(v4);
		rowData.add(v5);
		rowData.add(v6);
		rowData.add(v7);
		rowData.add(v8);
		rowData.add(v9);
		
		dm = new DefaultTableModel(rowData, columnNames);
	}
	
	void init() {
		Container cp = getContentPane();
		
		t = new JTable(dm);
		JScrollPane sp = new JScrollPane(t);
		cp.add(sp);
		setUI();
		test();
	}
	void setUI() {
		setTitle("JTable Test3");
		setSize(500, 200);
		setVisible(true);
		setLocationRelativeTo(null);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}
	void test() {
		// 1) 데이터 set/get
		t.setValueAt("사이버", 0, 1);
		Object data = t.getValueAt(2, 1);
		pln("data: "+data);
		
		// 2) 개수
		int rc = t.getRowCount();
		int cc = t.getColumnCount();
		pln("rc: "+rc+" cc: "+cc);
		
		// 3) 컬럼 이름
		String cn = t.getColumnName(1);
		pln("cn: "+cn);
	}
	
	void pln(String str){
		System.out.println(str);
	}
	public static void main(String args[]) {
		new C().init();
	}
}