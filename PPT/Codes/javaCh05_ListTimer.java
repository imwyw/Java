import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import java.awt.*;
import java.awt.event.*;
import java.util.Date;

class MyTimer extends JFrame implements ActionListener {
	JButton btnStart = new JButton("开始");
	JButton btnPause = new JButton("暂停");
	// list数据模型
	DefaultListModel listModel = new DefaultListModel();
	// list组件对象
	JList jList = new JList(listModel);
	// 定时器对象
	Timer timer;

	public MyTimer(String title) {
		super(title);
		setSize(600, 300);

		// 1000毫秒，即1秒； 注册监听为当前对象
		timer = new Timer(1000, this);

		JPanel panelBtn = new JPanel(new GridLayout(1, 2));
		add(panelBtn, BorderLayout.NORTH);
		panelBtn.add(btnStart);
		panelBtn.add(btnPause);
		btnStart.addActionListener(this);
		btnPause.addActionListener(this);

		add(jList, BorderLayout.CENTER);

		setLocationRelativeTo(null);// 设置居中显示
		setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// 事件源为定时器timer，插入当前时间
		if (e.getSource() == timer) {
			listModel.add(0, new Date());
		} else {
			if (e.getActionCommand().equals("开始")) {
				listModel.add(0, "开始");
				timer.start();
			} else if (e.getActionCommand().equals("暂停")) {
				listModel.add(0, "暂停");
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
