package cn.footman.heap;

import cn.footman.queue.MyQueue;

/**
 * @author footman77
 * @create 2018-11-08 18:32
 */
public class MyPriorityQueue<E extends Comparable<E>> implements MyQueue<E> {

    private MaxHeap<E> maxHeap;

    public MyPriorityQueue(){
        maxHeap = new MaxHeap<>();
    }



    @Override
    public int getSize() {
        return maxHeap.size();
    }

    @Override
    public boolean isEmpty() {
        return maxHeap.isEmpty();
    }

    @Override
    public void enqueue(E e) {
        maxHeap.add(e);
    }

    @Override
    public E dequeue() {
        return maxHeap.extractMax();
    }

    @Override
    public E getFront() {
        return maxHeap.findMax();
    }
}
