class Solution {
    /*
     * @param k an integer
     * @param nums an integer array
     * @return kth smallest element
     */
    public int kthSmallest(int k, int[] nums) {
        // write your code here By Tianyin
        //quickSort
        quickSort(0, nums.length - 1, nums);
        return nums[k-1];
    }
    
    private void quickSort(int lowerIndex, int higherIndex, int[] nums) {
        int pivot = nums[lowerIndex+(higherIndex-lowerIndex)/2];
        int i = lowerIndex, j = higherIndex;
        while(i <= j) {
            while (nums[i] < pivot) {
                i++;
            }
            while (nums[j] > pivot) {
                j--;
            }
            if (i <= j) {
                swap(i, j, nums);
                i++;
                j--;
            }
        }
        
        if (lowerIndex < j) {
            quickSort(lowerIndex, j, nums);
        }
        if (higherIndex > i) {
            quickSort(i, higherIndex, nums);
        }
    }
    
    private void swap(int a, int b, int[] nums) {
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
        
    }
}
