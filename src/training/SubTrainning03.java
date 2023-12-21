package training;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SubTrainning03 {

	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			System.out.print("１つ目の整数>>");
			int x = Integer.parseInt(br.readLine());
			System.out.print("2つ目の整数>>");
			int y = Integer.parseInt(br.readLine());
			System.out.print("3つ目の整数>>");
			int z = Integer.parseInt(br.readLine());
			
			int[] nums = {x, y, z};
			
			int maxInt = bigNum(x, y);
			
			if(maxInt < bigNum(x, z)) {
				maxInt = bigNum(x, z);
			}
			
			System.out.println("最大値は" + maxInt + "です。");
			
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	static int bigNum(int numA, int numB) {
		if(numA > numB) {
			return numA;
		} else {
			return numB;
		}
	}
}
