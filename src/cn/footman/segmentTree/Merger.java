package cn.footman.segmentTree;

/**
 * @author footman77
 * @create 2018-11-09 14:01
 */
public interface Merger<E> {
    E merge(E a,E b);
}
