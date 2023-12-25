package training.lesson08;

public class Kadai05 {

	public static void main(String[] args) {
		int total = 0;
		int n = 7;
		System.out.println("合計値 : " + roop(n, total));
	}
	
	public static int roop(int n, int total) {	
		if(n != 1) {
			total += n + (n - 1);
			roop(n - 1, total);
		}
		return total;
	}
}
