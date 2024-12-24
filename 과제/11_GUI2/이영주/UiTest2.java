package gui2;

import java.awt.*;
import java.awt.event.*;
import java.io.*;


import javax.swing.*;
import javax.swing.Box.Filler;
import javax.swing.filechooser.FileNameExtensionFilter;


public class UiTest2 extends JFrame {
	JButton saveBtn,openBtn,clearBtn;
	JTextPane text;
	JScrollPane textScroll;
	JPanel spanel;
	Container cp;
	
	UiTest2(){
		text = new JTextPane();
		textScroll  = new JScrollPane(text);
		spanel = new JPanel(new GridLayout(1,2));
		setLayout(new BorderLayout());
		cp = getContentPane();
		saveBtn = new JButton("save");
		openBtn = new JButton("open");
		clearBtn = new JButton("clear");
		clearBtn.addActionListener(e -> {text.setText("");});
		spanel.add(saveBtn);
		spanel.add(openBtn);
		UiHandler uiHandler = new UiHandler(this);
		saveBtn.addActionListener(uiHandler);
		openBtn.addActionListener(uiHandler);
		
		
		
		cp.add(spanel,BorderLayout.SOUTH);
		cp.add(clearBtn,BorderLayout.NORTH);
		cp.add(textScroll,BorderLayout.CENTER);
		setUI();
	}
	void setUI() {
		setTitle("JFileChooser Test");
		setSize(400,500);
		setVisible(true);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	public static void main(String[] args) {
		new UiTest2();
	}

}

class UiHandler implements ActionListener{
	UiTest2 uiTest2;

	Writer w;
	public UiHandler(UiTest2 uiTest2) {
		this.uiTest2 = uiTest2;
	}
	void open(JFileChooser jFile) {
		String total="";
		char[] cs = new char[512];
		int fCheck = jFile.showOpenDialog(uiTest2.cp);
		if(fCheck==JFileChooser.APPROVE_OPTION) {
			try {
				Reader r = new FileReader(jFile.getSelectedFile().getPath());
				uiTest2.text.read(r, cs);
				r.close();
			} catch (FileNotFoundException fnfe) {
				fnfe.printStackTrace();
			} catch (IOException ie) {}
			finally {
				
			}
		}		
	}
	void save(JFileChooser jFile) {
		char[] cs = new char[512];
		int fCheck = jFile.showSaveDialog(uiTest2.cp);
		if(fCheck==JFileChooser.APPROVE_OPTION) {
			try {
				BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(jFile.getSelectedFile().getPath()),"utf-8"));
				bw.write(uiTest2.text.getText(),0,(uiTest2.text.getText().length()));
				bw.flush();
				
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		JFileChooser jFile = new JFileChooser();
		if(obj==uiTest2.openBtn) {
			open(jFile);
		}else if(obj == uiTest2.saveBtn) {
			save(jFile);
		}
			
	}
	
	//System.out.println(jfile.getSelectedFile().getPath());
}
