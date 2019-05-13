package com.aiit.media;

import java.awt.*;
import java.awt.event.*;
import java.io.*;
import javax.swing.*;
import sun.audio.*;

public class TestMusicStartStop extends JFrame implements ActionListener {
	// 声音流对象
	AudioStream as;
	// 循环播放流对象
	ContinuousAudioDataStream cas;

	public TestMusicStartStop() {
		// 设置布局 BorderLayout 边框布局
		setLayout(new BorderLayout());

		// Panel面板，用于划分区域
		JPanel panelBtn = new JPanel(new FlowLayout());
		// Panel面板添加至North区域
		add(panelBtn, BorderLayout.NORTH);

		JButton btnLoop = new JButton("循环播放");
		JButton btnStop = new JButton("停止");
		panelBtn.add(btnLoop);
		panelBtn.add(btnStop);
		btnLoop.addActionListener(this);
		btnStop.addActionListener(this);

		initMusic();

		pack();// 自适应窗体大小
		setLocationRelativeTo(null);// 居中显示
		setDefaultCloseOperation(EXIT_ON_CLOSE);// 关闭按钮作用
		setVisible(true);// 显示窗体
	}

	// 初始化声音对象
	private void initMusic() {
		try {
			as = new AudioStream(new FileInputStream("D:/1.wav"));
			cas = new ContinuousAudioDataStream(as.getData());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// 重写actionPerformed事件处理方法
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand().equals("循环播放")) {
			AudioPlayer.player.start(cas);
		} else {
			AudioPlayer.player.stop(cas);
		}
	}

	public static void main(String[] args) {
		new TestMusicStartStop();
	}
}
