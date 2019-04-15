import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import java.awt.*;
import java.awt.event.*;

class MyFrame extends JFrame {

	public MyFrame(String title) {
		super(title);
		setSize(600, 300);

		// 创建表格数据模型
		DefaultTableModel tableModel = new DefaultTableModel();
		// 表格视图
		JTable table = new JTable(tableModel);
		// 设置表格行高
		table.setRowHeight(30);
		// 滚动面板
		JScrollPane scrollPane = new JScrollPane(table);
		add(scrollPane);// 添加面板至框架

		String[] headers = { "学号", "软件工程", "Java", "数据库", "总成绩", "平均成绩" };
		// 循环添加表头
		for (String head : headers) {
			tableModel.addColumn(head);
		}
		// 循环添加测试数据
		for (int i = 0; i < 20; i++) {
			Object[] row = { 1000 + i, 0, 0, 0, 0, 0 };
			tableModel.addRow(row);
		}

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