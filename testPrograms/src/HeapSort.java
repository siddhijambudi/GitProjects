public class HeapSort {
    static public void main (String[] args)
    {
        int []arr = {10, 7, -2, 9, 1, 0, 8987};
        int n = arr.length;

        for (int i = 0; i < n; i++){
            swim(arr, i);
        }
        for (int i = n - 1; i >= 0; i--)
        {
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;

            sink(arr, i, 0);
        }
        System.out.println("Sorted array: ");
        printArray(arr, n);
    }

    static void printArray(int []arr, int n)
    {
        for (int i=0; i < n; i++)
            System.out.print(arr[i] + " ");
        System.out.println();
    }

    private static void swim(int[] arr, int index) {
        if (index == 0) {
            return;
        }
        int parent = (index - 1) / 2;
        if (arr[index] > arr[parent]) {
            swap(arr, index, parent);
            swim(arr, parent);
        }
    }

    private static void sink(int[] arr, int length, int index) {
        int left = index * 2 + 1;
        int right = index * 2 + 2;

        if (left >= length) {
            return;
        }

        int largestChild = left;
        if (right < length) {
            if (arr[left] < arr[right]) {
                largestChild = right;
            }
        }

        if (arr[index] < arr[largestChild]) {
            swap(arr, index, largestChild);
            sink(arr, length, largestChild);
        }
    }

    private static void swap(int[] arr, int index1, int index2) {
        int temp = arr[index1];
        arr[index1] = arr[index2];
        arr[index2] = temp;
    }
}
