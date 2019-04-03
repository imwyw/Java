import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class MyCalculate extends JFrame implements ActionListener {

	JTextField txt1, txt2;
	JLabel label, optLabel, resLabel;
	JButton btn1, btn2;

	public MyCalculate(String title) {
		super(title);
		setSize(600, 250);
		setLayout(new FlowLayout());
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);// ������ʾ����

		txt1 = new JTextField(5);
		label = new JLabel(" ���� ");
		txt2 = new JTextField(5);
		btn1 = new JButton("���");
		btn2 = new JButton("���");
		optLabel = new JLabel(" = ");
		resLabel = new JLabel("0");
		btn1.addActionListener(this);
		btn2.addActionListener(this);

		add(txt1);
		add(label);
		add(txt2);
		add(optLabel);
		add(resLabel);

		add(btn1);
		add(btn2);

		setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		int a = Integer.parseInt(txt1.getText());
		int b = Integer.parseInt(txt2.getText());
		if (e.getActionCommand() == "���") {
			resLabel.setText(String.valueOf(a + b));
		} else if (e.getActionCommand() == "���") {
			resLabel.setText(String.valueOf(a - b));
		}
	}

}

public class Test {

	public static void main(String[] args) {

		new MyCalculate("������");
	}
}