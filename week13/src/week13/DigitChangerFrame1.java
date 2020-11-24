package week13;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
@SuppressWarnings("serial")
public class DigitChangerFrame1 extends JFrame implements ActionListener {
	JTextField src = new JTextField(8); 
	JTextField dest = new JTextField(8);

	String [] text = {"10진수", "2진수", "8진수", "16진수"};
	JComboBox<String> combo1 = new JComboBox<String>(text);
	JComboBox<String> combo2 = new JComboBox<String>(text);
	
	int n,sign=1;
	
	DigitChangerFrame1() {
		super("진법 변환 2");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container c = getContentPane();
		c.setLayout(new GridLayout(2,3));
		
		dest.setEditable(false);
		combo1.addActionListener(this);
		combo2.addActionListener(this);
		
		c.add(combo1);
		c.add(new JLabel("      ==>"));
		c.add(combo2);
		c.add(src);
		c.add(new JLabel(" "));
		c.add(dest);
	
		setSize(400, 150);
		setVisible(true);
		
	}

	public void actionPerformed(ActionEvent e) {
		String s1=null, s2=null;
	
		if(e.getSource() == combo1 ) {
			s1 = combo1.getSelectedItem().toString();
			try {
				switch(s1) {		
					case "10진수":
						n = Integer.parseInt(src.getText());
						break;
					case "2진수" :
						n = Integer.parseInt(src.getText(),2);
						break;				
					case "8진수" :
						n = Integer.parseInt(src.getText(),8);
						break;						
					case "16진수" :
						n = Integer.parseInt(src.getText(),16);
						break;				
				}
			} catch(NumberFormatException exp) {
				src.setText("error");
			}
			System.out.println(n);
			if(n<0) {
				sign = -1;
				n*=sign;
			}
		}
		
		if(e.getSource() == combo2 ) {
			s2 = combo2.getSelectedItem().toString();		

			try {
				switch(s2) {		
				case "10진수":
					if(sign<0) dest.setText("-" + Integer.toString(n));
						else dest.setText(Integer.toString(n)); 
					break;
				case "2진수" :
					if(sign<0) dest.setText("-" + Integer.toBinaryString(n));
					else dest.setText(Integer.toBinaryString(n)); 
					break;			
				case "8진수" :
					if(sign<0) dest.setText("-" + Integer.toOctalString(n));
					else dest.setText(Integer.toOctalString(n)); 
					break;						
				case "16진수" :
					if(sign<0) dest.setText("-" + Integer.toHexString(n));
					else dest.setText(Integer.toHexString(n)); 
					break;			
			}
		} catch(NumberFormatException exp) {
			dest.setText("error");
		}
		}
	}
	
	public static void main(String[] args) {
		new DigitChangerFrame1();
	}

}
