package training.lesson10;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;

public class CommonIO {
	// BufferedReaderを定数定義しておく
	private static final BufferedReader BR = new BufferedReader(new InputStreamReader(System.in));

	// メニュー表示
	private static void showMenu(Map<Integer, String> menu) {
		menu.forEach((key, value) -> System.out.print(key + ":" + value + " "));
		System.out.println();
	}

	// メニュー番号入力
	public static int inputMenu(Map<Integer, String> menu) {
		while (true) {
			showMenu(menu);
			int input = inputNum();

			// 渡されたメニューの範囲内か
			if (input > 0 && input <= menu.size()) {
				return input;
			}

			System.out.println("該当する半角数字で入力して下さい");
		}
	}

	// 数字入力
	public static int inputNum() {
		try {
			System.out.print(">>");
			return Integer.parseInt(BR.readLine());
		} catch (NumberFormatException | IOException e) {
			// NumberFormatExceptionが発生した場合 → 数値以外が入力されたと判断する
			return 0;
		}
	}
}
