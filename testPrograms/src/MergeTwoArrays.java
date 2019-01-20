public class MergeTwoArrays {
    public static void main(String args[]){
        int[] arr = new int[]{15,20,2,4,25,3,14,19};

        mergeSort(arr, 0, arr.length - 1);

        for(int i = 0; i < arr.length; i++){
            System.out.println(arr[i]);
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
}
