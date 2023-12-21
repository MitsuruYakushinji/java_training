package training.explanation;

public class Game {
    public static int MAX_KINDS = 4;

    public static void execute(String guess, String solution) {
        if (guess.length() != solution.length()) return;
        Result result = Game.estimate(guess, solution);
        System.out.println(result.toString());
    }

    public static int code(char c) {
        switch (c) {
            case 'A':
                return 0;
            case 'B':
                return 1;
            case 'C':
                return 2;
            case 'D':
                return 3;
            default:
                return -1;
        }
    }

    public static Result estimate(String guess, String solution) {
        Result res = new Result();
        int[] frequencies = new int[MAX_KINDS];
        /* ヒットを数えて頻度配列を作成する */
        for (int i = 0; i < guess.length(); i++) {
            if (guess.charAt(i) == solution.charAt(i)) {
                res.hits++;
            } else {
                /* ヒットでない場合のみ頻度配列を増やす
                 * ヒットの場合は、そのスロットはすでに使われている */
                int code = code(solution.charAt(i));
                frequencies[code]++;
            }
        }
        /* 擬似ヒットを計算する */
        for (int i = 0; i < guess.length(); i++) {
            int code = code(guess.charAt(i));
            if (code >= 0 && frequencies[code] > 0 && guess.charAt(i) != solution.charAt(i)) {
                res.pseudoHits++;
                frequencies[code]--;
            }
        }
        return res;
    }
}
