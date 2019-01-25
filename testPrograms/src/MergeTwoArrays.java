public class MergeTwoArrays {
    public static void main(String args[]){

        int[] arr1 = new int[]{2,4,6,0,0,0};
        int[] arr2 = new int[]{1,3,5};

        //mergeSort(arr, 0, arr.length - 1);
        int[] merged = sortedMergeInPlace(arr1, arr2);

        for(int i : merged){
            System.out.println(i);
        }
    }
    static void mergeSort(int[] arr, int start, int end){
        if(start >= end){
            return;
        }
        int mid = (start + end) / 2;

        mergeSort(arr, start, mid);
        mergeSort(arr, mid + 1, end);

        merge(arr, start, mid, end);
    }
    static void merge(int[] arr, int start, int mid, int end){
        int sizeOfFirstArray = mid - start + 1;
        int sizeOfSecondArray = end - mid;

        int[] firstArray = new int[sizeOfFirstArray];
        int[] secondArray = new int[sizeOfSecondArray];

        for(int i = 0; i < sizeOfFirstArray; i++){
            firstArray[i] = arr[start + i];
        }
        for(int i = 0; i < sizeOfSecondArray; i++){
            secondArray[i] = arr[mid + 1 + i];
        }
        mergeTwoArrays(arr, start, sizeOfFirstArray, sizeOfSecondArray, firstArray, secondArray);
    }

    private static void mergeTwoArrays(int[] arr, int start, int sizeOfFirstArray, int sizeOfSecondArray,
            int[] firstArray, int[] secondArray) {
        int fp = 0;
        int sp = 0;
        int auxp = start;

        while(fp < sizeOfFirstArray && sp < sizeOfSecondArray){
            if(firstArray[fp] <= secondArray[sp]){
                arr[auxp] = firstArray[fp];
                fp++;
            }
            else{
                arr[auxp] = secondArray[sp];
                sp++;
            }
            auxp++;
        }
        while(fp < sizeOfFirstArray){
            arr[auxp] = firstArray[fp];

            auxp ++;
            fp++;
        }
        while(sp < sizeOfSecondArray){
            arr[auxp] = secondArray[sp];

            auxp ++;
            sp ++;
        }
    }

    static int[] sortedMergeInPlace(int a[], int b[])
    {
        int n = a.length / 2;
        int m = b.length;

        int i = n - 1;
        int j = m - 1;

        int lastIndex = n + m - 1;

        // Merge a and b, starting
        // from last element in each
        while (j >= 0)
        {
            /* End of a is greater than end of b */
            if (i >= 0 && a[i] > b[j])
            {
                // Copy Element
                a[lastIndex] = a[i];
                i--;
            } else
            {
                // Copy Element
                a[lastIndex] = b[j];
                j--;
            }
            // Move indices
            lastIndex--;
        }
        return a;
    }
}
