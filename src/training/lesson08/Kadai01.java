package training.lesson08;

public class Kadai01 {
	public static void main(String[] args) {
		int[] nums = { 40, 84, 10, 37, 24, 3, 58, 29, 76, 55 };
		
		// 以下にソート処理を実装する
		for(int i = 0; i < nums.length - 1; i++) {
			for(int j = nums.length - 1; j > i; j--) {
				if(nums[j - 1] > nums[j]) {
					int temp = nums[j];
					nums[j] = nums[j - 1];
					nums[j - 1] = temp;
				}
			}
		}
		for(int num : nums) {
			System.out.print(num + " ");
		}
	}
}
