import java.util.*;

/*
 * 编写一个彩票程序，模拟彩票销售及开奖：
	彩票由6个不重复的整数（范围：1-33）组成
	销售函数中由“彩民”输入购买的6个有效数字
	开奖函数产生一个开奖结果数组
	检查函数中对比结果，返回中了几等奖（6个数字全对，返回1表示1等奖，5个数字匹配则返回2表示2等奖，全不对返回0表示未中奖）
*/
public class LotteryTicket {
	static Scanner scan = new Scanner(System.in);
	// 开奖结果数字
	static int[] resArray = new int[6];
	// 购买的彩票数字
	static int[] buyArray = new int[6];

	public static void main(String[] args) {
		inputTicket();
		checkLottery();
	}

	/**
	 * 模拟购买彩票
	 */
	public static void inputTicket() {
		for (int i = 0; i < 6; i++) {
			System.out.print(String.format("请输入第%d个号码：", i + 1));
			buyArray[i] = scan.nextInt();
		}
		System.out.println("您购买的彩票号码是：" + Arrays.toString(buyArray));
	}

	/**
	 * 生成开奖数字
	 */
	public static void getResult() {
		Random rd = new Random();
		for (int i = 0; i < 6; i++) {
			resArray[i] = rd.nextInt(33) + 1;
		}
	}

	/**
	 * 开奖比对
	 */
	public static void checkLottery() {
		getResult();
		// 记录总共有几个数字匹配
		int count = 0;
		for (int i = 0; i < 6; i++) {
			if (resArray[i] == buyArray[i]) {
				count++;
			}
		}
		System.out.println("开奖结果：" + Arrays.toString(resArray));
		System.out.println("您的号码：" + Arrays.toString(buyArray));
		if (count == 6) {
			System.out.println("恭喜您！一等奖！！！");
		} else if (count == 5) {
			System.out.println("二等奖！！！");
		} else {
			System.out.println("很遗憾。。。");
		}
	}

}
