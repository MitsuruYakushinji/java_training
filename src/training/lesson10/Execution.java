package training.lesson10;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;

public class Execution {

	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		Integer[] no = { 1, 2, 3, 4 };
		String[] manipulation = { "預け入れ", "引き出し", "残高照会", "終了" };

		ATM atm = new ATM(no, manipulation);

		for (Map.Entry<Integer, String> entry : atm.menu.entrySet()) {
			System.out.print(entry.getKey() + ":" + entry.getValue() + " ");
		}
		System.out.println();

		try {
			Integer selectNum = Integer.parseInt(br.readLine());

			switch (selectNum) {
			case 1:
			case 2:
			case 3:
				break;

			case 4:
				System.out.println("ATM　のご利用ありがとうございました");
			}
		} catch (NumberFormatException | IOException e) {
			e.printStackTrace();
		}
	}
}