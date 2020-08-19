package algorithm;

import java.util.Arrays;
import java.util.LinkedList;

public class FirstLastPositionProblem {
    public int[] searchRange(int[] nums, int target) {
        int[] result = {-1, -1};
        LinkedList<Integer> resultList = new LinkedList<>();
        int count = 0;
        int i = nums.length / 2;


        while(true) {

            if (nums[i] == target) {
                result[count] = i;
                count++;
                i = nums.length - 1;
            }

            if (i/2 == 0) {
                break;
            }

            if (count == 2) {
                break;
            }

            if (nums[i] > target) {

                i = i -  i / 2;
            }

            if (nums[i] < target) {
                i = i +  i / 2;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        FirstLastPositionProblem f = new FirstLastPositionProblem();
        int[] nums = {5,7,7,8,8,10};
        int target = 8;

        System.out.println(Arrays.toString(f.searchRange(nums, target)));

        int[] nums2 = {5,7,7,8,8,10};
        int target2 = 6;
        System.out.println(Arrays.toString(f.searchRange(nums2, target2)));
    }
}
