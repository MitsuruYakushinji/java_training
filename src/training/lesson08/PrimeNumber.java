package training.lesson08;

public class PrimeNumber {
	public static void main(String[] args) {
		int inputNum = 37;

		// 以下出力の処理をコーディングする
		if(isPrimeNumber(inputNum)) {
			System.out.println(inputNum + "は素数です");
		} else {
			System.out.println(inputNum + "は素数ではありません");
		}

	}

	public static boolean isPrimeNumber(int inputNum) {
		// 以下素数の確認をする処理を追加する
		
		if(inputNum <= 1) {
			return false;
		}
		
		if(inputNum % 2 == 0) {
			return false;
		}
		return true;
	}
}