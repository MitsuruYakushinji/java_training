package training;

public class SubTrainning04 {

	public static void main(String[] args) {
		tri(3);
		tri(4);
		tri(5);
	}
	
	static void tri(int size) {
		for(int i = 0; i < size + 1; i++) {
			for(int j =  0; j < i; j++) {
				System.out.print("$");
			}
			System.out.println();
		}
	}
}