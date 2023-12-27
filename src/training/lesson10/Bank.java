package training.lesson10;

import java.util.HashMap;
import java.util.Map;

public class Bank {
	// フィールド
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

	// メニュー選択
	public void selectMenu() {
		System.out.println("いらっしゃいませ、ようこそSLS銀行へ");
		boolean isFinished = true;
		while (isFinished) {
			int inputMenu = CommonIO.inputMenu(this.menu);
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