import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class MyMouseListener extends MouseAdapter {
	JLabel label;

	@Override
	public void mouseClicked(MouseEvent e) {
		label.setText("鼠标点击位置：x:" + e.getX() + ",y:" + e.getY());
	}
}

class MyFrame extends JFrame {

	public MyFrame(String title) {
		super(title);
		setSize(600, 400);
		JLabel label = new JLabel("初始化。。。");
		// 鼠标监听对象
		MyMouseListener mouseListener = new MyMouseListener();
		mouseListener.label = label;// 标签引用赋值给监听对象
		addMouseListener(mouseListener);

		add(label);

		setLocationRelativeTo(null);// 设置居中显示
		setVisible(true);
	}

}

public class Test {

	public static void main(String[] args) {

		new MyFrame("鼠标点击位置");
	}
}