package cn.footman.queue;

import java.util.Arrays;

/**
 * @author footman77
 * @create 2018-11-03 14:58
 */
public class MyLoopQueue<E> implements MyQueue<E> {


    private E[] data;
    private int front,tail;

    private int size;//元素个数


    public MyLoopQueue(int capacity){
        data = (E[])new Object[capacity + 1];
        this.front = 0;
        this.tail = 0;
        this.size = 0;
    }

    public MyLoopQueue(){
        this(10);
    }

    public int getCapacity(){
        return data.length - 1;
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return front == tail;
    }

    @Override
    public void enqueue(E e) {
        if((tail + 1) % data.length == front){
            resize(getCapacity() * 2);
        }
        data[tail] = e;
        tail = (tail + 1) % data.length;
        size++;
    }

    @Override
    public E dequeue() {
        if(isEmpty()){
            throw new IllegalArgumentException("Cannnot dequeue from an empty queue.");
        };

        E temp = data[front];
        data[front] = null;
        front = (front + 1) % data.length;
        size--;

        if(size == getCapacity() / 4 && getCapacity() / 2 != 0){
            resize(getCapacity() / 2);
        }


        return temp;

    }

    @Override
    public E getFront() {
        if(isEmpty()){
            throw new IllegalArgumentException("Queue is empty");
        }
        return data[front];
    }

    private void resize(int newCapacity){
        E[] newData = (E[])new Object[newCapacity + 1];
        for(int i = 0; i < size ; i++){
            newData[i] = data[(front + i) % data.length];
        }

        data = newData;
        front = 0;
        tail = size;
    }


    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        res.append(String.format("Queue: size = %d , capacity = %d\n", size , getCapacity()));
        res.append("front [");
        //一种方式
//        for(int i = 0; i < size; i++){
//            res.append(data[(i + front) % data.length]);
//            if(i != size - 1 ){
//                res.append(',');
//            }
//        }
        //另一个种方式
        for(int i = front; i != tail ; i = (i + 1) % data.length ){
            res.append(data[i]);
            if((i + 1) % data.length != tail){
                res.append(", ");
            }
        }
        res.append("] tail");
        return res.toString();
    }

    public static void main(String[] args) {
        MyLoopQueue<Integer> queue = new MyLoopQueue<>();
        for(int i = 0 ; i < 10 ; i++){
            queue.enqueue(i);
            System.out.println(queue);

            if(i % 3 == 2){
                queue.dequeue();
                System.out.println(queue);
            }
        }
    }
}
