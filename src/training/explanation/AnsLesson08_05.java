package training.explanation;

public class AnsLesson08_05 {

	public static void main(String[] args) {
		int n = 7;
		System.out.println("n =  " + n);
		System.out.println("合計値 : " + sum(n));
	}
	
	public static int sum(int n) {
		if(n > 1) {
			return n + sum(n - 1);
		}
		return 1;
	}
}
