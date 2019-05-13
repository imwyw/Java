package com.aiit.media;

import java.awt.*;
import java.awt.image.*;
import java.io.*;
import javax.imageio.ImageIO;
import javax.swing.*;

// 自定义图像Panel
class ImagePanel extends JPanel {
	// 双缓冲图像
	BufferedImage bufImg;

	public ImagePanel() {
		System.out.println("当前支持的可读取图像类型有：");
		for (String extString : ImageIO.getReaderFormatNames()) {
			System.out.println(extString);
		}

		try {
			File f = new File("D:/aiit.jpg");
			bufImg = ImageIO.read(f); // 读取图像
			setPixel(new Color(255, 0, 0)); // 修改图像的部分内容(加条红边)
			f = new File("./resource/aiit_red.png");
			ImageIO.write(bufImg, "png", f); // 保存新的图像

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// 设置颜色 20个像素高度区域绘制
	public void setPixel(Color c) {
		for (int i = 0; i < bufImg.getWidth(); i++)
			for (int j = 0; j < 20; j++) {
				bufImg.setRGB(i, j, c.getRGB());
			}
	}

	// 重回界面，将图片绘制到面板
	protected void paintComponent(Graphics g) {
		g.drawImage(bufImg, 0, 0, 300, 300, this); // 显示图像
	}
}

public class TestImagePanel extends JFrame {
	public TestImagePanel() {
		super("jpanel显示图像");
		add(new ImagePanel(), BorderLayout.CENTER);

		setSize(320, 350);
		setLocationRelativeTo(null);
		setVisible(true);
	}

	public static void main(String[] args) {
		new TestImagePanel();
	}
}
