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
