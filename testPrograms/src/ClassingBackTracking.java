public class ClassingBackTracking {
    public static void main(String args[]){
        groupSum(0, new int[]{2,4,8}, 10);
    }
    public static boolean groupSum(int start, int[] nums, int target) {
        if (start >= nums.length) {
            return (target == 0);
        }
        if (groupSum(start + 1, nums, target - nums[start])){
            System.out.println("here..." + target + " start " + start + " nums[start] " + nums[start]);
            return true;
        }
        if (groupSum(start + 1, nums, target)) {
            System.out.println("there..." + target + " start " + start + " nums[start] " + nums[start]);
            return true;
        }
        return false;
    }
}
