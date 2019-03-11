public class SubsetSumBackTracking {
    public static void main(String args[]){
        int[] arr = new int[] {15, 22, 14, 26, 32, 9, 16, 8};
        int target = 53;
        int size = arr.length;
        int count = 0;

        generateSubstes(arr, size, target, count);
    }
    static void generateSubstes(int[] arr, int size, int target, int count){
        int[] subsetArrays = new int[2*2*2*2*2*2*2*2];

        int max = 0;
        sort(arr);

        for(int i = 0; i < size; i++){
            max = max + arr[i];
        }
        int min = arr[0];

        if(min <= target && max >= target){
            subset_sum(arr, subsetArrays, size, 0, 0, 0, target, count);
        }
    }
    static void sort(int[] arr){
        for(int i = 1; i < arr.length; i++){
            int key = arr[i];
            int j = i - 1;
            while (j >= 0 && arr[j] > key){
                arr[j+1] = arr[j];
                j--;
            }
            arr[j+1] = key;
        }
    }
    static void subset_sum(int[] arr, int[] subset_arr, int arr_size, int subset_size, int sum_so_far, int index, int target, int count){
        count ++;

        if(target == sum_so_far){
            //we found sum
            print(subset_arr, subset_size);

            // constraint check
            if(index + 1 < arr_size && sum_so_far - arr[index] + subset_arr[index+1] <= target)
            {
                // Exclude previous added item and consider next candidate
                subset_sum(arr, subset_arr, arr_size, subset_size - 1, sum_so_far - arr[index],
                        index + 1, target, count);
            }
            return;

        }
        else{
            if(index < arr_size && sum_so_far + arr[index] <= target){

                for(int i = index; i < arr_size; i++){

                    subset_arr[subset_size] = arr[i];

                    if(sum_so_far + arr[i] <= target){

                        subset_sum(arr, subset_arr, arr_size, subset_size + 1, sum_so_far + arr[i],
                                i + 1, target, count);
                    }
                }
            }
        }
    }
    static void print(int[] subset_arr, int subset_size){
        for(int i = 0; i < subset_size; i++){
            System.out.print(subset_arr[i] + " ");
        }
        System.out.println();
    }
}
