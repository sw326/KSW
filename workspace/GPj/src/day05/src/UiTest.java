package day05.src;

import java.awt.*;
import java.awt.event.*;
import java.net.URL;

import javax.swing.*;

public class UiTest extends JFrame {
	JButton imgbs[] = new JButton[4];
	String[] urls = {"imgs/p_girl.PNG","imgs/p_hello.png","imgs/p_play.png","imgs/p_study.png"};
	JButton directionBs[] = new JButton[4];
	String[][] direction = {{"동",BorderLayout.EAST},{"서",BorderLayout.WEST},{"남",BorderLayout.SOUTH},{"북",BorderLayout.NORTH}};
	
	
	URL url;
	Container cp;
	JPanel p ;
	
	void init() {
		setLayout(new BorderLayout());
		cp = getContentPane();
		p = new JPanel(new GridLayout(2,2));
		for(int i=0;i<imgbs.length;i++) {
			URL url = getClass().getResource(urls[i]);
			Icon icon = new ImageIcon(url);
			imgbs[i] = new JButton(icon);
			p.add(imgbs[i]);
		}
		cp.add(p);
		ActionListener dirhandler = new DirectionHandler(this);
		for(int i=0;i<imgbs.length;i++) {
			directionBs[i] = new JButton(direction[i][0]);
			directionBs[i].addActionListener(dirhandler);
			cp.add(directionBs[i],direction[i][1]);
		}
		
		setUI();
	}
	void setUI() {
		setTitle("Gui test");
		pack();
		setVisible(true);
		setLocation(400, 400);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}
	public static void main(String[] args) {
		new UiTest().init();

	}
}

class DirectionHandler implements ActionListener{
	UiTest ui;
	DirectionHandler(UiTest ui){
		this.ui = ui;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		
		
		if(obj==ui.directionBs[0]) {
			URL url = getClass().getResource(ui.urls[0]);
			Icon icon = new ImageIcon(url);
			JOptionPane.showMessageDialog(null,"메세지내용","제목",JOptionPane.PLAIN_MESSAGE,icon);
		}
		else if(obj==ui.directionBs[1]) {
			URL url = getClass().getResource(ui.urls[0]);
			Icon icon = new ImageIcon(url);
			int sel = JOptionPane.showConfirmDialog(null,"종료할까요?","선택",JOptionPane.OK_CANCEL_OPTION,JOptionPane.PLAIN_MESSAGE,icon);
			if(sel==0)
				System.exit(1);
		}
		else if(obj==ui.directionBs[2]) {
			String[] moods = {"good","bad","normal"};
			URL url = getClass().getResource(ui.urls[2]);
			Icon icon = new ImageIcon(url);
			String mood = (String)JOptionPane.showInputDialog(null,"오늘 기분 어때?","질문",JOptionPane.PLAIN_MESSAGE,icon,moods,moods);
			
			String msg="";
			if(mood != null) {
				if(mood.equals("good")) 
					msg = "좋아";
				else if(mood.equals("bad"))
					msg = "싫어";
				else if(mood.equals("normal"))
					msg = "그냥 그래";
				JOptionPane.showMessageDialog(null, msg,"답변",JOptionPane.PLAIN_MESSAGE);
			}
		}
		else {	
			URL url = getClass().getResource(ui.urls[3]);
			Icon icon = new ImageIcon(url);
			JOptionPane.showMessageDialog(null, icon , "제목", JOptionPane.INFORMATION_MESSAGE);
		}
		
		//JOptionPane.showConfirmDialog();
		
	}
}