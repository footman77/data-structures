package cn.footman.set;

/**
 * @author footman77
 * @create 2018-11-06 15:45
 */
public interface MySet<E> {

    void add(E e);
    void remove(E e);
    boolean contains(E e);
    int getSize();
    boolean isEmpty();
}
