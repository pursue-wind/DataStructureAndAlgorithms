package UnionFind;

/**
 * @program: DataStructureAndAlgorithms
 * @description: 并查集
 * @author: mirrorming
 * @create: 2019-01-16 21:11
 **/

public class UnionFind1 implements UF {

    private int[] id;

    public UnionFind1(int size) {
        id = new int[size];
        for (int i = 0; i < id.length; i++)
            id[i] = i;
    }

    @Override
    public int getSize() {
        return id.length;
    }

    /**
     * @Description: 查找元素p对应的集合编号
     * @Param: [index]
     * @return: int
     */
    private int find(int p) {
        if (p < 0 || p > id.length)
            throw new IllegalArgumentException("index is out of bound~");
        return id[p];
    }

    /**
     * @Description: 查看元素p和元素q是否所属同一个集合
     * @Param: [p, q]
     * @return: boolean
     */
    @Override
    public boolean isConnected(int p, int q) {
        return find(p) == find(q);
    }

    /**
     * @Description: 合并元素p和元素q所属的集合
     * @Param: [p, q]
     */
    @Override
    public void union(int p, int q) {
        int pID = find(p);
        int qID = find(q);

        if (pID == qID)
            return;
        for (int i = 0; i < id.length; i++)
            if (id[i] == pID)
                id[i] = qID;
    }
}