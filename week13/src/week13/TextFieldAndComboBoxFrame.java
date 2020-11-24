package week13;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
@SuppressWarnings("serial")
public class TextFieldAndComboBoxFrame extends JFrame {
	JTextField tf = new JTextField(10);
	JComboBox<String> combo = new JComboBox<String>();

	public TextFieldAndComboBoxFrame() {
		super("ÄÞº¸¹Ú½º ");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		setLayout(new FlowLayout());
		add(tf);
		add(combo);		
		
		tf.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				combo.addItem(tf.getText());
			}
		});

		setSize(250,200);
		setVisible(true);
	}
	public static void main(String[] args) {
		new TextFieldAndComboBoxFrame();
	}
}
