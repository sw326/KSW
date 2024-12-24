package day04;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

public class D extends JFrame {
	String labels[] = {"도L", "레", "미", "파", "솔", "라", "시", "도H"};
	JButton bs[];
	Container cp;
	ActionListener listener = new ActionHandler();
	
	void init() {
		setLayout(new CardLayout());
		cp = getContentPane();
		bs = new JButton[labels.length];
		undo();
		
		setUI();
	}
	void setUI() {
		setTitle("CardLayout Test Ver 1.0");
		setSize(400, 300);
		setResizable(false);
		setLocation(200, 100);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	void undo() {
		
		for(int i=0;i<bs.length;i++) {
			bs[i]=new JButton(labels[i]);
			bs[i].addActionListener(listener);
			cp.add(bs[i]);
		}
	}
	void pln(String str) {
		System.out.println(str);
	}
	public static void main(String[] args) {
		D d = new D();
		d.init();
	}
	class ActionHandler implements ActionListener{
		public void actionPerformed(ActionEvent e) {
//			CardLayout card = (CardLayout)cp.getLayout();
//			card.next(cp);
			
			Object obj = e.getSource();
			JButton b = (JButton)obj;
			cp.remove(b);
			if(b==bs[bs.length-1])undo();
			revalidate();
			//pln("event performed");
		}
	}

}
