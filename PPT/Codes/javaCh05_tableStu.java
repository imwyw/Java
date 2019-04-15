import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import java.awt.*;
import java.awt.event.*;

class MyFrame extends JFrame {

	public MyFrame(String title) {
		super(title);
		setSize(600, 300);

		// �����������ģ��
		DefaultTableModel tableModel = new DefaultTableModel();
		// �����ͼ
		JTable table = new JTable(tableModel);
		// ���ñ���и�
		table.setRowHeight(30);
		// �������
		JScrollPane scrollPane = new JScrollPane(table);
		add(scrollPane);// �����������

		String[] headers = { "ѧ��", "�������", "Java", "���ݿ�", "�ܳɼ�", "ƽ���ɼ�" };
		// ѭ����ӱ�ͷ
		for (String head : headers) {
			tableModel.addColumn(head);
		}
		// ѭ����Ӳ�������
		for (int i = 0; i < 20; i++) {
			Object[] row = { 1000 + i, 0, 0, 0, 0, 0 };
			tableModel.addRow(row);
		}

		setLocationRelativeTo(null);// ���þ�����ʾ
		setVisible(true);
	}

}

public class Test {

	public static void main(String[] args) {
		Font fnt = new Font("΢���ź�", Font.BOLD, 20);
		MyFontUtil.initGlobalFontSetting(fnt);

		new MyFrame("demo");

	}
}