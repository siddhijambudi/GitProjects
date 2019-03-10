import java.util.*;

public class SubarraysEqualToSum {

    public static void subArraySum(int[] arr, int target) {

        int n = arr.length;
        int sum_so_far = 0;

        List<ArrayList> result = new ArrayList<>();
        Map<Integer, Map<Integer, Integer> > eachSumStartingIndexList = new HashMap<>();

        for (int i = 0; i < n; i++) {
            sum_so_far = sum_so_far + arr[i];

            if(sum_so_far - target == 0){

                Map<Integer, Integer> startEnd = new HashMap<>();
                startEnd.put(0, i);

                ArrayList listOfValues = new ArrayList<>(Arrays.asList(0, i));
                result.add(listOfValues);

                eachSumStartingIndexList.put(0, startEnd);
            }
            else if (eachSumStartingIndexList.containsKey(sum_so_far - target)) {

                Map<Integer, Integer> map = eachSumStartingIndexList.get(sum_so_far - target);
                Map<Integer, Integer> map1 = new HashMap<>();

                for(Map.Entry<Integer,Integer> entry : map.entrySet()){

                    int startIndex = entry.getKey();
                    ArrayList listOfValues = new ArrayList<>(Arrays.asList(startIndex + 1, i));
                    result.add(listOfValues);

                    map1.put(startIndex + 1, i);
                }
                eachSumStartingIndexList.put(sum_so_far - target, map1);
            }
            if(eachSumStartingIndexList.containsKey(sum_so_far)){
                eachSumStartingIndexList.get(sum_so_far).put(i, i);
            }
            else {
                Map<Integer, Integer> map2 = new HashMap<>();
                map2.put(i, i);

                eachSumStartingIndexList.put(sum_so_far, map2);
            }
        }
        if (result.isEmpty()) {
            System.out.println("No subarray with given sum exists");
        }
        else {
            for(List<Integer> l : result) {
                int startIndex = l.get(0);
                int endIndex = l.get(1);

                for(int i = startIndex; i <= endIndex; i++){
                    System.out.print(arr[i] +  " ");
                }
                System.out.println();
            }
        }
    }
    static int findSubarraySum(int arr[], int n, int sum)
    {
        // HashMap to store number of subarrays
        // starting from index zero having
        // particular value of sum.
        HashMap <Integer, Integer> prevSum = new HashMap<>();

        int res = 0;

        // Sum of elements so far.
        int currsum = 0;

        for (int i = 0; i < n; i++) {

            // Add current element to sum so far.
            currsum += arr[i];

            // If currsum is equal to desired sum,
            // then a new subarray is found. So
            // increase count of subarrays.
            if (currsum == sum)
                res++;

            // currsum exceeds given sum by currsum
            //  - sum. Find number of subarrays having
            // this sum and exclude those subarrays
            // from currsum by increasing count by
            // same amount.
            if (prevSum.containsKey(currsum - sum))
                res += prevSum.get(currsum - sum);


            // Add currsum value to count of
            // different values of sum.
            Integer count = prevSum.get(currsum);
            if (count == null)
                prevSum.put(currsum, 1);
            else
                prevSum.put(currsum, count+1);
        }

        return res;
    }
    // Driver code
    public static void main(String[] args) {
        int[] arr =
        //{9, 4, 20, 3, 10, 5};
        //{10, 2, -2, -20, 10, -10, -10}
                {-20, 10};
        int n = arr.length;
        int sum =
        //33;
        -10;
        subArraySum(arr, sum);
        //findSubarraySum(arr,n,sum);
    }
}
