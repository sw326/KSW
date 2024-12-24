package day05.src;


import java.awt.*;
import java.awt.event.*;
import java.net.URL;

import javax.swing.*;

public class E extends JFrame {
	JLabel laImg;
	void init() {
		URL url = this.getClass().getResource("imgs/move.gif");
		Icon icon = new ImageIcon(url);
		laImg = new JLabel(icon);
		add(laImg);
		setUI();
	}
	void setUI() {
		setTitle("Image Test Ver 1.0");
		pack();
		setResizable(false);
		setLocation(200, 100);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	void pln(String str) {
		System.out.println(str);
	}
	public static void main(String[] args) {
		E e = new E();
		e.init();
	}
}
