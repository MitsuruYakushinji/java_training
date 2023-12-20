package training;

public class Lesson07_01 {
	public static void main(String[] args) {
		String str = "abacdefg";
        System.out.println(isUniqueChars(str));
	}

	private static boolean isUniqueChars(String str) {
		
		char[] charArray = str.toCharArray();
		
		for(int i = 0; i < charArray.length; i++) {
			for(int j = 0; j < charArray.length; j++) {
				if(i != j && charArray[i] == charArray[j]) {
					return false;
				}
			}
		}
		return true; // 重複なしならtrue
	}
}
