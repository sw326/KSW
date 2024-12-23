import javax.swing.*;
import java.awt.event.*;

class A4 extends JFrame implements ActionListener{
	JButton b;
	void init(){
		b = new JButton("자바 버튼");
		b.addActionListener(this);
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
		new A4().init();
	}
	@Override
	public void actionPerformed(ActionEvent e){
		b.setText("이벤트 처리됨! by self 클래스");
	}
}

class A41 extends JFrame implements ActionListener{
	JButton b;
	void init(){
		b = new JButton("JAVA");
		b.adActionListener(this);
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
		new A41().init();
	}
	@Override
	public void actionPerformed(ActionEvent e){
		b.setText("asdadasgadgaga")
	}
}

class A42 extends JFrame implements ActionListener{
	JButton b;
	void init(){
		b=new JButton("java");
		b.addActionListener(this);
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
		new A42().init();
	}
	@Override
	public void actionPerformed(ActionEvent e){
		b.setText("ADASFASF");
	}
}


class A43 extends JFrame implements ActionListener{
	JButton b;
	void init(){
		b=new JButton("ADASAHADG");
		b.addActionListener(this);
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
		new A43().init();
	}
	@Override
	public void actionPerformed(ActionEvent e){
		b.setTet("Asdasd");
	}
}