package training.lesson10;

import java.util.HashMap;
import java.util.Map;

public class ATM {
	// フィールド
	public Map<Integer, String> menu = new HashMap<Integer, String>();

	public ATM(Integer[] no, String[] manipulation) {
		for (int i = 0; i < no.length; i++) {
			this.menu.put(no[i], manipulation[i]);
		}
	}
}
