import java.net.*;

public class UdpClient {
	public static void main(String[] args) {
		try {
			// 未指定端口，即任何一个可用端口上
			DatagramSocket dSocket = new DatagramSocket();

			InetAddress sAddr = InetAddress.getByName("127.0.0.1");
			String content = "请求连接";
			byte[] outBuffer = content.getBytes();

			// 发送数据包，服务器监听6000端口，即发送至本机同样端口上
			DatagramPacket outPacket = new DatagramPacket(outBuffer,
					outBuffer.length, sAddr, 6000);
			dSocket.send(outPacket);

			// 接收服务端返回的报文
			byte[] inBuffer = new byte[100];
			DatagramPacket inPacket = new DatagramPacket(inBuffer,
					inBuffer.length);
			dSocket.receive(inPacket);

			content = new String(inPacket.getData(), 0, inPacket.getLength());
			System.out.println("接收到服务端响应：" + content);
			dSocket.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
