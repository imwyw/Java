import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class MyFrame extends JFrame {

	public MyFrame(String title) {
		super(title);

		JPanel panel1 = new JPanel();
		JPanel panel2 = new JPanel();
		panel2.setLayout(new BoxLayout(panel2, BoxLayout.Y_AXIS));
		add(panel1, BorderLayout.NORTH);
		add(panel2, BorderLayout.WEST);

		for (int i = 0; i < 5; i++) {
			panel1.add(new JButton("按钮 " + i));
		}
		for (int i = 0; i < 5; i++) {
			panel2.add(new JLabel("标签 " + i));
		}

		pack();// 自适应大小
		setLocationRelativeTo(null);// 设置居中显示
		setVisible(true);
	}

}

public class Test {

	public static void main(String[] args) {
		Font fnt = new Font("微软雅黑", Font.BOLD, 20);
		MyFontUtil.initGlobalFontSetting(fnt);

		new MyFrame("demo");

	}
}