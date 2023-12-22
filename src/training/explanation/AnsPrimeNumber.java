package training.explanation;

public class AnsPrimeNumber {

	public static void main(String[] args) {
		int inputNum = 37;
		
		boolean isPrimeNumber = isPrimeNumber(inputNum);
		
		String str = isPrimeNumber ? "素数です" : "素数ではありません";
		System.out.println(inputNum + "は" + str);
	}
	
	public static boolean isPrimeNumber(int inputNum) {
		// 2は素数
		if(inputNum == 2) {
			return true;
		}
		if(inputNum < 2 || inputNum % 2 == 0) {
			return false;
		}
		
		// 2以降の奇数でinputNumの平方根以下までの値を確認
		for(int i = 3; i <= Math.sqrt(inputNum); i += 2) {
			if(inputNum % i == 0) {
				return false;
			}
		}
		return true;
	}
}
