/*
Given an array of integers, find how many pairs in the array such that their sum is bigger than a specific target number. Please return the number of pairs.

Have you met this question in a real interview? Yes
Example
Given numbers = [2, 7, 11, 15], target = 24. Return 1. (11 + 15 is the only pair)
*/

public class Solution {
    /**
     * @param nums: an array of integer
     * @param target: an integer
     * @return: an integer
     */
    public int twoSum2(int[] nums, int target) {
        // Write your code here By Tianyin
        if (nums == null || nums.length == 0)   return 0;
        Arrays.sort(nums);
        int i = 0, j = nums.length - 1;
        int res = 0;
        while(i < j) {
            int sum = nums[i] + nums[j];
            if (sum <= target) {
                i++;
            }   else {
                res += j - i;
                j--;
            }
        }
        
        return res;
    }
}
