import java.net.*;
import java.util.Date;

public class UdpServer {
	public static void main(String[] args) {
		try {
			// 服务端监听6000端口
			DatagramSocket dSocket = new DatagramSocket(6000);
			while (true) {
				byte[] inBuffer = new byte[100];
				// 接收客户端数据包
				DatagramPacket inPacket = new DatagramPacket(inBuffer,
						inBuffer.length);
				// 方法阻塞，直到接收到数据包
				dSocket.receive(inPacket);
				// 客户端地址
				InetAddress cAddr = inPacket.getAddress();
				// 客户端端口
				int cPort = inPacket.getPort();
				String content = new String(inPacket.getData(), 0,
						inPacket.getLength());
				System.out.println("接收到客户端信息：" + content);
				System.out.println("客户端主机名：" + cAddr.getHostName());
				System.out.println("客户端端口为：" + cPort);

				Date d = new Date();
				byte[] outBuffer = d.toString().getBytes();
				// 发送udp数据报文
				DatagramPacket outPacket = new DatagramPacket(outBuffer,
						outBuffer.length, cAddr, cPort);
				// 按照接收的地址和端口发送数据包
				dSocket.send(outPacket);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
