package jdbc;

import javax.swing.*;
import java.awt.*;

public class A extends JFrame{
	JTable t;
	Object columnNames[] = {"no", "name", "date"};
	Object rowData[][] = {
			{10, "hong", "25/01/01"},
			{20, "lee", "25/01/02"},
			{30, "kim", "25/01/03"},
			{40, "jang", "25/01/04"},
			{50, "john", "25/01/05"},
			{60, "tom", "25/01/06"},
			{70, "jake", "25/01/07"},
			{80, "taylor", "25/01/08"},
			{90, "donald", "25/01/09"}
	};
	void init() {
		Container cp = getContentPane();
		
		
		t = new JTable(rowData, columnNames);
		JScrollPane sp = new JScrollPane(t);
		cp.add(sp);
		setUI();
		test();
	}
	void setUI() {
		setTitle("JTable Test1");
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
		new A().init();
	}
}