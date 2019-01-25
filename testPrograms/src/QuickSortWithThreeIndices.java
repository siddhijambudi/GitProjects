public class QuickSortWithThreeIndices {
    public static void main(String args[]){
        int[] arr = new int[]{1,0,1,1,2,0};
        for(int i : sortWithThreeIndices(arr)){
            System.out.println(i);
        }
    }
    public static int[] sortWithThreeIndices(int arr[]){
        int n = arr.length;
        int start = 0;
        int end = n - 1;
        int mid = 0;

        /*while(arr[start] == 0 && start < end){
            start ++;
        }
        if(start == end){
            return arr;
        }
        while(arr[end] == 2 && end < start){
            end --;
        }
        if(end == start){
            return arr;
        }*/

        while (mid <= end){
            if(arr[mid] == 0){

                int temp = arr[start];
                arr[start] = arr[mid];
                arr[mid] = temp;

                start ++;
                mid ++;
            }
            else if(arr[mid] == 1){
                mid ++;
            }
            else if(arr[mid] == 2){

                int temp = arr[mid];
                arr[mid] = arr[end];
                arr[end] = temp;

                end --;
            }
        }
        return arr;
    }
}
