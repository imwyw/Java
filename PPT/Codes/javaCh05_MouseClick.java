import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class MyMouseListener extends MouseAdapter {
	JLabel label;

	@Override
	public void mouseClicked(MouseEvent e) {
		label.setText("�����λ�ã�x:" + e.getX() + ",y:" + e.getY());
	}
}

class MyFrame extends JFrame {

	public MyFrame(String title) {
		super(title);
		setSize(600, 400);
		JLabel label = new JLabel("��ʼ��������");
		// ����������
		MyMouseListener mouseListener = new MyMouseListener();
		mouseListener.label = label;// ��ǩ���ø�ֵ����������
		addMouseListener(mouseListener);

		add(label);

		setLocationRelativeTo(null);// ���þ�����ʾ
		setVisible(true);
	}

}

public class Test {

	public static void main(String[] args) {

		new MyFrame("�����λ��");
	}
}