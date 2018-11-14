package cn.footman.stack;

/**
 * @author footman77
 * @create 2018-11-02 22:03
 */
public interface MyStack<E> {

    int getSize();
    boolean isEmpty();
    void push(E e);
    E pop();
    E peek();
}
