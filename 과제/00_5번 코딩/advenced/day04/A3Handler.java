import javax.swing.*;
import java.awt.event.*;

class A3Handler implements ActionListener{
	A3 a3;
	A3Handler(A3 a3){
		this.a3 = a3;
	}
	public void actionPerformed(ActionEvent e){
		//Object obj = e.getSource();
		//JButton b = (JButton)obj;
		a3.b.setText("이벤트 처리됨! by 제3 클래스");
		a3.setTitle("Merry Christmas~~!");
	}
}