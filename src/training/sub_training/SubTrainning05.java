package training.sub_training;

public class SubTrainning05 {

	public static void main(String[] args) {
		tri(3, '7');
		tri(4, '@');
		tri(8, '\\');
	}
	
	static void tri(int size, char cr) {
		for(int i = 0; i < size + 1; i++) {
			for(int j =  0; j < i; j++) {
				System.out.print(cr);
			}
			System.out.println();
		}
	}
}
