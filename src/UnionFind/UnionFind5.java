package UnionFind;

/**
 * @program: DataStructureAndAlgorithms
 * @description: 并查集_路径压缩
 * @author: mirrorming
 * @create: 2019-01-18 10:24
 **/

public class UnionFind5 implements UF {

    private int[] parent;
    private int[] rank;

    public UnionFind5(int size) {
        parent = new int[size];
        rank = new int[size];

        for (int i = 0; i < size; i++) {
            parent[i] = i;
            rank[i] = 1;
        }
    }

    /**
     * @Description: 查找元素p对应的集合编号, O(h)复杂度, h为树的高度
     * @Param: [p]
     * @return: int
     */
    private int find(int p) {
        if (p < 0 || p > parent.length)
            throw new IllegalArgumentException("index is illegal~");
        while (p != parent[p]) {
            parent[p] = parent[parent[p]];  //路径压缩主要逻辑
            p = parent[p];
        }
        return p;
    }

    @Override
    public int getSize() {
        return parent.length;
    }


    /**
     * @Description: 查看元素p和元素q是否所属同一个集合, O(h)复杂度, h为树的高度
     * @Param: [p, q]
     * @return: boolean
     */
    @Override
    public boolean isConnected(int p, int q) {
        return find(p) == find(q);
    }

    /**
     * @Description: 合并元素p和元素q所属的集合, O(h)复杂度, h为树的高度
     * @Param: [p, q]
     */
    @Override
    public void union(int p, int q) {
        //  查找到p,q对应的根节点
        int pRoot = find(p);
        int qRoot = find(q);

        //  如果p,q的根节点相同
        if (pRoot == qRoot)
            return;

        //  如果p,q的根节点不相同,比较,让层数低的指向层数高的

        if (rank[pRoot] < rank[qRoot])  //  如果qRoot的层数更高
            parent[pRoot] = qRoot;      //  让pRoot的指向qRoot

        else if (rank[qRoot] < rank[pRoot]) //  如果qRoot的层数更高
            parent[qRoot] = pRoot;          //  让qRoot的指向pRoot

        else {  //如果层数相等: rank[pRoot] = rank[qRoot]
            parent[qRoot] = pRoot;  //  让pRoot的指向qRoot
            rank[pRoot] += 1;       //  让qRoot的层数加1
        }
    }
}