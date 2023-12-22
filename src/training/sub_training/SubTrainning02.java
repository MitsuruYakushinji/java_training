package training.sub_training;

public class SubTrainning02 {
	public static void main(String[] args) {
		int a = 10;
		int b = 14;
		System.out.println("平均：" + num(a,b));
	}
	
	static int num (int a, int b) {
		int avg = (a + b) / 2;
		return avg;
	}
}
