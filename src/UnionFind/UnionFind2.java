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
        return 0;
    }

    @Override
    public boolean isConnected(int p, int q) {
        return false;
    }

    @Override
    public void union(int p, int q) {

    }
}