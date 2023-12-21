package training;

public class AnsLesson07_03 {

	public static void main(String[] args) {
		String str1 = "waterbottle";
		String str2 = "erbottlewat";
		System.out.println(isRotation(str1, str2));
	}

	public static boolean isSubstring(String s1, String s2) {
		return s1.matches(".*" + s2 + ".*$");
	}

	public static boolean isRotation(String s1, String s2) {
		int len = s1.length();
		if (len == s2.length() && len > 0) {
			// s1とs1を連結
			String s1s1 = s1 + s1;
			return isSubstring(s1s1, s2);
		}
		return false;
	}
}
