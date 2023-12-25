package training.lesson08;

/**
 * ハノイの塔
 *
 * 円盤 4枚の時
 *
 *  1     | I |              |              |
 *  2    |  J  |             |              |
 *  3   |   K   |            |              |
 *  4  |    L    |           |              |
 *    --------------  --------------  --------------
 *          A                B              C
 *        start             tmp            gaol
 *
 *  1       |                |            | I |
 *  2       |                |           |  J  |
 *  3       |                |          |   K   |
 *  4       |                |         |    L    |
 *    --------------  --------------  --------------
 *          A                B              C
 *        start             tmp            gaol
 */

public class Hanoi {
	public char start = 'A'; // スタートの棒の変数
	public char tmp = 'B'; // 一時移動先の棒の変数
	public char goal = 'C'; // ゴールの棒の変数
	public char[] disks = { 'I', 'J', 'K', 'L' }; // 円盤が 4 枚時の名前
	public int moveCount = 0; // 移動回数

	// 以下に円盤を移動する処理メソッドを追加する
	public void moveDisk(int n, char origin, char destination, char sub) {
		if(n > 0) {
			moveDisk(n - 1, origin, sub, destination);
			
			System.out.println(disks[n - 1] + " の板を " + origin + " から " + destination + " に移動 ");
			moveCount++;
			
			moveDisk(n - 1, sub, destination, origin);
		}
	}
	
	public void solveHanoui() {
		moveDisk(disks.length, start, goal, tmp);
		System.out.println("移動回数 : " + moveCount + "回");
	}
}























