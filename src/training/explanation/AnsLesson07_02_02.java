package training.explanation;

import java.util.Arrays;

public class AnsLesson07_02_02 {

	public static void main(String[] args) {
		String str1 = "god";
        String str2 = "dog";
        System.out.println(permutation(str1, str2));
	}
	
	public static String sort(String s) {
		char[] content = s.toCharArray();
		Arrays.sort(content);
		return new String(content);
	}

	public static boolean permutation(String s, String t) {
		if(s.length() != t.length()) {
			return false;
		}
		return sort(s).equals(sort(t));
	}

}
