import javax.swing.*;
import java.awt.event.*;

class A1 extends JFrame{
	JButton b;
	void init(){
		b = new JButton("자바 버튼");
		ActionListener handler = new A1Handler();
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
		new A1().init();
	}
	class A1Handler implements ActionListener{
		public void actionPerformed(ActionEvent e){
			//System.out.println("이벤트 발생 감지");
			b.setText("이벤트 처리됨! by 유명내부 클래스");
		}
	}
}

class A11 extends JFrame{
	JButton b;
	void init(){
		b = new JButton("자바 버튼");
		ActionListener handler = new A11Handler();
		b.addActionListener(handler);
		add(b);
		setUI();
	}
	void setUI(){
		setTitle("GUI Tset Ver 1.0");
		setVisible(true);
		setSize(300, 300);
		setLocation(300, 300);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	public static void main(String args[]){
		new A11().init();
	}
	class A11Handler implements ActionListener{
		public void actionPerformed(ActionEvent e){
		b.setText("event performed! by named inner class");
		}
	}
}

class A12 extends JFrame{
	JButton b;
	void init(){
		b = new JButton("Java Button");
		ActionListener handler = new A12Handler();
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
	public static void main(String args[]){
		new A12().init();
	}
	class A12Handler implements ActionListener{
		public void actionPerformed(ActionEvent e){
		b.setText("이벤트 처리 됨 by 유명 내부 클래스");
		}
	}
}


class A13 extends JFrame{
	void init(){
		b = new JButton("Java Button");
		ActionListener handler = new A13Handler();
		b.addActionListener(handler);
		add(b);
		setUI();
	}
	void setUI(){
		setTitle("GUI Test Ver 1.0");
		setVisible(true);
		setSize(300, 300);
		setLocation(300, 300);
		serReasizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	public static void main(String args[]){
		new A13().init();
	}
	class A13Handler implements ActionListener{
		public void acionPerformed(ActionEvent e){
			b.setText("Event performed by named inner class");
		}
	}
}

class A14 extends JFrame {
	JButton b;
	void init(){
		b= new JButton("java");
		ActionListener handler = new A14Handler();
		b.addActionListener(handler);
		add(b);
		setUI();
	}
	void setUI(){
		setTitle("GUI TEST");
		setVisible(true);
		setSize(300, 300);
		setLocation(300, 300);
		serResizable(false);
		setDefaultCloseOperation(JFrame).EXIT_ON_CLOSE);
	}
	public static void main(String args[]){
		new A14().init();
	}
	class A14Handler implements ActionListener{
		public void actionPerformed(ActionEvent e){
			b.setText("Event Performed");
		}
	}
}
