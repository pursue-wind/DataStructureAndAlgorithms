package UnionFind;

/**
 * @program: DataStructureAndAlgorithms
 * @description: 并查集_基于size的优化
 * @author: mirrorming
 * @create: 2019-01-17 16:08
 **/

public class UnionFind3 implements UF {

    private int[] parent;
    private int[] sz;   //sz[i] 表示以 i 为根的集合中的元素个数

    public UnionFind3(int size) {
        parent = new int[size];
        sz = new int[size];
        for (int i = 0; i < size; i++) {
            parent[i] = i;
            sz[i] = 1;
        }
    }

    @Override
    public int getSize() {
        return parent.length;
    }

    /**
     * @Description: 查找元素p对应的集合编号, O(h)复杂度, h为树的高度
     * @Param: [p]
     * @return: int
     */
    private int find(int p) {
        if (p < 0 || p > parent.length)
            throw new IllegalArgumentException("index is out of bound~");
        while (p != parent[p])
            p = parent[p];
        return p;
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
        //查找到p,q对应的根节点
        int pRoot = find(p);
        int qRoot = find(q);
        //如果p,q的根节点相同
        if (pRoot == qRoot)
            return;
        //如果p,q的根节点不相同,比较,让元素个数较少的根节点指向节点数较多的根节点
        if (sz[pRoot] < sz[qRoot]) {//如果pRoot的元素个数更少
            parent[pRoot] = qRoot;//让pRoot的指向qRoot
            sz[qRoot] += sz[pRoot];
        }
        //如果qRoot的元素更少
        else {  //sz[pRoot] >= sz[qRoot]
            parent[qRoot] = pRoot;//让pRoot的指向qRoot
            sz[pRoot] += sz[qRoot];
        }
    }
}