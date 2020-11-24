package week13;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
@SuppressWarnings("serial")
public class TextFieldAndComboBoxFrame1 extends JFrame implements ActionListener{
	ImageIcon [] images = { // �̹��� ��ü �迭
			new ImageIcon("images/error.jpg"),
			new ImageIcon("images/apple.jpg"),
			new ImageIcon("images/banana.jpg"),
			new ImageIcon("images/kiwi.jpg"),
			new ImageIcon("images/mango.jpg")
			};
	JTextField tf = new JTextField(10);
	JComboBox<String> combo = new JComboBox<String>();
	JLabel imgLabel = new JLabel();
	int k=0;

	public TextFieldAndComboBoxFrame1() {
		super("�޺��ڽ� 2");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		setLayout(new FlowLayout());
		add(tf);
		add(combo);
		add(imgLabel);		
		
		tf.addActionListener(this);
		combo.addActionListener(this);

		setSize(300,300);
		setVisible(true);
	}
	
	public void actionPerformed(ActionEvent e) {
		String ss= null;
		int index=0;
		if(e.getSource()==tf) {
			ss = tf.getText();
			combo.addItem(ss);
		}
		else if(e.getSource()==combo) {
			
			k++;
			ss = (String)combo.getSelectedItem();
			if(ss.equals("���")) index =1;
			else if(ss.equals("�ٳ���")) index =2;
			else if(ss.equals("Ű��"))  index = 3;
			else if(ss.equals("����"))  index = 4;


			if(k>1)
				imgLabel.setIcon(images[index]);
			
		}
	}
	
	public static void main(String[] args) {
		new TextFieldAndComboBoxFrame1();
	}
}
