package training.lesson08;

public class Change {

	public static void main(String[] args) {

		int deposit = 10_000; // 10000 と同等
		int amount = 3_214; // 3214 と同等
		int change = deposit - amount;

		int[] denominations = { 10_000, 5_000, 1_000, 500, 100, 50, 10, 5, 1 };
		int[] count = new int[denominations.length];

		for (int i = 0; i < denominations.length; i++) {
			while (change >= denominations[i]) {
				change -= denominations[i];
				count[i]++;
			}
		}

		System.out.println(String.format("合計金額 : %,d円 預り金 : %,d円 おつり : %,d円", amount, deposit, deposit - amount));

		String[] unitNames = { "10,000円札", "5,000円札", "1,000円札", "500円硬貨", "100円硬貨", "50円硬貨", "10円硬貨", "5円硬貨", "1円硬貨" };

		for (int i = 0; i < count.length; i++) {
			System.out.println(unitNames[i] + " : " + count[i] + "枚");
		}
	}
}
