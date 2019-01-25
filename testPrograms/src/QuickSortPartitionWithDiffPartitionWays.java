import java.lang.reflect.Array;
import java.util.*;

public class QuickSortPartitionWithDiffPartitionWays {
    public static void main(String args[]){
        //int[] arr = new int[]{12,76,-1,4,33,0};
        List<Integer> arr = new ArrayList<>();
        arr.add(12);
        arr.add(76);
        arr.add(-1);
        arr.add(4);
        arr.add(33);
        arr.add(0);

        //new int[]{12,76,-1,4,33,0};
        //int[] arr = new int[]{12,11,10,9,8,7,6,5,4,3,2,1};
        //int[] arr = new int[]{12,11,10,8,8,8,6,8,4,8,2,1};

        List<Integer> sortedArr = quicksort(arr, 0, arr.size() - 1);
        for(int i : sortedArr){
            System.out.println(i);
        }
    }
    /*public static int[] quicksortWithTwoPivots(int[] arr, int start, int end){
        if((start == end) || start == end + 1){
            return arr;
        }
        int[] pivotIndexs = choose2Pivots(arr,start,end);
        int[] pivotIndexsAfterPartitioning = partitioningHoare2Pivots(arr, start, end,pivotIndexs);

        quicksort(arr, start, pivotIndexsAfterPartitioning[0] - 1);
        quicksort(arr, pivotIndexsAfterPartitioning[0] + 1, pivotIndexsAfterPartitioning[1] - 1);
        quicksort(arr, pivotIndexsAfterPartitioning[1] + 1, end);

        return arr;
    }*/
    private static int[] partitioningHoare2Pivots(int[] arr, int start, int end, int[] pivotIndexs){
        int i = start;
        int j = end;

        int pivot1 = arr[pivotIndexs[0]];
        int pivot2 = arr[pivotIndexs[1]];
        int[] p = new int[2];

        while(true){

            while(arr[i] < pivot1){
                i++;
            }
            while(arr[j] > pivot1){
                j--;
            }

            if(i < j){
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
            else{
                p[0] = j;
            }

            i = start;
            j = end;

            while(arr[i] < pivot2){
                i++;
            }
            while(arr[j] > pivot2){
                j--;
            }

            if(i < j){
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
            else{
                p[1] = j;
            }

            return p;
        }
    }

    public static List<Integer> quicksort(List<Integer> arr, int start, int end){
        if(start == end){
            return arr;
        }
        if(start >= end + 1){
            return arr;
        }
        int pivotIndex = choosePivot(arr);
        List<Integer> newArray = partitioningBruteForce(arr, start, end, pivotIndex);

        //0 to pivotIndex - 1 = smaller array // 0 to 2
        //pivotIndex // 3
        //pivotIndex + 1 to end = greater array // 4 to 5

        List<Integer> smaller = new ArrayList();
        List<Integer> bigger = new ArrayList();
        int pivotValue = newArray.get(pivotIndex);

        for(int i = 0; i < pivotIndex; i++){
            smaller.add(newArray.get(i));
        }
        for(int i = pivotIndex + 1; i <= end; i ++){
            bigger.add(newArray.get(i));
        }
        List<Integer> list1 = quicksort(smaller, start, smaller.size() - 1);
        list1.add(pivotValue);
        list1.addAll(quicksort(newArray, start, bigger.size() - 1));
        return list1;
    }

    private static int[] choose2Pivots(int[] arr, int start, int end){
        int[] arr2Pivots = new int[2];
        arr2Pivots[0] = start;
        arr2Pivots[1] = end;
        return arr2Pivots;
    }
    private static int choosePivot(List<Integer> arr){
       return arr.size() / 2;
    }
    private static List<Integer> partitioningBruteForce(List<Integer> arr, int start, int end, int pivotIndex){
        Map<String, Object> map = new HashMap<>();
        int pivotVal = arr.get(pivotIndex);

        //get how many elements are less than pivot
        int le_count = 0;
        for(int i = start; i < end; i++){
            if(arr.get(i) <= pivotVal){
                le_count++;
            }
        }

        //total no of elements less than pivot index is le_count

        //left of pivot will be 0 to le_count - 1
        //le_count  = pivot index
        //le_count + 1 to end = greater nos than pivot no.

        List<Integer> outArr = new ArrayList<>(Collections.nCopies(arr.size(), 0));
        outArr.set(le_count, pivotVal);

        int le = 0;
        int ge = le_count + 1;

        //put all less than pivot on the left side in new array
        for(int i = start; i < end; i++){
            //do it until pivotindex is found
            if(i == pivotIndex){
                continue;
            }
            //if element is smaller than pivot value then le_count increment
            if(arr.get(i) <= pivotVal){
                outArr.set(le, arr.get(i));
                le++;
            }else{
                outArr.set(ge, arr.get(i));
                ge++;
            }
        }
        map.put("outArr", outArr);
        map.put("newPivot", pivotIndex);
        return outArr;
    }
    private static int partitioningHoare(int[] arr, int start, int end, int pivotIndex){
        int i = start;
        int j = end;
        int pivot = arr[pivotIndex];

        while(true){
            while(arr[i] < pivot){
                i++;
            }
            while(arr[j] > pivot){
                j--;
            }
            if(i < j){
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
            else{
                return j;
            }
        }
    }
    private static int partitioningLomuto(int[] arr, int start, int end, int pivotIndex){

        //put pivot in the end of the array
        //and end value will go in partition which is less than pivot section

        int temp = arr[end];
        arr[end] = arr[pivotIndex];
        arr[pivotIndex] = temp;

        int pivot = arr[end];
        int i = start;

        //un organized or un sorted array section
        for(int curr = start; curr <= end - 1; curr++){
            if(arr[curr] <= pivot){
                temp = arr[curr];
                arr[curr] = arr[i];
                arr[i] = temp;

                i++;
            }
        }

        //push pivot into i area
        temp = arr[end];
        arr[end] = arr[i];
        arr[i] = temp;

        return i;
    }

}
