/**
Given n nodes in a graph labeled from 1 to n. There is no edges in the graph at beginning.

You need to support the following method:
1. connect(a, b), add an edge to connect node a and node b. 2.query(a, b)`, check if two nodes are connected

5 // n = 5
query(1, 2) return false
connect(1, 2)
query(1, 3) return false
connect(2, 4)
query(1, 4) return true
**/

public class ConnectingGraph { 
    private int[] father;
    
    public ConnectingGraph(int n) {
        // initialize your data structure here.
        father = new int[n+1];
        for (int i = 0; i < n; i++) {
            father[i+1] = 0;
        }
    }

    public int find(int x) {
        
        if (father[x] == 0) return x;
        
        return father[x] = find(father[x]);
    }
    
    public void connect(int a, int b) {
        // Write your code here
        int rootA = find(a);
        int rootB = find(b);
        if (rootA != rootB) {
            father[rootA] = rootB;
        }
    }
        
    public boolean  query(int a, int b) {
        // Write your code here
        int rootA = find(a);
        int rootB = find(b);
        return rootA == rootB;
    }
}
