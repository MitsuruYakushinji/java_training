package training.lesson07;

public class Lesson07_03 {
	public static void main(String[] args) {
		String str1 = "waterbottle";
		String str2 = "erbottlewat";
//		String str3 = "abCdefg";
//		String str4 = "Cdefgab";
//		String str5 = "bananafish";
//		String str6 = "fishbanana";

		System.out.println(isRotation(str1, str2));
//		System.out.println(isRotation(str3, str4));
//		System.out.println(isRotation(str5, str6));
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
	
	public static boolean isRotation(String s, String t) {
		String doubleS = s + s;
		return isSubstring(doubleS, t);
	}
}
