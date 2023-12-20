package training;

public class Lesson07_03 {
	public static void main(String[] args) {
		String str1 = "waterbottle";
		String str2 = "erbottlewat";
		System.out.println(isRotation(str1, str2));
	}

	/**
	 * 片方の文字列がもう片方の文字列の一部分になっているかどうか
	 * @param s1
	 * @param s2
	 * @return 
	 */
	public static boolean isSubstring(String s1, String s2) {
		return s1.matches(".*" + s2 + ".*$");
	}
	
	private static boolean isRotation(String s, String t) {
		
		return true;
	}
}
