import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class fourSum {
    public static List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);

        List<List<Integer>> list=new ArrayList<>();
        int len = nums.length;

        for (int k=0;k<len-3;k++){
            if (k>0 && nums[k]==nums[k-1]){
                continue;
            }

            for (int i=k+1;i<len-2;i++){
                if (i>k+1 && nums[i]==nums[i-1]){
                    continue;
                }

                int j=i+1;
                int h=len-1;
                while (j<h){
                    int currentValue = nums[k] + nums[i] + nums[j] + nums[h];
                    if (target== currentValue){
                        List<Integer> subList=new ArrayList<>();
                        subList.addAll(Arrays.asList(nums[k],nums[i],nums[j],nums[h]));
                        list.add(subList);
                        while (j<h && nums[j]==nums[j+1]){
                            j++;
                        }
                        while (j<h && nums[h]==nums[h-1]){
                            h--;
                        }
                        j++;h--;
                    }else if (currentValue>target){
                        h--;
                    }else {
                        j++;
                    }
                }
            }
        }
        return list;
    }

    public static void main(String[] args) {
        List<List<Integer>> list = fourSum(new int[]{0,0,0,0}, 0);
        System.out.println(list);
    }
}
