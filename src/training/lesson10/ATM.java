package training.lesson10;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class ATM {
	// BufferedReaderを定数定義しておく
	private static final BufferedReader BR = new BufferedReader(new InputStreamReader(System.in));
	// フィールド
	private Map<Integer, String> menu = new HashMap<Integer, String>();
	// 残高
//	private int balance = 0;
	// ユーザー情報
	private Map<String, Integer> user = new HashMap<String, Integer>();

	private static final int MIN_DEPOSIT_AMOUNT = 1; // 預け入れ下限 1 円
	private static final int MAX_DEPOSIT_AMOUNT = 2000000; // 預け入れ上限 200 万円

	private static final int MIN_WITHDRAWAL_AMOUNT = 1; // 引き出し下限 1 円
	private static final int MAX_WITHDRAWAL_AMOUNT = 500000; // 引き出し上限 50 万円

	
	// コンストラクタであらかじめメニューをセットしておく
	public ATM() {
		menu.put(1, "預け入れ");
		menu.put(2, "引き出し");
		menu.put(3, "残高照会");
		menu.put(4, "終了");
	}
	
	// ユーザー情報のget;set;アクセサー
	public Map<String, Integer> getUser(){
		return this.user;
	}
	public void setUser(String name, Integer balance) {
		this.user.put(name, balance);
	}

	// メニュー表示
	private void showMenu(Map<Integer, String> menu) {
		menu.forEach((key, value) -> System.out.print(key + ":" + value + " "));
		System.out.println();
	}

	// メニュー番号入力
	private int inputMenu(Map<Integer, String> menu) {
		while (true) {
			this.showMenu(menu);
			int input = this.inputNum();

			// 1～4の範囲内か
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

	// メニュー選択
	public void selectMenu() {
		boolean isFinished = true;
		while (isFinished) {
			int inputMenu = this.inputMenu(menu);
			switch (inputMenu) {
			case 1:
				this.deposit();
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
	}

	// 残高照会
	private void balanceInquiry() {
		for
		System.out.println("残高は " + null + " 円です");
	}

	// 預け入れ
	private void deposit() {
		System.out.println("ご入金額を入力して下さい");
		System.out.print(">>");
		try {
			int dep = Integer.parseInt(BR.readLine());
			if (dep >= 1 && dep <= 2000000) {
				this.balance += dep;
				System.out.println(dep + " 円お預かりしました");
			} else {
				throw new IOException();
			}
		} catch (NumberFormatException e) {
			System.out.println("1 円から 200 万円以内で入力してください");
			this.deposit();
		} catch (IOException e) {
			System.out.println("1 円から 200 万円以内で入力してください");
			this.deposit();
		}
	}
	
	// 引き出し
	private void withdrawal() {
		if(balance <= 0) {
			System.out.println("残高がありません");
			return;
		}
		int amount = -1;
		while (true) {
			System.out.println("ご出金額を入力してください");
			amount = this.inputNum();
			if (amount < MIN_WITHDRAWAL_AMOUNT || amount > MAX_WITHDRAWAL_AMOUNT) {
				System.out.println(MIN_WITHDRAWAL_AMOUNT + " 円から "
				+ (MAX_WITHDRAWAL_AMOUNT / 10000) + " 万円以内で入力してください");
				continue;
			}
			if(amount <= this.balance) {
				break;
			}
			System.out.println("残高が不足しています、残高は " + balance +" 円です");
		}
		this.balance -= amount;
		System.out.println(amount + " 円お返ししました");
	}

	// 預け入れ(解答)
	private void ansDeposit() {
		int amount = -1;
		while (true) {
			System.out.println("ご入金額を入力してください");
			amount = this.inputNum();
			if (amount >= MIN_DEPOSIT_AMOUNT && amount <= MAX_DEPOSIT_AMOUNT) {
				break;
			}
			System.out.println(MIN_DEPOSIT_AMOUNT + " 円から "
					+ (MAX_DEPOSIT_AMOUNT / 10000) + " 万円以内で入力してください");
		}
		this.balance += amount;
		System.out.println(amount + " 円お預かりしました");
	}
}
