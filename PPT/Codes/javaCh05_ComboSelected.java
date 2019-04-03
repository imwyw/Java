import javax.swing.*;

import java.awt.*;
import java.awt.event.*;

class MyFrame extends JFrame implements ItemListener {

	JLabel label;

	public MyFrame(String title) {
		super(title);
		setSize(600, 400);
		setLayout(new FlowLayout());

		String[] ss = { "计科", "软件", "网络" };
		JComboBox combo = new JComboBox(ss);
		combo.addItemListener(this);

		label = new JLabel("初始化。。。");

		add(combo);
		add(label);
		setLocationRelativeTo(null);// 设置居中显示
		setVisible(true);
	}

	@Override
	public void itemStateChanged(ItemEvent e) {
		label.setText(e.getItem().toString());
	}

}

public class Test {

	public static void main(String[] args) {
		new MyFrame("ComboBox选中");
	}
}