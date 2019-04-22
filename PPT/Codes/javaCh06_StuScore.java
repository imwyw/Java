import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

public class StuScore {
	public static void main(String[] args) {
		try {
			File file = new File("data.txt");
			Scanner scan = new Scanner(System.in);

			// 缓冲输出流
			BufferedWriter bWriter = new BufferedWriter(new FileWriter(file));
			for (int i = 0; i < 5; i++) {
				System.out.print("请输入第" + i + 1 + "个学生的成绩(1-100)：");
				int res = scan.nextInt();
				bWriter.write(String.valueOf(res) + "\n");
			}
			bWriter.close();
			System.out.println("保存成功！");

			System.out.println("开始读取....");
			// 缓冲输入流
			BufferedReader bReader = new BufferedReader(new FileReader(file));
			ArrayList<Integer> stuScore = new ArrayList<Integer>();
			String content;
			while (null != (content = bReader.readLine())) {
				stuScore.add(Integer.parseInt(content));
			}
			// 匿名内部类方式从小到大排序
			stuScore.sort(new Comparator<Integer>() {
				public int compare(Integer o1, Integer o2) {
					// TODO Auto-generated method stub
					return o1 - o2;
				}
			});
			for (Integer integer : stuScore) {
				System.out.println(integer);
			}

		} catch (Exception e) {
			System.out.println("发生异常" + e.getMessage());
		}

	}
}
