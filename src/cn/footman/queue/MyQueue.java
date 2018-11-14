package cn.footman.queue;

/**
 * @author footman77
 * @create 2018-11-03 14:29
 */
public interface MyQueue<E> {

    int getSize();
    boolean isEmpty();
    void enqueue(E e);
    E dequeue();
    E getFront();
}
