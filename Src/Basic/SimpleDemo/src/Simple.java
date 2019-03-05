import java.util.Scanner;

public class Simple {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	/**
	 * 判断字符串是否回文
	 */
	public static void checkBackString() {
		while (true) {
			System.out.println();
			Scanner scan = new Scanner(System.in);
			System.out.print("请输入要校验的字符串：");
			String inputString = scan.nextLine();
			StringBuilder builder = new StringBuilder(inputString);

			if (builder.reverse().toString().equals(inputString)) {
				System.out.println("您输入的字符串是回文！");
			} else {
				System.out.println("您输入的字符串非回文！");
			}
		}
	}
}
