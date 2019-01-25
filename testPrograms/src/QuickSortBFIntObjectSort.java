import java.util.ArrayList;
import java.util.List;

public class QuickSortBFIntObjectSort {

        public static void main(String args[]){
            List<Integer> arr = new ArrayList<>();
            arr.add(12);
            arr.add(76);
            arr.add(-1);
            arr.add(4);
            arr.add(4);
            arr.add(4);
            arr.add(33);
            arr.add(0);

            List<Integer> sortedArr = quicksort(arr);
            for(int i : sortedArr){
                System.out.println(i);
            }
        }
        public static List<Integer> quicksort(List<Integer> arr){
            int sizeOfArray = arr.size();

            if(sizeOfArray <= 1){
                return arr;
            }
            int pivotIndex = sizeOfArray / 2;
            int pivotVal = arr.get(pivotIndex);

            List<Integer> smaller = new ArrayList();
            List<Integer> bigger = new ArrayList();

            for(int i = 0; i < sizeOfArray; i++){
                if(i != pivotIndex){
                    Integer arrValue = arr.get(i);

                    if(arrValue < pivotVal){
                        smaller.add(arrValue);
                    }
                    else if(arrValue > pivotVal){
                        bigger.add(arrValue);
                    }
                    else{
                        if(i < pivotIndex){
                            smaller.add(arrValue);
                        }
                        else{
                            bigger.add(arrValue);
                        }
                    }
                }
            }
            List<Integer> returnList = quicksort(smaller); returnList.add(pivotVal); returnList.addAll(quicksort(bigger));
            return returnList;
        }

}
