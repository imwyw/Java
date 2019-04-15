import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import java.awt.*;
import java.awt.event.*;

class MyFrame extends JFrame implements ActionListener {

	// �����������ģ��
	DefaultTableModel tableModel;
	// �����ͼ
	JTable table;
	// �²����б��
	int newRowIndex = 2000;

	public MyFrame(String title) {
		super(title);
		setSize(600, 300);

		tableModel = new DefaultTableModel();
		table = new JTable(tableModel);
		// ���ñ���и�
		table.setRowHeight(30);
		// �������
		JScrollPane scrollPane = new JScrollPane(table);
		add(scrollPane, BorderLayout.CENTER);// ���������������

		JPanel panelBtns = new JPanel(new GridLayout(1, 2));
		String[] btnString = { "�����", "�Ƴ���" };
		for (String bName : btnString) {
			JButton btn = new JButton(bName);
			panelBtns.add(btn);
			btn.addActionListener(this);// ��Ӱ�ť����
		}
		add(panelBtns, BorderLayout.SOUTH);

		String[] headers = { "ѧ��", "�������", "Java", "���ݿ�", "�ܳɼ�", "ƽ���ɼ�" };
		// ѭ����ӱ�ͷ
		for (String head : headers) {
			tableModel.addColumn(head);
		}
		// ѭ����Ӳ�������
		for (int i = 0; i < 5; i++) {
			Object[] row = { 1000 + i, 0, 0, 0, 0, 0 };
			tableModel.addRow(row);
		}

		setLocationRelativeTo(null);// ���þ�����ʾ
		setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getActionCommand().equals("�����")) {
			tableModel.addRow(new Object[] { newRowIndex++, 2, 3, 4, 5, 6 });
		} else if (e.getActionCommand().equals("�Ƴ���")) {
			// ��ȡѡ��������
			int rowIndex = table.getSelectedRow();
			// ��������������ģ����ɾ����
			tableModel.removeRow(rowIndex);
		}
	}

}

public class Test {

	public static void main(String[] args) {
		new MyFrame("demo");
	}
}