package training;

public class Lesson07_04 {

	public static void main(String[] args) {
		int a = 3;
		int b = 5;
		swap(a, b);
	}

	public static void swap(int a, int b) {
		a = (b + a) - (a + b) + b;
		b = (a * 3) / b;
		
		System.out.println("a: " + a);
		System.out.println("b: " + b);
	}
}
