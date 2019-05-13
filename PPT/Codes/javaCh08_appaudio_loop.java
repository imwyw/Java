package com.aiit.media;

import java.applet.AudioClip;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JApplet;
import javax.swing.JButton;

public class TestAppAudioLoop extends JApplet implements ActionListener {
	// audio声音对象
	AudioClip ac;

	// 初始化，自动调用
	public void init() {
		// 设置流动布局
		setLayout(new FlowLayout());
		JButton btnLoop = new JButton("循环播放");
		JButton btnStop = new JButton("停止播放");
		btnLoop.addActionListener(this);// 添加事件监听
		btnStop.addActionListener(this);// 添加事件监听
		add(btnLoop);
		add(btnStop);
		ac = getClip("D:/1.wav");

		setVisible(true);
	}

	// 根据文件名称获取
	public AudioClip getClip(String filename) {
		try {
			File file = new File(filename);
			AudioClip audio = getAudioClip(file.toURI().toURL());
			return audio;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return null;
		}
	}

	// 事件处理
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand().equals("循环播放")) {
			ac.loop();
		} else {
			ac.stop();
		}
	}
}
