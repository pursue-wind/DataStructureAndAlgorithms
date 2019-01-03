package SetAndMap;

/**
 * @program: DataStructureAndAlgorithms
 * @description: 集合_接口
 * @author: mirrorming
 * @create: 2019-01-02 18:21
 **/

public interface Set<E> {
    void add(E e);

    void remove(E e);

    boolean isEmpty(E e);

    boolean contains();

    int getSize();
}