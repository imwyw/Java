package com.aiit.media;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import com.util.MyFontUtil;

public class TestCardImage extends JFrame implements ActionListener {
	// 扑克牌的最小、最大和当前索引
	int min = 3, max = 15, current = 3;
	JLabel lbl = new JLabel();

	public TestCardImage() {
		// 定义中心区域Panel面板，主要显示图片
		JPanel pMain = new JPanel();
		pMain.add(lbl);

		// 分别在四个方向添加控制按钮
		JButton btnFirst = new JButton("第一张");
		btnFirst.addActionListener(this);
		JButton btnLast = new JButton("最后一张");
		btnLast.addActionListener(this);
		JButton btnPre = new JButton("前一张");
		btnPre.addActionListener(this);
		JButton btnNext = new JButton("后一张");
		btnNext.addActionListener(this);

		// 设置JLabel显示图像
		refreshLabelIcon();

		setLayout(new BorderLayout());
		add(pMain, BorderLayout.CENTER);
		add(btnFirst, BorderLayout.NORTH);
		add(btnLast, BorderLayout.SOUTH);
		add(btnPre, BorderLayout.WEST);
		add(btnNext, BorderLayout.EAST);

		pack();// 自适应
		setDefaultCloseOperation(EXIT_ON_CLOSE);// 关闭默认操作
		setLocationRelativeTo(null);// 居中显示
		setVisible(true);// 显示
	}

	// 按钮事件处理
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand().equals("第一张")) {
			current = min;
			refreshLabelIcon();
		} else if (e.getActionCommand().equals("最后一张")) {
			current = max;
			refreshLabelIcon();
		} else if (e.getActionCommand().equals("前一张")) {
			current = current == min ? min : --current;
			refreshLabelIcon();
		} else if (e.getActionCommand().equals("后一张")) {
			current = current == max ? max : ++current;
			refreshLabelIcon();
		}
	}

	// 更新标签图标
	private void refreshLabelIcon() {
		ImageIcon img = new ImageIcon("./resource/" + current + ".jpg");
		lbl.setIcon(img);
	}

	public static void main(String[] args) {
		MyFontUtil.initGlobalFontSetting(new Font("微软雅黑", Font.BOLD, 20));
		new TestCardImage();
	}
}
