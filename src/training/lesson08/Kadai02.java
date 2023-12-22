package training.lesson08;

public class Kadai02 {

	public static void main(String[] args) {
		int num = 12304;
		System.out.println("整数値 : " + num);
		char[] strNum = String.valueOf(num).toCharArray();
		int total = 0;
		for(char n :strNum) {
			total += Character.getNumericValue(n);
		}
		System.out.println("各桁の合計値 : " + total);
	}
}
