package day04;

import javax.swing.*;

public class A extends JFrame {
	private static final long serialVersionUID = 1L;
	JButton b;
	void init() {
		b = new JButton("버튼 with 이클립스");
		b.addActionListener(e -> b.setText("이벤트 처리 완료"));
		add(b);
		setUI();
	}
	void setUI() {
		setTitle("Eclipse Test Ver 1.0");
		setSize(300, 200);
		setResizable(false);
		setLocation(200, 100);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	public static void main(String[] args) {
		new A().init();
	}
}