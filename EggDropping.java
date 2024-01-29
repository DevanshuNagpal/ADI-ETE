import java.util.*;

public class EggDropping {
    /*
    static int eggDrop(int floors, int eggs) {
        int[][] dp = new int[eggs + 1][floors + 1];

        for (int i = 1; i <= eggs; i++) {
            for (int j = 1; j <= floors; j++) {
                if (i == 1) {
                    dp[i][j] = j;
                } else if (j == 1) {
                    dp[i][j] = 1;
                } else {
                    int minAttempts = Integer.MAX_VALUE;
                    for (int x = 1; x <= j; x++) {
                        int breaks = dp[i - 1][x - 1];
                        int doesnBreak = dp[i][j - x];
                        int worstCase = 1 + Math.max(breaks, doesnBreak);
                        minAttempts = Math.min(minAttempts, worstCase);
                    }
                    dp[i][j] = minAttempts;
                }
            }
        }

        return dp[eggs][floors];
    }

     */
    static int eggDrop(int floors, int eggs) {
        int[][] dp = new int[eggs + 1][floors + 1];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }

        return eggDropUtil(floors, eggs, dp);
    }

    static int eggDropUtil(int floors, int eggs, int[][] dp) {
        if (eggs == 1) {
            return floors;
        }
        if (floors == 0 || floors == 1) {
            return floors;
        }
        if (dp[eggs][floors] != -1) {
            return dp[eggs][floors];
        }

        int minAttempts = Integer.MAX_VALUE;
        for (int x = 1; x <= floors; x++) {
            int breaks = eggDropUtil(x - 1, eggs - 1, dp);
            int doesnBreak = eggDropUtil(floors - x, eggs, dp);
            int worstCase = 1 + Math.max(breaks, doesnBreak);
            minAttempts = Math.min(minAttempts, worstCase);
        }

        dp[eggs][floors] = minAttempts;
        return minAttempts;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input for Egg Dropping Puzzle
        int floors = scanner.nextInt();
        int eggs = scanner.nextInt();

        // Output for Egg Dropping Puzzle
        System.out.println(eggDrop(floors, eggs));

        scanner.close();
    }
}
