package day04;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

public class C extends JFrame {
	JButton bs[] = new JButton[6];
	
	void init() {
		setLayout(new GridLayout(2,3));
		Container cp = getContentPane();
		ActionListener listener = (e -> handler(e));
		for(int i=0;i<bs.length;i++) {
			bs[i] = new JButton("button "+i);
			bs[i].addActionListener(listener);
			cp.add(bs[i]);
		}
		setUI();
	}
	void setUI() {
		setTitle("GridLayout Test Ver 1.0");
		setSize(400, 300);
		setResizable(false);
		setLocation(200, 100);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	void handler(ActionEvent e) {
		Object obj = e.getSource();
		if(obj==bs[0]) {
			pln("first");
		}else if(obj==bs[1]) {
			pln("second");
		}else if(obj==bs[2]) {
			pln("third");
		}else if(obj==bs[3]) {
			pln("fourth");
		}else if(obj==bs[4]) {
			pln("fifth");
		}else {
			pln("sixth");
		}
	}
	void pln(String str) {
		System.out.println(str);
	}
	public static void main(String[] args) {
		C c = new C();
		c.init();

	}

}
