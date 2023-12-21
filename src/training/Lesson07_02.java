package training;

public class Lesson07_02 {

	public static void main(String[] args) {
		String str1 = "god";
        String str2 = "dog";
        System.out.println(permutation(str1, str2));
	}

	public static boolean permutation(String s, String t) {
		char[] charArrayS = s.toCharArray();
		char[] charArrayT = t.toCharArray();
		
		int cnt = 0;
		
		for(int i = 0; i < charArrayS.length; i++) {
			for(int j = 0; j < charArrayT.length; j++) {
				if(charArrayS[i] == charArrayT[j]) cnt += 1;
			}
		}
		
		return charArrayS.length == cnt ? true : false;
	}
}
