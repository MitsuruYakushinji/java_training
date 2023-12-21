package training;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class Lesson07_05 {

	public static void main(String[] args) {
		
		
	}
}

class ListOfString{
	// 正規表現パターン
	private String pattern = "[ABCD]";
	// 正解データのリスト
	private List<String> answer = new ArrayList<String>(4);
	// 予測データのリスト
	private List<String> prediction = new ArrayList<String>(4);
	
	// 正解データの(get;set;)
	public List<String> getAnswer(){
		return this.answer;
	}
	public void setAnswer(char[] charArray1) throws NotMatchException{
		
		// String型の配列に変換
        String[] stringArray1 = new String[]{new String(charArray1)};
		
		if(stringArray1.length > 5) throw new NotMatchException();
		
		for(String str1 : stringArray1) {
			if(isMatch(str1)) {
				this.answer.add(str1);
			} else {
				throw new NotMatchException();
			}
		}
	}
	
	// 予測データの(get;set;)
	public List<String> getPrediction(){
		return this.prediction;
	}
	public void setPrediction(char[] charArray2) throws NotMatchException{
		
		// String型の配列に変換
        String[] stringArray2 = new String[]{new String(charArray2)};
		
		if(stringArray2.length > 5) throw new NotMatchException();
		
		for(String str2 : stringArray2) {
			if(isMatch(str2)) {
				this.prediction.add(str2);
			} else {
				throw new NotMatchException();
			}
		}
	}
	
	// 入力された文字列をchar型の配列に格納する
	public char[] charArray() {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			char[] charArray = br.readLine().toCharArray();
			return charArray;
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		} 
	}
	
	// 正規表現とマッチするか
	public boolean isMatch(String cha) {
		return Pattern.matches(pattern, cha);
	}
	
	// 正解データと予測データの比較(実行メソッド)
	public void excute() {
		System.out.println();
	}
}

class NotMatchException extends Exception{
	
}







