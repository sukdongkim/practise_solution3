package week13;

import java.awt.*;
import javax.swing.*;
import javax.swing.event.*;

public class JSliderPractice2Frame extends JFrame {
	private static final long serialVersionUID = 1L;
	private JSlider slider = new JSlider(0,100,50);
	private JLabel label = new JLabel("   I Love Java   ");
	
	public JSliderPractice2Frame() {
		super("슬라이더 예제");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container c = getContentPane();
		c.setLayout(new BorderLayout());		
		c.add(slider, BorderLayout.NORTH);
		c.add(label, BorderLayout.CENTER);		
		
		// 슬라이더의 속성 설정
		slider.setMajorTickSpacing(20);
		slider.setMinorTickSpacing(5);
		slider.setPaintLabels(true);
		slider.setPaintTicks(true);
		
		label.setHorizontalAlignment(JLabel.CENTER);
		label.setOpaque(true);
		label.setFont(new Font("TimesRoman", Font.PLAIN, slider.getValue()));	
		label.setForeground(Color.orange);

		slider.addChangeListener(new ChangeListener() {
			@Override
			public void stateChanged(ChangeEvent e) {
				JSlider s = (JSlider)e.getSource();
				int size = s.getValue();
				if(size<20)
					size =20;
				else if(size>80)
					size = 80;
				label.setFont(new Font("TimesRoman", Font.PLAIN, size));
			}
		});

		setSize(600,300);
		setVisible(true);
	}
	public static void main(String[] args) {
		new JSliderPractice2Frame();
	}
}
