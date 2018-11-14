package cn.footman.queue;

import cn.footman.array.MyArray;

/**
 * @author footman77
 * @create 2018-11-03 14:30
 */
public class MyArrayQueue<E> implements MyQueue<E> {

    private MyArray<E> myArray;


    public MyArrayQueue(int capacity){
        myArray = new MyArray<>(capacity);
    }

    public MyArrayQueue(){
        myArray = new MyArray<>();
    }

    @Override
    public int getSize() {
        return myArray.getSize();
    }

    @Override
    public boolean isEmpty() {
        return myArray.isEmpty();
    }

    @Override
    public void enqueue(E e) {
        myArray.addLast(e);
    }

    @Override
    public E dequeue() {
        return myArray.removeFirst();
    }

    @Override
    public E getFront() {
        return myArray.getFirst();
    }

    public int getCapacity(){
        return myArray.getCapacity();
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Queue:");
        stringBuilder.append("front [");
        for(int i = 0; i < myArray.getSize(); i++){
            stringBuilder.append(myArray.get(i));
            if(i != myArray.getSize() - 1){
                stringBuilder.append(", ");
            }
        }
        stringBuilder.append("] tail");
        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        MyArrayQueue<Integer> queue = new MyArrayQueue<>();
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
