public class QuickSortPartitionWithDiffPartitionWays {
    public static void main(String args[]){
        //int[] arr = new int[]{12,76,-1,4,33,0};
        int[] arr = new int[]{12,11,10,9,8,7,6,5,4,3,2,1};

        int[] sortedArr = quicksortWithTwoPivots(arr, 0, arr.length - 1);
        for(int i : sortedArr){
            System.out.println(i);
        }
    }
    public static int[] quicksortWithTwoPivots(int[] arr, int start, int end){
        if((start == end) || start == end + 1){
            return arr;
        }
        int[] pivotIndexs = choose2Pivots(arr,start,end);
        int[] pivotIndexsAfterPartitioning = partitioningHoare2Pivots(arr, start, end,pivotIndexs);

        quicksort(arr, start, pivotIndexsAfterPartitioning[0] - 1);
        quicksort(arr, pivotIndexsAfterPartitioning[0] + 1, pivotIndexsAfterPartitioning[1] - 1);
        quicksort(arr, pivotIndexsAfterPartitioning[1] + 1, end);

        return arr;
    }
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
    public static int[] quicksort(int[] arr, int start, int end){
        if(start == end){
            return arr;
        }
        if(start >= end){
            return arr;
        }
        int pivotIndex = choosePivot(arr,start,end);
        int pivotIndexAfterPartitioning = partitioningHoare(arr, start, end, pivotIndex);

        quicksort(arr, start, pivotIndexAfterPartitioning - 1);
        quicksort(arr, pivotIndexAfterPartitioning + 1, end);

        return arr;
    }

    private static int[] choose2Pivots(int[] arr, int start, int end){
        int[] arr2Pivots = new int[2];
        arr2Pivots[0] = start;
        arr2Pivots[1] = end;
        return arr2Pivots;
    }
    private static int choosePivot(int[] arr, int start, int end){
       return (start + end) / 2;
    }
    private static int partitioningBruteForce(int[] arr, int start, int end, int pivotIndex){
        //get how many elements are less than pivot
        int le_count = 0;
        for(int i : arr){
            if(i < arr[pivotIndex]){
                le_count++;
            }
        }
        //put all less than pivot on the left side in new array
        int[] outArr = new int[arr.length];
        int ge_count = le_count;
        for(int i : arr){
            if(i < arr[pivotIndex]){
                outArr[le_count ++] = i;
            }
            else{
                outArr[ge_count ++] = i;
            }
        }
        return le_count - 1;
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
