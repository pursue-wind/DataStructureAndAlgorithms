package UnionFind;

/**
 * @program: DataStructureAndAlgorithms
 * @description: 并查集实现2
 * @author: mirrorming
 * @create: 2019-01-16 21:41
 **/

public class UnionFind2 implements UF {

    private int[] parent;

    public UnionFind2(int size) {
        parent = new int[size];
        for (int i = 0; i < size; i++)
            parent[i] = i;
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
            p = find(p);
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
        //如果p,q的根节点不相同,让p的根节点指向q的根节点
        parent[pRoot] = qRoot;
    }
}