package UnionFind;

/**
 * @program: DataStructureAndAlgorithms
 * @description: 并查集接口
 * @author: mirrorming
 * @create: 2019-01-16 21:08
 **/

public interface UF {
    int getSize();

    boolean isConnected(int p, int q);

    void union(int p, int q);
}