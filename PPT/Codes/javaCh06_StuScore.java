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

			// ���������
			BufferedWriter bWriter = new BufferedWriter(new FileWriter(file));
			for (int i = 0; i < 5; i++) {
				System.out.print("�������" + i + 1 + "��ѧ���ĳɼ�(1-100)��");
				int res = scan.nextInt();
				bWriter.write(String.valueOf(res) + "\n");
			}
			bWriter.close();
			System.out.println("����ɹ���");

			System.out.println("��ʼ��ȡ....");
			// ����������
			BufferedReader bReader = new BufferedReader(new FileReader(file));
			ArrayList<Integer> stuScore = new ArrayList<Integer>();
			String content;
			while (null != (content = bReader.readLine())) {
				stuScore.add(Integer.parseInt(content));
			}
			// �����ڲ��෽ʽ��С��������
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
			System.out.println("�����쳣" + e.getMessage());
		}

	}
}
