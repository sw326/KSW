import javax.swing.*;
import java.awt.event.*;

class A2 extends JFrame{
	JButton b;
	void init(){
		b = new JButton("자바 버튼");
		/*ActionListener handler = new ActionListener(){
				public void actionPerformed(ActionEvent e){
				//System.out.println("이벤트 발생 감지");
				b.setText("이벤트 처리됨! by 익명내부 클래스");
			}
		};
		b.addActionListener(handler);*/
		ActionListener handler = new ActionListener(){
				public void actionPerformed(ActionEvent e){
				//System.out.println("이벤트 발생 감지");
				b.setText("이벤트 처리됨! by 익명내부 클래스");
			}
		};
		/*b.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e){
				//System.out.println("이벤트 발생 감지");
				b.setText("이벤트 처리됨! by 익명내부 클래스");
			}
		});*/
		b.addActionListener(e-> b.setText("이벤트 처리됨! by 익명내부 클래스"));

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
		new A2().init();
	}
}

class A21 extends JFrame{
	JButton b;
	void init(){
		b = new JButton("java");
		ActionListener handler = new ActionListener(){
			public void actionPerformed(ActionEvent e){
				b.setText("Event performed");
			}
		};
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
		new A21().init();
	}
}

class A22 extends JFrame{
	JButton b;
	void init(){
		b=new JButton("JAVA BUTTON");
		ActionListener handler = new ActionListener(){
			public void actionPerformed(ActionEvent e){
				b.setText("event performed");
			}
		}
		add(b);
		setUI();
	}
	void setUI(){
		setTitle("GUI Test Ver 1.0");
		setVisible(true);
		setSize(300, 200);
		setLocation(200, 100);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	public static void main(STring args[]){
		new A22().init();
	}
}

class A23 extends JFrame{
	JButton b;
	void init(){
		b = new JButton("java");
		b.addActionListener(e -> b.setText("event performed"));
		add(b);
		setUI();
	}
	void setUI(){
		setTitle("GUI Test Ver 1.0");
		setVisible(true);
		setSize(300, 200);
		setLocation(200, 100);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	public static void main(String args[]){
		new A23().init();
	}
}

class A24 extends JFrame{
	JButton b;
	void init(){
		b = new JButton("java");
		ActionListener handler = new ActionListener(){
			public void actionPerformed(ActionEvent e){
				b.setText("AD");
			}
		}
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
		new A24().init();
	}
}

class A25 extends JFrame{
	JButton b;
	void init(){
		b = new JButton("java");
		b.addActionListener(e->b.setText("ASDASDASD");
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
		new A25().init();
	}
}