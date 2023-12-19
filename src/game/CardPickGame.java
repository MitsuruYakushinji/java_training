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

	public int execute() {
		while (true) {
			if (possessionCoin == 0) {
				return this.possessionCoin;
			}

			while (true) {
				System.out.println("You have " + possessionCoin + "Coin, Start the game? y / n");
				// y / n 判定用
				String startValue = GameUtils.getInputString();

				if (startValue.equals("y")) {
					break;
				} else if (startValue.equals("n")) {
					return this.possessionCoin;
				} else {
					System.out.println("Please enter y or n.");
				}
			}

			int ableBetCoin = Math.min(this.maxBetCoin, this.possessionCoin);
			System.out.println("Please bet Coin 1 ~ " + ableBetCoin);

			int userBetCoin = 0;
			while (true) {
				// ベットコインの入力
				userBetCoin = GameUtils.getInputInt();

				if (userBetCoin > 0 && userBetCoin <= ableBetCoin) {
					break;
				}
			}

			this.possessionCoin -= userBetCoin;

			// カード結果の取得
			int userCard = this.getCard();

			// 勝敗判定
			boolean isWinner = this.judgeCard(userCard);
			int getCoin = 0;

			if (isWinner) {
				getCoin = userBetCoin * 2;
				System.out.println("You Win! Get " + getCoin + "Coin!");
				this.possessionCoin += getCoin;
				// System.out.println("You got " + getCoint + "Coin !!");
			}

			if (getCoin == 0) {
				System.out.println("You lose");
			}
			if (getCoin >= 1) {
				System.out.println("You got " + getCoin + "Coin !!");
			}
			// 7. 「1. 現在の所持コイン枚数を確認する」の処理に戻る
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
