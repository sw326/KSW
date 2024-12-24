package day04;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class B extends JFrame implements ActionListener {
	JButton bN, bS, bW, bE, bC;
	JPanel p;
	JButton bPc, bPe, bPw;
	
	void init() {
		bN=new JButton("북");
		bS=new JButton("남");
		bW=new JButton("서");
		bE=new JButton("동");
		bC=new JButton("중");
		
		p = new JPanel();
		p.setLayout(new BorderLayout());
		bPc = new JButton("중앙 패널");
		bPe = new JButton("동쪽 패널");
		bPw = new JButton("서쪽 패널");
		p.add(bPc);
		p.add(bPe, BorderLayout.EAST);
		p.add(bPw, BorderLayout.WEST);
		
		Container cp = getContentPane();
		cp.add(bN, BorderLayout.NORTH);
		cp.add(bS, BorderLayout.SOUTH);
		cp.add(bW, BorderLayout.WEST);
		cp.add(bE, BorderLayout.EAST);
//		cp.add(bC); // center는 기본 값
		cp.add(p);
		
		bN.addActionListener(this);
		bS.addActionListener(this);
		bW.addActionListener(this);
		bE.addActionListener(this);
//		bC.addActionListener(this);
		bPc.addActionListener(this);
		bPe.addActionListener(this);
		bPw.addActionListener(this);
		setUI();
	}
	void setUI() {
		setTitle("Eclipse Test Ver 1.0");
		setSize(400, 400);
		setResizable(false);
		setLocation(200, 100);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	void pln(String str) {
		System.out.println(str);
	}
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		if(obj == bN) {
			pln("북 클릭시 수행로직");
		}else if(obj == bS) {
			pln("남 클릭시 수행로직");
		}else if(obj == bW) {
			pln("서 클릭시 수행로직");
		}else if(obj == bE) {
			pln("동 클릭시 수행로직");
		}else if(obj == bPc) {
			pln("패-센터 클릭시 수행로직");
		}else if(obj == bPe) {
			pln("패-동 클릭시 수행로직");
		}else {
			pln("패-서 클릭시 수행로직");	
		}
		//JButton b = (JButton)e.getSource();
		//System.out.println(b.getText());
	}
	public static void main(String[] args) {
		B b = new B();
		b.init();

	}

}
