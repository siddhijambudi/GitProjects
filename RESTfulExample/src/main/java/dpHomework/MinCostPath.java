package dpHomework;

public class MinCostPath {
    public static void main(String args[]){
        int[][] matrix = new int[][]{
                {1,3,5,8},
                {4,2,1,7},
                {4,3,2,3}
        };
        int M = 3;
        int N = 4;

        int res = dp(matrix,M,N);
        System.out.print(res);
        System.out.println();
        System.out.println();
    }
    static int dp (int[][] matrix, int m, int n){
        int[][] dp = new int[m+1][n+1];
        dp[0][0] = matrix[0][0];

        for(int row = 1; row < m; row++){
            dp[row][0] = dp[row - 1][0] + matrix[row][0];
        }
        for(int row = 0; row < m; row ++){
            for(int col = 1; col < n; col ++){
                if(row == 0){

                    dp[row][col] = dp [row][col - 1] + matrix[row][col];
                }
                else{
                    if(dp[row - 1][col] < dp[row][col - 1]){
                        dp[row][col] = dp[row - 1][col] + matrix[row][col];
                    }else{
                        dp[row][col] = dp[row][col - 1] + matrix[row][col];
                    }
                }
            }
        }
        return dp[m-1][n-1];
    }
}
