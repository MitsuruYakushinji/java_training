package training.lesson07;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.regex.Pattern;

public class ListOfString{
	// 正規表現パターン
	private final String pattern = "^[ABCD]+$";
	// 正解データのリスト
	private List<String> answer = new ArrayList<String>(4);
	// 予測データのリスト
	private List<String> prediction = new ArrayList<String>(4);
	
	// 正解データの(get;set;)
	private List<String> getAnswer(){
		return this.answer;
	}
	private void setAnswer(char[] charArray1) throws NotMatchException{
		
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
	private void setPrediction(char[] charArray2) throws NotMatchException{
		
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
	private char[] charArray() {
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
	private boolean isMatch(String cha) {
		return Pattern.matches(pattern, cha);
	}
	
	// ヒットとブローの数を数えるメソッド
	private void countHitAndBlows(List<String> answer, List<String> prediction) {
		Set<Character> answerSet = new HashSet<>();
		Set<Character> predictionSet = new HashSet<>();
		
		int hits = 0;
		int blows = 0;
		
		for(int i = 0; i < answer.size(); i++) {
			String ans = answer.get(i);
			String pred = prediction.get(i);
			
			for(int j = 0; j < ans.length(); j++) {
				char ansChar = ans.charAt(j);
				char predChar = pred.charAt(j);
				
				if(ansChar == predChar) {
					hits++;
				} else {
					answerSet.add(ansChar);
					predictionSet.add(predChar);
				}
			}
		}
		
		// ブローの数を計算
		for(char predChar : predictionSet) {
			if(answerSet.contains(predChar)) {
				blows++;
			}
		}
		
		System.out.println(hits + "ヒット " + blows + "ブロー");
	}
	
	// 正解データと予測データの比較(実行メソッド)
	public void excute() {
		try {
			System.out.print("正解データを入力してください >>");
			setAnswer(charArray());
			
			System.out.print("予測データを入力してください >>");
			setPrediction(charArray());
			
			List<String> answer = getAnswer();
			List<String> prediction = getPrediction();
			
			countHitAndBlows(answer, prediction);
			
		} catch (NotMatchException e) {
			
			e.Message("条件に合致していません");
			e.printStackTrace();
			
		}
	}
}
