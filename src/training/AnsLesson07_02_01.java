package training;

public class AnsLesson07_02_01 {
	public static void main(String[] args) {
		String str1 = "god";
        String str2 = "dog";
        System.out.println(permutation(str1, str2));
	}

	 public static boolean permutation(String s, String t) {
		if(s.length() != t.length()) return false;
		
		int[] letters = new int[128]; // 容量[128]のint型の配列を用意
		char[] s_array = s.toCharArray(); // 文字列[s]をchar型の配列に
		for(char c : s_array) {
			letters[c]++;
		}
		/**
		 *for(char c : s_array) ループの中で、文字列 s 内の各文字に対して、
		 *それぞれの文字が出現する回数を letters 配列に記録しています。
		 *このループでは、文字列 s を一文字ずつ処理して、
		 *各文字の出現回数を letters 配列に反映させています。
		 *以下に、この部分のイメージを具体的な例を使って説明します。
		 *例として、文字列 s が "god" だと仮定します。
		 *初期状態では letters 配列はすべての要素が0に初期化されています。
		 *letters[0] から letters[127] までの全ての要素が0です。
		 *char[] s_array = s.toCharArray(); によって、文字列 s が char 配列に変換されます。
		 *この場合、s_array は ['g', 'o', 'd'] となります。
		 *
		 *for(char c : s_array) ループでは、
		 *c には順番に 'g', 'o', 'd' という各文字が代入されます。
		 *letters[c]++; によって、c に対応する文字の出現回数を1ずつ増やします。
		 *つまり、最初は letters['g'] が1、次に letters['o'] が1、最後に letters['d'] が1増加します。
		 *繰り返し処理が終わると、letters 配列には各文字の出現回数が反映されます。
		 *例えば、"god" の場合、letters 配列は以下のようになります。
		 * letters['g'] = 1
		 * letters['o'] = 1
		 * letters['d'] = 1
		 * このようにして、letters 配列には各文字の出現回数が記録され、
		 * 後の処理で文字列 t の各文字の出現回数を減少させるために使用されます。
		 */
		
		for (int i = 0; i < t.length(); i++) {
			int c = (int)t.charAt(i);
			if(--letters[c] < 0) {
				return false;
			}
		}
		return true;
	}
}
