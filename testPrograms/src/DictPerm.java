import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DictPerm {
    public static void main(String args[]){
        char[] arr = new char[]{'c','a','t', 's'};
        perm(arr, 0, arr.length);
    }
    public static void perm(char[] arr, int prefix, int length){
        if(prefix == length - 1){
            if(validWord(arr)) {
                for(char i : arr) {
                    System.out.print(i);
                }
            }
            System.out.println();
            return;
        }
        for(int levelChar = prefix; levelChar < length; levelChar++){

            swap(arr, prefix, levelChar);

            if(validWordPrefix(arr, prefix + 1)){

                perm(arr,prefix + 1, length);

                swap(arr, prefix, levelChar);

            }
        }
    }
    public static boolean validWordPrefix(char[] arr, int length){
        Map<Character, Integer> map = new HashMap<>();
        //map.put('c', 1);
        map.put('s', 1);

        for(int i = 0; i < length; i++){
            if(map.containsKey(arr[i]) && map.get(arr[i]) == 1){
                return true;
            }
        }
        return false;
    }
    public static boolean validWord(char[] arr){
        List<String> dict = new ArrayList<>();
        dict.add("scat");
        dict.add("sact");

        return dict.contains(String.valueOf(arr));
    }
    public static void swap(char[] arr, int prefix, int levelChar){
        char temp = arr[prefix];
        arr[prefix] = arr[levelChar];
        arr[levelChar] = temp;
    }
}
