package training.lesson08;

public class Change {

	public static void main(String[] args) {
		// 数値リテラルはアンダースコアを入れて桁の可読性をよくすることが出来る
		int deposit = 10_000; // 10000 と同等
		int amount = 3_214; // 3214 と同等
		
		int tenThousandYen = 0;
		int fiveThousandYen = 0;
		int oneThousandYen = 0;
		int fiveHundredYenCoin = 0;
		int oneHundredYenCoin = 0;
		int fiftyYenCoin = 0;
		int tenYenCoin = 0;
		int fiveYenCoin = 0;
		int oneYenCoin = 0;
		
		// 以下に処理を追加する
		int change = deposit - amount;
		while(true) {
			if(change > 10_000) {
				for(; change >= 10_000; ) {
					
				}
			}
		}
	}

}
