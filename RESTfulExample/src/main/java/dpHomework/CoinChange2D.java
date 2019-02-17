package dpHomework;

import java.util.ArrayList;
import java.util.List;

public class CoinChange2D {
    public static void main(String args[]){
        int total = 8;
        int coins[] = {2,3,5};
        System.out.println(numberOfSolutions(total, coins));
        printCoinChangingSolution(total, coins);
    }
    public static int numberOfSolutions(int total, int coins[]){
        int temp[][] = new int[coins.length+1][total+1];
        for(int i=0; i <= coins.length; i++){
            temp[i][0] = 1;
        }
        for(int i=1; i <= coins.length; i++){
            for(int j=1; j <= total ; j++){
                if(coins[i-1] > j){
                    temp[i][j] = temp[i-1][j];
                }
                else{
                    temp[i][j] = temp[i][j-coins[i-1]] + temp[i-1][j];
                }
            }
        }
        return temp[coins.length][total];
    }
    public static void printCoinChangingSolution(int total,int coins[]){
        List<Integer> result = new ArrayList<>();
        printActualSolution(result, total, coins, 0);
    }

    private static void printActualSolution(List<Integer> result, int total, int coins[], int pos){
        if(total == 0){
            for(int r : result){
                System.out.print(r + " ");
            }
            System.out.print("\n");
        }
        for(int i=pos; i < coins.length; i++){
            if(total >= coins[i]){
                result.add(coins[i]);
                printActualSolution(result,total-coins[i],coins,i);
                result.remove(result.size()-1);
            }
        }
    }

}
