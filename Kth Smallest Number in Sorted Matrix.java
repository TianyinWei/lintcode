class matrixPoint {
    int row;
    int col;
    // int[][] matrix;
    int val;
    matrixPoint(int row, int col, int[][] matrix) {
        this.row = row;
        this.col = col;
        // int m = matrix.length;
        // int n = matrix[0].length;
        // this.matrix = new int[m][n];
        // for (int i = 0; i < m; i++) {
        //     for (int j = 0; j < n; j++) {
        //         this.matrix[i][j] = matrix[i][j];
        //     }
        // }
        this.val = matrix[row][col];
    }
}
public class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        Queue<matrixPoint> heap = new PriorityQueue<matrixPoint>(new Comparator<matrixPoint>() {
            public int compare(matrixPoint a, matrixPoint b) {
                return a.val - b.val;
            }
        });
        heap.offer(new matrixPoint(0, 0, matrix));
        int cnt = 1;
        boolean[][] visited = new boolean[matrix.length][matrix[0].length];
        while(cnt < k) {
            matrixPoint cur = heap.poll();
            int row = cur.row;
            int col = cur.col;
            int min = 0;
            int minRow = 0, minCol = 0;
            if (row < matrix.length - 1 && col < matrix[0].length - 1) {
                if (!visited[row][col+1]){
                    heap.offer(new matrixPoint(row, col+1, matrix));
                    visited[row][col+1] = true;
                }
                if (!visited[row+1][col]) {
                    heap.offer(new matrixPoint(row+1, col, matrix));
                    visited[row+1][col] = true;
                }
                
            }   else if (row < matrix.length - 1 && !visited[row+1][col]) {
                min = matrix[row+1][col];
                minRow = row + 1;
                minCol = col;
                heap.offer(new matrixPoint(row+1, col, matrix));
                visited[row+1][col] = true;
            }   else if (col < matrix[0].length - 1 && !visited[row][col+1]){
                min = matrix[row][col+1];
                minRow = row;
                minCol = col + 1;
                heap.offer(new matrixPoint(row, col+1, matrix));
                visited[row][col+1] = true;
            }
            cnt++;
        }
        
        return heap.peek().val;
    }
}
