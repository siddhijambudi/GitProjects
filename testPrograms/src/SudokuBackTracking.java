public class SudokuBackTracking {
    public static void main(String[] args){
        int[][] board = new int[][]
                {
                        {3, 0, 6, 5, 0, 8, 4, 0, 0},
                        {5, 2, 0, 0, 0, 0, 0, 0, 0},
                        {0, 8, 7, 0, 0, 0, 0, 3, 1},
                        {0, 0, 3, 0, 1, 0, 0, 8, 0},
                        {9, 0, 0, 8, 6, 3, 0, 0, 5},
                        {0, 5, 0, 0, 9, 0, 6, 0, 0},
                        {1, 3, 0, 0, 0, 0, 2, 5, 0},
                        {0, 0, 0, 0, 0, 0, 0, 7, 4},
                        {0, 0, 5, 2, 0, 6, 3, 0, 0}
                };
        int N = 9;
        if(solve(board, N)){
            for(int i = 0; i < N; i++){
                for(int j = 0; j < N; j++){
                    System.out.print(board[i][j] + " ");
                }
                System.out.println();
            }
        }
        else{
            System.out.print("Can not solve");
        }
    }
    static boolean solve(int[][] board, int N){
        int row = -1;
        int col = -1;
        boolean solve = true;

        for(int i = 0; i < N; i++){
            for(int j = 0; j < N; j++){
                if(board[i][j] == 0){
                    row = i;
                    col = j;
                    solve = false;
                    break;
                }
            }
            if(!solve){
                break;
            }
        }
        if(solve){
            return true;
        }
        for(int num = 1; num <= N; num++){
            if(isValid(board, row, col, num)){
                board[row][col] = num;
                if(solve(board, N)) {
                    return true;
                }
                board[row][col] = 0;
            }
        }
        return false;
    }
    static boolean isValid(int[][] board, int row, int col, int num){
        int n = board.length;
        //entire row
        for(int c = 0; c < n; c++){
            if(board[row][c] == num){
                return false;
            }
        }

        //entire col
        for(int r = 0; r < n; r++){
            if(board[r][col] == num){
                return false;
            }
        }
        //entire sqare
        int sqrt = (int)(Math.sqrt(n));
        int rowUntil = row - row % sqrt;
        int colUntil = col - col % sqrt;
        for(int r = rowUntil; r < rowUntil + sqrt; r++){
            for(int c = colUntil; c < colUntil + sqrt; c++){
                if(board[r][c] == num){
                    return false;
                }
            }
        }
        return true;
    }
}
