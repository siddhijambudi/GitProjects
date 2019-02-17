package dpHomework;

public class CountPaths {
    static int numberOfPaths(int[][] a) {
        int M = a.length;
        int N = a[0].length;

        int[][] dp = new int[M+1][N+1];
        for(int i = M - 1; i >= 0; i--){
            for(int j = N - 1; j >= 0; j--){
                if(i == M || j == N){
                    dp[i][j] = 0;
                }
                else if(i == M - 1 && j == N - 1){
                    dp[i][j] = 1;
                }
                else{
                    if(a[i][j] == 0){
                        dp[i][j] = 0;
                    }
                    else{
                        dp[i][j] = dp[i][j+1] + dp[i+1][j];
                    }
                }
            }
        }
        return dp[0][0];
    }
    public static void main(String args[]){
        int[][] table = new int[3][3];
        table[0][0] = 1;
        table[0][1] = 0;
        table[0][2] = 0;
        table[1][0] = 1;
        table[1][1] = 1;
        table[1][2] = 1;
        table[2][0] = 1;
        table[2][1] = 1;
        table[2][2] = 1;

        numberOfPaths(table);
    }
}
