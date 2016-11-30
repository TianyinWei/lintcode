/*
Given two integer arrays sorted in ascending order and an integer k. Define sum = a + b, where a is an element from the first array and b is an element from the second one. Find the kth smallest sum out of all possible sums.

Have you met this question in a real interview? Yes
Example
Given [1, 7, 11] and [2, 4, 6].

For k = 3, return 7.

For k = 4, return 9.

For k = 8, return 15.
*/

class Pair {
    int a;
    int b;
    int sum;
    Pair(int a, int b, int[] A, int[] B) {
        this.a = a;
        this.b = b;
        this.sum = A[a] + B[b];
    }
}


public class Solution {
    /**
     * @param A an integer arrays sorted in ascending order
     * @param B an integer arrays sorted in ascending order
     * @param k an integer
     * @return an integer
     */
    public int kthSmallestSum(int[] A, int[] B, int k) {
        // Write your code here By Tianyin
        Queue<Pair> heap = new PriorityQueue<Pair>(k, new Comparator<Pair>(){
            public int compare(Pair x, Pair y) {
                return x.sum - y.sum;   //implement minheap
            }
            });
            
        int m = A.length;
        int n = B.length;
        boolean[][] visited = new boolean[m][n];
        heap.offer(new Pair(0, 0, A, B));
        for (int i = 0; i < k - 1; i++) {
            Pair cur = heap.poll();
            int idxA = cur.a;
            int idxB = cur.b;
            if (idxA < m-1 && idxB < n-1) {
                if (!visited[idxA+1][idxB]) {
                    visited[idxA+1][idxB] = true;
                    heap.offer(new Pair(idxA+1, idxB, A, B));
                }
                if (!visited[idxA][idxB+1]) {
                    visited[idxA][idxB+1] = true;
                    heap.offer(new Pair(idxA, idxB+1, A, B));
                }
            }   else if (idxA < m-1 && !visited[idxA+1][idxB]) {
                visited[idxA+1][idxB] = true;
                heap.offer(new Pair(idxA+1, idxB, A, B));
            }   else if (idxB < n-1 && !visited[idxA][idxB+1]) {
                visited[idxA][idxB+1] = true;
                heap.offer(new Pair(idxA, idxB+1, A, B));
            }
        }
        return heap.peek().sum;
    }
}
