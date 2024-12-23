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

class A31 extends JFrame{
	JButton b;
	void init(){
		b =new JButton("java");
		ActionListener handler = new A31Handler(this);
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
		new A31().init();
	}
}

class A31Handler implements ActionListener{
	A31 a31;
	A31Handler(A31 a31){
		this.a31 = a31;
	}
	public void actionPerformed(ActionEvent e){
		//Object obj = e.getSource();
		//JButton b = (JButton)obj;
		a31.b.setText("aSDasdadas");
		a31.setTitle("MerryChristmas");
	}
}


class A32 extends JFrame{
	JButton b;
	void init(){
		b = new JButton("JAVA");
		ActionListener handler = new A32Handler(this);
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
		new A32().init();
	}
}

class A32Handler implements ActionListener{
	A32 a32;
	A32Handler(A32 a32){
		this.a32 = a32;
	}
	public void actionPerformed(ActionEvent e){
		a32.b.setText("ASDRRWHRW");
		a32.setTitle("Merry christmas");
	}
}

class A33 extends JFrame{
	JButton b;
	void init(){
		b=new JButton("java");
		ActionListener handler = new A33Handler(this);
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
		new A33().init();
	}
}

class A33Handler implements ActionListener{
	A33 a33;
	A33Handler(A33 a33){
		this.a33 = a33;
	}
	public void actionPerformed(ActionEvent e){
		a33.b.setText("ffffff");
		a33.setTitle("merry Christmas");
	}
}

class A34 extends JFrame{
	JButton b;
	void init(){
		b = new JButton("JAVA");
		ActionListener handler = new A34Handler(this);
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
		new A34().init();
	}
}

class A34Handler implements ActionListener{
	A34 a33;
	A34Handler(A34 a34){
		this.a34 = a.34;
	}
	public void actionPerformed(ActionEvent e){
		a34.b.setText("GGSS");
		a34.setTitle("MerryChristmas");
	}
}

class A35 extends JFrame{
	JButton b;
	void init(){
		b=new JButton("java");
		ActionListener handler = new A35Handler(this);
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
		new A35().init();
	}
}

class A35Handler implements ActionListener{
	A35 a35;
	A35Handler(A35 a35){
		this.a35 = a35;
	}
	public void actionPerformed(ActionEvent e){
		a35.b.setText("");
		a35.setTitle("Merry Christmas");
	}
}