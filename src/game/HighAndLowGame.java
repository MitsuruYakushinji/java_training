package game;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class HighAndLowGame {
	// 獲得コイン枚数
	private int earnedCoinCount;
	// 最大獲得可能コイン枚数
	private int maxWinCoin = 10000;
	// カードセット数
	private int deckSetCount;

	// コンストラクタ
	public HighAndLowGame(int earnedCoinCount, int deckSetCount) {
		this.earnedCoinCount = earnedCoinCount;
		this.deckSetCount = deckSetCount;
	}

	public int execute() {
		List<Integer> cardList = new ArrayList<Integer>();
		
		cardList = this.getCard(cardList);
		while (true) {
			if (this.earnedCoinCount > this.maxWinCoin) {
				return this.earnedCoinCount;
			}
			System.out.println("Your WinCoin is " + this.earnedCoinCount);

			// 選択肢の入力を受け付ける(y:yes / n:no)
			while (true) {
				System.out.print("Playing High And Low ? y / n >>");
				String startValue = GameUtils.getInputString();
				if (startValue.equals("n")) {
					return this.earnedCoinCount;
				} else if (startValue.equals("y")) {
					break;
				} else {
					System.out.println("Input error...Please retype!");
				}
			}

			System.out.print("High or Low ? h / l >>");
			String userChoice = GameUtils.getInputString();
			cardList = this.getCard(cardList);
			boolean isWinner = judgeCard(cardList, userChoice.equals("h"));
			if (isWinner) {
				this.earnedCoinCount *= 2;
			} else {
				this.earnedCoinCount = 0;
			}

			if (earnedCoinCount == 0) {
				return this.earnedCoinCount;
			}
			System.out.println("You got " + earnedCoinCount + "Coin !!");
		}
	}

	private List<Integer> getCard(List<Integer> cardList) {
		// デッキの用意
		// -カードの数字は１から10までの組み合わせが２組(deckSetCount = 2)ある
		List<List<Integer>> setDeck = new ArrayList<List<Integer>>();
		List<Integer> onePair = new ArrayList<Integer>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10));
		// 1～10で1組のデッキをdeckSetCountの数分(2組分)生成する。
		for (int i = 0; i < this.deckSetCount; i++) {
			setDeck.add(i, onePair);
		}

		int cardA; // 選ばれたカードの数字

		// カードを１枚選ぶ
		while (true) {
			/**
			 * 2.カードを1枚選出する
			 * 2-1. 1～10までの数字を1つランダムに選出する
			 * 3. deckSetCount上問題ない数字か判定する
			 */
			int randNumA1 = GameUtils.getRandomInt(2); // 0または1をランダムに選ぶ
			int randNumA2 = GameUtils.getRandomInt(10);
			cardA = setDeck.get(randNumA1).get(randNumA2);

			int count = 0;
			for (int value : cardList) {
				if (cardA == value) {
					count++;
				}
			}
			if (count < this.deckSetCount) {// 問題がない場合
				break;
			}
			/**
			* 問題がある場合
			*   「2. カードを1枚選出する」の処理に戻る
			*/
		}
		// cardListに選出したカードを追加する
		cardList.add(cardA);
		int lastIdx = cardList.size() - 1;
		int showValue = cardList.get(lastIdx);
		/**
		 * 5. 選出したカードを出力する
		 * 「pick card --xx--」(xxは選出したカードの数字)
		 */
		System.out.println("pick card --" + showValue + "--");
		// cardListを返却
		return cardList;
	}

	private boolean judgeCard(List<Integer> cardList, boolean pickChoice) {
		int lastCard = cardList.get(cardList.size() - 1); // cardListの最後の数字
		int penultimateCard = cardList.get(cardList.size() - 2); // cardListの最後から2番目の数字

		// 結果の判定
		if (lastCard == penultimateCard) {
			return false; //負け
		}

		boolean flg = (lastCard > penultimateCard) ? true : false;

		if (pickChoice == flg) {
			return true;
		}
		return false;
	}
}