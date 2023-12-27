package training.lesson10;

import java.util.HashMap;
import java.util.Map;

public class ATM {
	// フィールド
	private static final int MIN_DEPOSIT_AMOUNT = 1; // 預け入れ下限 1 円
	private static final int MAX_DEPOSIT_AMOUNT = 2000000; // 預け入れ上限 200 万円
	private static final int MIN_WITHDRAWAL_AMOUNT = 1; // 引き出し下限 1 円
	private static final int MAX_WITHDRAWAL_AMOUNT = 500000; // 引き出し上限 50 万円
	
	// メニュー情報
	private Map<Integer, String> menu = new HashMap<Integer, String>();
	// ユーザー情報
	private Map<String, String> user = new HashMap<String, String>();


	
	// コンストラクタであらかじめメニューをセットしておく
	public ATM() {
		menu.put(1, "預け入れ");
		menu.put(2, "引き出し");
		menu.put(3, "残高照会");
		menu.put(4, "終了");
	}

	// メニュー選択
	public Map<String, String> selectMenu() {
		// メッセージ表示
		System.out.println(this.user.get("name") + "様ようこそ");
		boolean isFinished = true;
		while (isFinished) {
			int inputMenu = CommonIO.inputMenu(menu);
			switch (inputMenu) {
			case 1:
				this.ansDeposit();
				break;
			case 2:
				this.withdrawal();
				break;
			case 3:
				this.balanceInquiry();
				break;
			case 4:
				System.out.println("ATM のご利用ありがとうございます");
				isFinished = false;
				break;
			}
		}
		return this.user;
	}

	// 残高照会
	private void balanceInquiry() {
		System.out.println("残高は " + this.user.get("balance") + " 円です");
	}
	
	// 引き出し
	private void withdrawal() {
		int balance = Integer.parseInt(this.user.get("balance"));
		if(balance <= 0) {
			System.out.println("残高がありません");
			return;
		}
		int amount = -1;
		while (true) {
			System.out.println("ご出金額を入力してください");
			amount = CommonIO.inputNum();
			if (amount < MIN_WITHDRAWAL_AMOUNT || amount > MAX_WITHDRAWAL_AMOUNT) {
				System.out.println(MIN_WITHDRAWAL_AMOUNT + " 円から "
				+ (MAX_WITHDRAWAL_AMOUNT / 10000) + " 万円以内で入力してください");
				continue;
			}
			if(amount <= balance) {
				break;
			}
			System.out.println("残高が不足しています、残高は " + balance +" 円です");
		}
		System.out.println(amount + " 円お返ししました");
		
		this.user.replace("balance", String.valueOf(balance - amount));
	}

	// 預け入れ(解答)
	private void ansDeposit() {
//		Integer balance = this.getUserValue(this.user); // ユーザーの今の口座残高
		int amount = -1;
		while (true) {
			System.out.println("ご入金額を入力してください");
			amount = CommonIO.inputNum();
			if (amount >= MIN_DEPOSIT_AMOUNT && amount <= MAX_DEPOSIT_AMOUNT) {
				break;
			}
			System.out.println(MIN_DEPOSIT_AMOUNT + " 円から "
					+ (MAX_DEPOSIT_AMOUNT / 10000) + " 万円以内で入力してください");
		}
		this.user.replace("balance", String.valueOf(Integer.parseInt(this.user.get("balance")) + amount));
		System.out.println(amount + " 円お預かりしました");
	}
	
	// ユーザー情報セット
	public void setUser(Map<String, String> user) {
		this.user = user;
	}
}

