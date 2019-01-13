package SegmentTree;

/**
 * @program: DataStructureAndAlgorithms
 * @description: 定义线段树的融合器接口
 * @author: mirrorming
 * @create: 2019-01-12 09:22
 **/

public interface Merger<E> {
    E merger(E a, E b);
}