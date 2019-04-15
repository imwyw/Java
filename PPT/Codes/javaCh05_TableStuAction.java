import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import java.awt.*;
import java.awt.event.*;

class MyFrame extends JFrame implements ActionListener {

	// 创建表格数据模型
	DefaultTableModel tableModel;
	// 表格视图
	JTable table;
	// 新插入行标记
	int newRowIndex = 2000;

	public MyFrame(String title) {
		super(title);
		setSize(600, 300);

		tableModel = new DefaultTableModel();
		table = new JTable(tableModel);
		// 设置表格行高
		table.setRowHeight(30);
		// 滚动面板
		JScrollPane scrollPane = new JScrollPane(table);
		add(scrollPane, BorderLayout.CENTER);// 添加面板至框架中心

		JPanel panelBtns = new JPanel(new GridLayout(1, 2));
		String[] btnString = { "添加行", "移除行" };
		for (String bName : btnString) {
			JButton btn = new JButton(bName);
			panelBtns.add(btn);
			btn.addActionListener(this);// 添加按钮监听
		}
		add(panelBtns, BorderLayout.SOUTH);

		String[] headers = { "学号", "软件工程", "Java", "数据库", "总成绩", "平均成绩" };
		// 循环添加表头
		for (String head : headers) {
			tableModel.addColumn(head);
		}
		// 循环添加测试数据
		for (int i = 0; i < 5; i++) {
			Object[] row = { 1000 + i, 0, 0, 0, 0, 0 };
			tableModel.addRow(row);
		}

		setLocationRelativeTo(null);// 设置居中显示
		setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getActionCommand().equals("添加行")) {
			tableModel.addRow(new Object[] { newRowIndex++, 2, 3, 4, 5, 6 });
		} else if (e.getActionCommand().equals("移除行")) {
			// 获取选中行索引
			int rowIndex = table.getSelectedRow();
			// 根据索引从数据模型中删除行
			tableModel.removeRow(rowIndex);
		}
	}

}

public class Test {

	public static void main(String[] args) {
		new MyFrame("demo");
	}
}