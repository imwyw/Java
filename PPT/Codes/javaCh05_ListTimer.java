import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import java.awt.*;
import java.awt.event.*;
import java.util.Date;

class MyTimer extends JFrame implements ActionListener {
	JButton btnStart = new JButton("��ʼ");
	JButton btnPause = new JButton("��ͣ");
	// list����ģ��
	DefaultListModel listModel = new DefaultListModel();
	// list�������
	JList jList = new JList(listModel);
	// ��ʱ������
	Timer timer;

	public MyTimer(String title) {
		super(title);
		setSize(600, 300);

		// 1000���룬��1�룻 ע�����Ϊ��ǰ����
		timer = new Timer(1000, this);

		JPanel panelBtn = new JPanel(new GridLayout(1, 2));
		add(panelBtn, BorderLayout.NORTH);
		panelBtn.add(btnStart);
		panelBtn.add(btnPause);
		btnStart.addActionListener(this);
		btnPause.addActionListener(this);

		add(jList, BorderLayout.CENTER);

		setLocationRelativeTo(null);// ���þ�����ʾ
		setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// �¼�ԴΪ��ʱ��timer�����뵱ǰʱ��
		if (e.getSource() == timer) {
			listModel.add(0, new Date());
		} else {
			if (e.getActionCommand().equals("��ʼ")) {
				listModel.add(0, "��ʼ");
				timer.start();
			} else if (e.getActionCommand().equals("��ͣ")) {
				listModel.add(0, "��ͣ");
				timer.stop();
			}
		}
	}
}

public class TestProgress {
	public static void main(String[] args) {

		new MyTimer("demo");
	}
}
