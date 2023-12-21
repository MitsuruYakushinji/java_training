package training;

public class AnsLesson07_04 {

	public static void main(String[] args) {
		int a = 3;
		int b = 5;
		swap(a, b);
	}

	public static void swap(int a, int b) {
		a = a - b;
		b = a + b;
		a = b - a;
		System.out.println("a: " + a);
		System.out.println("b: " + b);
	}
}
