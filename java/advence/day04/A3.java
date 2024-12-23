import javax.swing.*;
import java.awt.event.*;

class A3 extends JFrame{
	JButton b;
	void init(){
		b = new JButton("자바 버튼");
		
		ActionListener handler = new A3Handler(this);
		b.addActionListener(handler);

		add(b);
		setUI();
	}
	void setUI(){
		setTitle("GUI Test Ver 1.0");
		setVisible(true);
		setSize(300, 200);
		setLocation(300, 300);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	public static void main(String[] args) {
		new A3().init();
	}
}