package inputfiles;

public class MergeSortWithCeilMidValue {
    public static void main(String args[]){
        int[] arr = new int[]{2,5,10,8,7,78};
        mergeSort(arr, 0, arr.length - 1);
        for(int i : arr){
            System.out.println(i);
        }
    }
    public static void mergeSort(int[] arr, int start, int end){
        if(start >= end){
            return;
        }
        Double d = Math.ceil((end - start) / 2);
        int mid = start + d.intValue(); //(start + end) / 2; //start + (end - start) / 2; //Math.ceil((end - start) / 2);
        mergeSort(arr, start, mid - 1); //mid.intValue());
        mergeSort(arr, mid, end); //mid.intValue() + 1, end);

        merge(arr, start, mid - 1, end); //mid.intValue() - 1, end);
    }
    public static void merge(int[] arr, int l, int m, int r){
        // Find sizes of two subarrays to be merged
        int n1 = m - l + 1;
        int n2 = r - m;

        /* Create temp arrays */
        int L[] = new int [n1];
        int R[] = new int [n2];

        /*Copy data to temp arrays*/
        for (int i=0; i<n1; ++i)
            L[i] = arr[l + i];
        for (int j=0; j<n2; ++j)
            R[j] = arr[m + 1+ j];


        /* Merge the temp arrays */

        // Initial indexes of first and second subarrays
        int i = 0, j = 0;

        // Initial index of merged subarry array
        int k = l;
        while (i < n1 && j < n2)
        {
            if (L[i] <= R[j])
            {
                arr[k] = L[i];
                i++;
            }
            else
            {
                arr[k] = R[j];
                j++;
            }
            k++;
        }

        /* Copy remaining elements of L[] if any */
        while (i < n1)
        {
            arr[k] = L[i];
            i++;
            k++;
        }

        /* Copy remaining elements of R[] if any */
        while (j < n2)
        {
            arr[k] = R[j];
            j++;
            k++;
        }
    }
}
