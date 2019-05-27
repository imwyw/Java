import java.awt.*;
import java.awt.event.*;
import java.net.*;
import java.io.*;
import javax.swing.*;

// P452案例
public class J_ChatClient extends JFrame {
	private ObjectInputStream m_input; // 输入流
	private ObjectOutputStream m_output; // 输出流
	private JTextField m_enter; // 输入区域
	private JTextArea m_display; // 显示区域

	public J_ChatClient() // 在图形界面中添加组件
	{
		super("聊天程序客户端");
		Container c = getContentPane();
		m_enter = new JTextField();
		m_enter.setEnabled(false);

		m_enter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) { // 向服务器端发送数据
				try {
					String s = event.getActionCommand();
					m_output.writeObject(s);
					m_output.flush();
					mb_displayAppend("客户端: " + s);
					m_enter.setText(""); // 清除输入区域的原有内容
				} catch (Exception e) {
					System.err.println("发生异常:" + e);
					e.printStackTrace();
				} // try-catch结构结束
			} // 方法actionPerformed结束
		} // 实现接口ActionListener的内部类结束
		); // addActionListener方法调用结束

		c.add(m_enter, BorderLayout.NORTH);
		m_display = new JTextArea();
		c.add(new JScrollPane(m_display), BorderLayout.CENTER);
	} // J_ChatClient构造方法结束

	public void mb_displayAppend(String s) {
		m_display.append(s + "\n");
		// setCaretPosition对带有滚动的多行文本框有效，滚动条定位至最低端
		m_display.setCaretPosition(m_display.getText().length());
		m_enter.requestFocusInWindow(); // 转移输入焦点到输入区域
	} // 方法mb_displayAppend结束

	// 判断输入意图是否为退出
	public boolean mb_isEndSession(String m) {
		if (m.equalsIgnoreCase("q"))
			return (true);
		if (m.equalsIgnoreCase("quit"))
			return (true);
		if (m.equalsIgnoreCase("exit"))
			return (true);
		if (m.equalsIgnoreCase("end"))
			return (true);
		if (m.equalsIgnoreCase("结束"))
			return (true);
		return (false);
	} // 方法mb_isEndSession结束

	public void mb_run(String host, int port) {
		try {
			mb_displayAppend("尝试连接");
			Socket s = new Socket(host, port);
			String m; // 来自服务器端的消息
			m_output = new ObjectOutputStream(s.getOutputStream());
			m_input = new ObjectInputStream(s.getInputStream());
			m_enter.setEnabled(true);
			
			do {
				m = (String) m_input.readObject();
				mb_displayAppend("服务器端: " + m);
			} while (!mb_isEndSession(m));// do-while循环结束
			
			m_output.writeObject("q"); // 通知服务器端断开
			m_output.flush();
			m_output.close();
			m_input.close();
			s.close();
			System.exit(0);
		} catch (Exception e) {
			System.err.println("发生异常:" + e);
			e.printStackTrace();
			mb_displayAppend("发生异常");
		} // try-catch结构结束
	} // 方法mb_run结束

	public static void main(String args[]) {
		MyFontUtil.initGlobalFontSetting(new Font("微软雅黑", Font.BOLD, 22));
		J_ChatClient app = new J_ChatClient();
		app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		app.setSize(350, 150);
		app.setVisible(true);
		if (args.length == 0)
			app.mb_run("localhost", 5000);
		else
			app.mb_run(args[0], 5000);
	} // 方法main结束
} // 类J_ChatClient结束