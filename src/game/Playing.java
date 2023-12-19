package game;

public class Playing {

	public static void main(String[] args) {
		String userName = "";
		int possessionCoin = 1000;

		System.out.println("Welcome !");
		System.out.print("Enter your username>>");
		while (true) {
			userName = GameUtils.getInputString();
			if (GameUtils.checkPattern(userName)) {
				break;
			}
			System.out.println("Does not match condition of the username");
		}
		System.out.println("Hello " + userName);
		
		CardPickGame cardPickGame = new CardPickGame(possessionCoin);
		possessionCoin = cardPickGame.execute();
		
		System.out.println(userName + " Possession : " + possessionCoin + "Coin");
	}
}
