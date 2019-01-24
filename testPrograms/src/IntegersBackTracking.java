import java.util.ArrayList;
import java.util.List;

public class IntegersBackTracking {
    public static void main(String args[]){

        int[] arr = new int[]{8,8,7,7};
        perm(arr, 0, arr.length);
    }
    public static void perm(int[] arr, int prefix, int length){
        if(prefix == length){
            //System.out.println("******************** leaf node");
            for(int i : arr) {
                System.out.print(i);
            }
            System.out.println();
            //System.out.println("*******************************");
            return;
        }
        for(int levelChar = prefix; levelChar < length; levelChar++){
            if(validIndexAndLevelChar(arr[levelChar], prefix)){

                swap(arr, prefix, levelChar);

                /*System.out.println("******************************");
                for(int i : arr) {
                    System.out.print(i);
                }
                System.out.println();
                System.out.println("*******************************");*/

                perm(arr,prefix + 1, length);

                swap(arr, prefix, levelChar);
                /*System.out.println("******************** After leaf go back to parent");

                for(int i : arr) {
                    System.out.print(i);
                }
                System.out.println();
                System.out.println("*******************************");*/
            }
        }
    }
    public static boolean validIndexAndLevelChar(int valueAtLevelChar, int prefix){
        return ((prefix % 2 == 0 && valueAtLevelChar % 2 == 1)|| (prefix % 2 == 1 && valueAtLevelChar % 2 == 0));
    }
    public static void swap(int[] arr, int prefix, int levelChar){
        int temp = arr[prefix];
        arr[prefix] = arr[levelChar];
        arr[levelChar] = temp;
    }
}
