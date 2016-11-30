/*
Example
In n=2 arrays [[9,3,2,4,7],[1,2,3,4,8]], the 3rd largest element is 7.

In n=2 arrays [[9,3,2,4,8],[1,2,3,4,2]], the 1st largest element is 9, 2nd largest element is 8, 3rd largest element is 7 and etc.
*/

public class Solution {
    /**
     * @param arrays a list of array
     * @param k an integer
     * @return an integer, K-th largest element in N arrays
     */
    public int KthInArrays(int[][] arrays, int k) {
        // Write your code here By Tianyin
        //if (arrays == null || arrays.length == 0)   return 0;
        Queue<Integer> pq = new PriorityQueue<Integer>();
        for (int i = 0; i < arrays.length; i++) {
            for (int j = 0; j < arrays[i].length; j++) {
                pq.offer(arrays[i][j]);
                if (pq.size() > k)  pq.poll();
            }
        }
        return pq.peek();
    }
}
