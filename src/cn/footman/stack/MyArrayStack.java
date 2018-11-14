package cn.footman.stack;

import cn.footman.array.MyArray;

/**
 * @author footman77
 * @create 2018-11-02 22:04
 */
public class MyArrayStack<E> implements MyStack<E> {


    MyArray<E> myArray;

    public MyArrayStack(int capacity) {
        myArray = new MyArray<>(capacity);
    }

    public MyArrayStack(){
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
    public void push(E e) {
        myArray.addLast(e);
    }

    @Override
    public E pop() {
        return myArray.removeLast();
    }

    @Override
    public E peek() {
        return myArray.getLast();
    }


    public int getCapacity(){
        return myArray.getCapacity();
    }


    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Stack:");
        stringBuilder.append('[');
        for( int i = 0; i < myArray.getSize(); i++){
            stringBuilder.append(myArray.get(i));
            if(i != myArray.getSize() - 1){
                stringBuilder.append(", ");
            }
        }
        stringBuilder.append("] top");
        return stringBuilder.toString();
    }
}
