package com.pranit.unionFind;

public class UnionFind {

    int[] data;
    int[] size;

    public static void main(String[] args) {
        UnionFind uf = new UnionFind(10);
        uf.displayArray();
        System.out.println("Test 4 and 3 Connection - "+ uf.isConnected(4, 3));
        System.out.println();

        uf.union(4, 3);
        uf.displayArray();
        System.out.println("Test 4 and 3 Connection - "+ uf.isConnected(4, 3));
        System.out.println();

        uf.union(3, 8);
        uf.displayArray();
        System.out.println();

        uf.union(6, 5);
        uf.union(9, 4);
        uf.displayArray();
        System.out.println();

        uf.union(2, 1);
        uf.union(5, 0);
        uf.displayArray();
        System.out.println();

        uf.union(2, 7);
        uf.union(6, 1);
        uf.displayArray();
        System.out.println();

        uf.union(7, 3);
        uf.displayArray();

        System.out.println("Test 1 and 2 Connection - "+ uf.isConnected(1, 2));
        System.out.println("Test 6 and 9 Connection - "+ uf.isConnected(6, 9));
        System.out.println("Test 8 and 7 Connection - "+ uf.isConnected(8, 7));
    }

    /**
     * Initialize data using length. Saves index as value.
     * Initialize size array. Save 1 as size of each tree.
     * @param length
     */
    public UnionFind(int length) {
        data = new int[length];
        size = new int[length];
        for (int i = 0; i < length ; i++) {
            data[i] = i;
            size[i] = 1;
        }
    }

    public boolean isConnected(int p, int q){
        return root(p) == root(q);
    }

    //TODO This can be improved with node compression
    // Make known node point directly to its root to flatten the tree
    private int root(int i){
        while(data[i] != i){
            i = data[i];
        }
        return i;
    }

    public void union(int p, int q){
        int rootP = root(p);
        int rootQ = root(q);
        if(rootP ==  rootQ) return;

        if(size[rootP] < size[rootQ]){
            data[rootP] = rootQ;
            size[rootQ] = size[rootQ] + 1;
        }
        else{
            data[rootQ] = rootP;
            size[rootP] = size[rootP] + 1;
        }
    }


    //Helper methods
    public void displayArray(){
        System.out.print("[");
        for (int i = 0; i < data.length; i++) {
            System.out.print(data[i]+ ", ");
        }
        System.out.println("]");

        System.out.print("[");
        for (int i = 0; i < size.length; i++) {
            System.out.print(size[i]+ ", ");
        }
        System.out.println("]");
    }
}
