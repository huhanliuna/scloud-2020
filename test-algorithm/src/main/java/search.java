import java.util.Arrays;

public class search {


    public int search(int[] nums, int target) {
        int n=nums.length-1;
        int left=0;int right=nums.length-1;
        boolean flag=false;
    //    Arrays.sort(nums);
        while (left <= right) {
            int mid = (left + right) / 2;
            if (nums[mid] == target) return mid;
            if (nums[0] <= nums[mid]) {

                if (nums[0] <= target && target < nums[mid]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            } else {
                //存在反转的情况
                if (nums[mid] < target && target <= nums[n - 1]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        //[4,5,6,7,0,1,2]
        //0
        search search=new search();
        search.search(new int[]{4,5,6,7,0,1,2},0);
    }
}
