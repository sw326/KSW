package day05.src;

import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.*;
import java.net.URL;
import javax.swing.*;

public class B extends JFrame{
	JButton clr, opn, sv;
	Container c;
	JPanel p;
	JTextPane tp;
	void init() {
		setLayout(new BorderLayout());
		c = getContentPane();
		p = new JPanel(new GridLayout(1,1));
		clr = new JButton("clear");
		opn = new JButton("open");
		sv = new JButton("save");
		tp = new JTextPane();
		
		clr.addActionListener(e->tp.setText(""));
		c.add(clr, BorderLayout.NORTH);
		
		c.add(p, BorderLayout.SOUTH);
		p.add(opn);
		p.add(sv);
		c.add(tp);
		
		ActionListener handler = new ChooseHandler(this); 
		opn.addActionListener(handler);
		sv.addActionListener(handler);
		
		setUI();
	}
	void setUI() {
		setTitle("JFile Chooser test");
		setSize(450, 450);
		setVisible(true);
		setLocation(300, 300);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public static void main(String args[]) {
		new B().init();
	}
}

class ChooseHandler implements ActionListener{
	B b;
	ChooseHandler(B b){
		this.b = b;
	}
	
	void open(JFileChooser fileChooser) {
		//System.out.println("open");
		int fCheck = fileChooser.showOpenDialog(b.c);
		if(fCheck == JFileChooser.APPROVE_OPTION) {
			try (Reader r = new FileReader(fileChooser.getSelectedFile())){
				b.tp.read(r, null);
			}catch(FileNotFoundException fnfe) {
				fnfe.printStackTrace();
			}catch(IOException ie) {
			}finally {}
		}
	}
	
	void save(JFileChooser fileChooser) {
		//System.out.println("save");
		int fCheck = fileChooser.showSaveDialog(b.c);
		if(fCheck==JFileChooser.APPROVE_OPTION) {
			try {
				BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(fileChooser.getSelectedFile().getPath()),"utf-8"));
				bw.write(b.tp.getText(),0,(b.tp.getText().length()));
				bw.flush();
			}catch(IOException ie) {
				ie.printStackTrace();
			}
		}
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		JFileChooser fileChooser = new JFileChooser();
		if(obj==b.opn) {
			open(fileChooser);
		}else {
			save(fileChooser);
		}
		
		
	}
}