import java.util.*;
public class RobotTaskScheduling {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input: Number of rows (R) and number of columns (C)
        int R = scanner.nextInt();
        int C = scanner.nextInt();

        // Input: Grid Values (duration and profit)
        int[][] grid = new int[R][C];
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                grid[i][j] = scanner.nextInt();
            }
        }

        // Calculate maximum total profit
        int result = maxProfit(grid);

        // Output: Maximum total profit achievable by the robot
        System.out.println(result);
    }


//Memoisation
    /*
    private static int maxProfit(int[][] grid) {
        return maxProfit(0,0,grid,new HashMap<>());
    }
    private static int maxProfit(int r,int c,int[][] grid,HashMap<List<Integer>,Integer> memo) {
        if(r == grid.length || c == grid[0].length){
            return Integer.MIN_VALUE;
        }
        if(r == grid.length - 1 && c == grid[0].length-1){
            return grid[r][c];
        }
        List<Integer> pos= List.of(r,c);
        if(memo.containsKey(pos)){
            return memo.get(pos);
        }
        int result = grid[r][c] + Math.max(
                maxProfit(r+1,c,grid,memo),
                maxProfit(r,c+1,grid,memo)
        );
        memo.put(pos,result);
        return result;

    }
     */

//    Tabulation
    private static int maxProfit(int[][] grid){
        int[][] dp = new int[grid.length][grid[0].length];
        for(int i=grid.length - 1;i>=0;i--){
            for(int j = grid[0].length - 1 ; j>=0;j--){
                if(i == grid.length - 1 && j == grid[0].length - 1){
                    dp[i][j] = grid[i][j];
                }
                else{
                    int down = Integer.MIN_VALUE;
                    int right = Integer.MIN_VALUE;
                    if(i+1 <grid.length){
                        down = dp[i+1][j];

                    }
                    if(j+1<grid[0].length){
                        right = dp[i][j+1];
                    }
                    dp[i][j] = grid[i][j] + Math.max(down,right);
                }
            }
        }
        return dp[0][0];
    }
}
