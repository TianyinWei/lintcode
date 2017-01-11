/**
Given n nodes in a graph labeled from 1 to n. There is no edges in the graph at beginning.

You need to support the following method:
1. connect(a, b), an edge to connect node a and node b
2. query(a), Returns the number of connected component nodes which include node a.


5 // n = 5
query(1) return 1
connect(1, 2)
query(1) return 2
connect(2, 4)
query(1) return 3
connect(1, 4)
query(1) return 3
**/

public class ConnectingGraph2 {
    private int[] father;
    private int[] size;
    
    private int find(int x) {
        if (father[x] == 0) return x;
        return father[x] = find(father[x]);
    }
    
    public ConnectingGraph2(int n) {
        // initialize your data structure here.
        father = new int[n+1];
        size = new int[n+1];
        
        for (int i = 0; i < n; i++) {
            father[i+1] = 0;
            size[i+1] = 1;
        }
    }
    
    public void connect(int a, int b) {
        // Write your code here
        int rootA = find(a);
        int rootB = find(b);
        if (rootA != rootB) {
            father[rootA] = rootB;
            size[rootB] += size[rootA];
        }
    }
        
    public int query(int a) {
        // Write your code here
        int rootA = find(a);
        return size[rootA];
    }
}
