package game;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CardPickGame {
	private int maxBetCoin = 100; // 最大ベット枚数
	private int deckSetCount = 2; // カードセット数
	private int possessionCoin; // 所持コイン数

	public CardPickGame(int possessionCoin) {
		this.possessionCoin = possessionCoin;
	}

	public void execute() {
		while (true) {
			if (possessionCoin <= 0) {
				System.out.println(this.possessionCoin);
				break;
			}

			System.out.println("You have " + possessionCoin + "Coin, Start the game? y / n");
			// y / n 判定用
			String inputString = GameUtils.getInputString();
			// 現在のベット上限枚数
			int currentMaxBetCoin = 0;
			// 希望ベット枚数
			int inputCoin = 0;
			// 実際のベット枚数
			int betCoin = 0;

			if (inputString.equals("y")) {
				// ベット上限枚数より所持枚数が多い
				if (possessionCoin >= maxBetCoin) {
					// 通常のベット上限枚数
					currentMaxBetCoin = maxBetCoin;
					System.out.println("Please bet Coin 1 ～ " + currentMaxBetCoin);

				} else {
					// ベット上限枚数が現在の所持コイン枚数に
					currentMaxBetCoin = possessionCoin;
					System.out.println("Please bet Coin 1 ～ " + currentMaxBetCoin);

				}

			} else if (inputString.equals("n")) {
				System.out.println(this.possessionCoin);
				break;
			} else {
				// 最初から
				System.out.println("Please enter y or n.");
				execute();
			}

			while (true) {
				// ベットコインの入力
				inputCoin = GameUtils.getInputInt();

				if (inputCoin > 0 && inputCoin <= currentMaxBetCoin) {
					// ベット枚数の確定
					betCoin = possessionCoin - inputCoin;
					break;
				}
			}

			// 勝敗判定
			boolean gameResult = judgeCard(getCard());

			if (gameResult) {
				betCoin *= 2;
				possessionCoin += betCoin;
				System.out.println("You Win! Get " + betCoin + "Coin!");
				System.out.println("You got " + betCoin + "Coin !!");
			} else {
				System.out.println("You lose");
			}
		}
	}

	private int getCard() {
		// デッキの生成
		List<List<Integer>> setDeck = new ArrayList<List<Integer>>();
		List<Integer> onePair = new ArrayList<Integer>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10));
		// 1～10で1組のデッキをdeckSetCountの数分(2組分)生成する。
		for (int i = 0; i < this.deckSetCount; i++) {
			setDeck.add(i, onePair);
		}

		/**
		 * カードを2枚選出
		 * １つ目 [A], 2つ目 [B]とする
		 * デッキから2つの数字をランダムに選出
		 * 
		 */
		int randNumA1;
		int randNumA2;
		int randNumB1;
		int randNumB2;
		while (true) {
			randNumA1 = GameUtils.getRandomInt(2);
			randNumA2 = GameUtils.getRandomInt(10);
			randNumB1 = GameUtils.getRandomInt(2);
			randNumB2 = GameUtils.getRandomInt(10);

			if (!(randNumA1 == randNumB1 && randNumA2 == randNumB2)) {
				break;
			}
		}
		int cardA = setDeck.get(randNumA1).get(randNumA2);
		int cardB = setDeck.get(randNumB1).get(randNumB2);

		int userNumSum = cardA + cardB;

		System.out.println("Cards drawn are " + cardA + " and " + cardB + ", total is " + userNumSum + ".");

		return userNumSum;
	}

	private boolean judgeCard(int getCardResult) {

		if (getCardResult >= 11) {
			return true;
		} else {
			return false;
		}
	}

}
