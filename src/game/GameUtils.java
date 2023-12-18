package game;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Random;
import java.util.regex.Pattern;

public class GameUtils {
	// フィールド定義
	private static final String REGEX_ALPHABET = "^[A-Za-z]{4,12}$";
	// コンストラクタ作成
	private GameUtils() {}
	
	/**
	 * 
	 * @return 入力された文字列を返す
	 */
	public static String getInputString() {
		String inputString = null;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			inputString = br.readLine();
		} catch (IOException e) {
			System.out.println("Input error...Please retype!");
			getInputString();
		}
		return inputString;
	}
	
	/**
	 * 
	 * @return 入力された整数値を返す
	 */
	public static int getInputInt() {
		int inputInt = 0;
		try {
			inputInt = Integer.parseInt(getInputString());
		}catch (NumberFormatException e){
			System.out.println("Please enter an integer!");
			getInputInt();
		}
		return inputInt;
	}
	
	/**
	 * 
	 * 整数の乱数を発生させ返却
	 * 
	 * @param maxValue 発生させる整数の指定最大値
	 * @return 発生させた整数値の乱数
	 */
	public static int getRandomInt(int maxValue) {
		Random random = new Random();
		return random.nextInt(maxValue);
	}
	
	/**
	 * 正規表現を用いて入力文字列のチェック
	 * 
	 * @param targetStr チェックする文字列
	 * @return 正規表現と文字列の照合結果(true or false)
	 */
	public static boolean checkPattern(String targetStr) {
		/**
		 * null or 空文字ならfalse
		 */
		if (targetStr == null || targetStr.isEmpty()) {
			return false;
		}
		
		/**
		 * 上記以外はこちらで正規表現とマッチするか判定し、
		 * true or false で返す
		 */
		return Pattern.matches(REGEX_ALPHABET, targetStr);
	}
}
