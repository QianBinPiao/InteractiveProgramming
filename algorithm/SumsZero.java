package algorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SumsZero {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();

        for (int i = 0 ; i< nums.length; i++) {
            int temp = 0;
            for (int j = i + 1; j < nums.length; j++) {
                temp = 0;
                for (int k = j + 1; k < nums.length; k++ ) {
                    temp = nums[i] + nums[j] + nums[k];
                    if (temp == 0) {
                        List<Integer> item = new ArrayList<>();
                        item.add(nums[i]);
                        item.add(nums[j]);
                        item.add(nums[k]);
                        result.add(item);

                    }

                }
            }
        }

        return result;
    }

    public static void main(String[] args) {
        SumsZero s = new SumsZero();

        int[] nums = {-1, 0, 1, 2, -1, -4};
        List<List<Integer>> result = s.threeSum(nums);
        for (List<Integer> eachrow : result) {
            for (Integer eachItem : eachrow) {
                System.out.print(eachItem + " ");
            }
            System.out.println();
        }
    }

}
