package SetAndMap;

/**
 * @program: DataStructureAndAlgorithms
 * @description: Map接口
 * @author: mirrorming
 * @create: 2019-01-03 17:04
 **/

public interface Map<K, V> {
    void add(K key, V value);

    V remove(K key);

    V get(K key);

    void set(K key, V newValue);

    boolean contains(K key);

    int getSize();

    boolean isEmpty();
}