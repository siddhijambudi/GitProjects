public class MergeWith2Indexes {
    public static void main(String args[]){
        int[] arr = new int[] {1,0,1,1,1,0,0,1,0};
        for(int i : mergeWithTwoIndexes(arr)){
            System.out.println(i);
        }
    }
    public static int[] mergeWithTwoIndexes(int[] arr){
        int n = arr.length;
        int start = 0;
        int end = n - 1;

        while(start < end){
            if(arr[start] == 0){
                start ++;
            }
            if(arr[end] == 1){
                end --;
            }
            if(arr[start] == 1 && arr[end] == 0){
                int temp = arr[start];
                arr[start] = arr[end];
                arr[end] = temp;

                start ++;
                end --;
            }
        }
        return arr;
    }
}
