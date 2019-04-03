import javax.swing.*;

import java.awt.*;
import java.awt.event.*;

class MyFrame extends JFrame implements ItemListener {

	JLabel label;

	public MyFrame(String title) {
		super(title);
		setSize(600, 400);
		setLayout(new FlowLayout());

		String[] ss = { "�ƿ�", "���", "����" };
		JComboBox combo = new JComboBox(ss);
		combo.addItemListener(this);

		label = new JLabel("��ʼ��������");

		add(combo);
		add(label);
		setLocationRelativeTo(null);// ���þ�����ʾ
		setVisible(true);
	}

	@Override
	public void itemStateChanged(ItemEvent e) {
		label.setText(e.getItem().toString());
	}

}

public class Test {

	public static void main(String[] args) {
		new MyFrame("ComboBoxѡ��");
	}
}