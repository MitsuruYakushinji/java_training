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

	public void execute() {
		List<Integer> cardList = new ArrayList<Integer>();
		cardList = getCard(cardList);
		System.out.println(cardList);
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
		while(true) {
			/**
			 * 2.カードを1枚選出する
			 * 2-1. 1～10までの数字を1つランダムに選出する
			 * 3. deckSetCount上問題ない数字か判定する
			 */
			int randNumA1 = GameUtils.getRandomInt(2); // 0または1をランダムに選ぶ
			int randNumA2 = GameUtils.getRandomInt(10);
			cardA = setDeck.get(randNumA1).get(randNumA2);
			
			int count = 0;
			for(int value : cardList) {
				if(cardA == value) {
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
}