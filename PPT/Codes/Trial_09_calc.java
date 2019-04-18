import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.*;
import java.util.Enumeration;
import java.util.Random;

import javax.swing.*;
import javax.swing.plaf.FontUIResource;

/**
 * 计算器 随机生成题，计算答案，并判断
 *
 */
class MyGuessCalc extends JFrame implements ActionListener {
	JLabel labelNum1 = new JLabel("0");
	JLabel labelNum2 = new JLabel("0");
	JLabel labelOption = new JLabel("+");
	JLabel labelAns = new JLabel(" 答案是：");
	JTextField txtRes = new JTextField(5);

	JLabel labelTip = new JLabel("提示信息");

	JButton btnCheck = new JButton("检查");
	JButton btnNew = new JButton("刷新");

	public MyGuessCalc() {
		super("两数计算");
		setSize(500, 250);

		// 设置流动布局
		setLayout(new FlowLayout());
		// 纵向盒子
		Box boxMain = Box.createVerticalBox();
		// 创建多个横向盒子
		Box boxTitle = Box.createHorizontalBox();
		Box boxNums = Box.createHorizontalBox();
		Box boxTip = Box.createHorizontalBox();
		Box boxBtn = Box.createHorizontalBox();
		add(boxMain);
		boxMain.add(boxTitle);
		boxMain.add(Box.createVerticalStrut(10));// 添加垂直间距
		boxMain.add(boxNums);
		boxMain.add(Box.createVerticalStrut(10));// 添加垂直间距
		boxMain.add(boxTip);
		boxMain.add(Box.createVerticalStrut(10));// 添加垂直间距
		boxMain.add(boxBtn);

		boxTitle.add(new JLabel("10以内的加减乘除练习"));

		boxNums.add(labelNum1);
		boxNums.add(labelOption);
		boxNums.add(labelNum2);
		boxNums.add(labelAns);
		boxNums.add(txtRes);

		boxTip.add(labelTip);

		// 添加按钮事件监听
		btnCheck.addActionListener(this);
		btnNew.addActionListener(this);
		btnNew.setEnabled(false);// 默认禁用
		boxBtn.add(btnCheck);
		boxBtn.add(btnNew);

		setLocationRelativeTo(null);// 居中显示
		setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
	}

}

public class Trial_09_calc {

	public static void main(String[] args) {
		Font fnt = new Font("微软雅黑", Font.BOLD, 20);
		initGlobalFontSetting(fnt);

		new MyGuessCalc();
	}

	// 设置全局字体
	public static void initGlobalFontSetting(Font fnt) {
		FontUIResource fontRes = new FontUIResource(fnt);
		for (Enumeration keys = UIManager.getDefaults().keys(); keys
				.hasMoreElements();) {
			Object key = keys.nextElement();
			Object value = UIManager.get(key);
			if (value instanceof FontUIResource)
				UIManager.put(key, fontRes);
		}
	}
}
