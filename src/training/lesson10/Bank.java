package training.lesson10;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Bank {
	// フィールド
	// BufferedReaderを定数定義しておく
	private static final BufferedReader BR = new BufferedReader(new InputStreamReader(System.in));
	// ATMオブジェクト
	private ATM atm = new ATM();
	// ユーザー情報(保持用)
	private Map<String, String> user = new HashMap<String, String>();
	// メニュー情報
	private Map<Integer, String> menu = new HashMap<Integer, String>();

	// ユーザー情報の設定
	public Bank() {
		// ユーザー情報格納
		user.put("name", "taro");
		user.put("balance", "10000");
		// メニュー情報格納
		menu.put(1, "ATM 利用");
		menu.put(2, "終了");
	}

	// メニュー表示
	private void showMenu(Map<Integer, String> menu) {
		menu.forEach((key, value) -> System.out.print(key + ":" + value + " "));
		System.out.println();
	}
	
	// メニュー番号入力(銀行)
	private int inputMenu(Map<Integer, String> menu) {
		while (true) {
			this.showMenu(menu);
			int input = this.inputNum();

			// 1～2の範囲内か
			if (input > 0 && input <= menu.size()) {
				return input;
			}

			System.out.println("該当する半角数字で入力して下さい");
		}
	}
	
	// 数字入力
	private int inputNum() {
		try {
			System.out.print(">>");
			return Integer.parseInt(BR.readLine());
		} catch (NumberFormatException | IOException e) {
			// NumberFormatExceptionが発生した場合 → 数値以外が入力されたと判断する
			return 0;
		}
	}
	
	public void selectMenu() {
		System.out.println("いらっしゃいませ、ようこそSLS銀行へ");
		boolean isFinished = true;
		while (isFinished) {
//			System.out.println("1:ATM 利用 2:終了");
			int inputMenu = this.inputMenu(this.menu);
			switch (inputMenu) {
			case 1:
				this.useATM();
				break;
			case 2:
				System.out.println("ご利用ありがとうございました、またのご利用お待ちしております");
				isFinished = false;
				break;
			}
		}
	}
	
	// ATM 利用
	private void useATM() {
		// ATMにユーザー情報をセットする
		this.atm.setUser(this.user);
		// ATM利用終了後はフィールドのuserを上書き
		user = this.atm.selectMenu();
	}
}



















