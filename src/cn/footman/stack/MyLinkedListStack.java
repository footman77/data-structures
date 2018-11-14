package cn.footman.stack;

import cn.footman.linkedList.MyLinkedList;

/**
 * @author footman77
 * @create 2018-11-04 0:20
 */
public class MyLinkedListStack<E> implements MyStack<E> {

    private MyLinkedList<E> list;

    public MyLinkedListStack(){
        list = new MyLinkedList<>();
    }

    @Override
    public int getSize() {
        return list.getSize();
    }

    @Override
    public boolean isEmpty() {
        return list.isEmpty();
    }

    @Override
    public void push(E e) {
        list.addFirst(e);
    }

    @Override
    public E pop() {
        return list.removeFirst();
    }

    @Override
    public E peek() {
        return list.getFirst();
    }

    @Override
    public String toString(){
        StringBuilder res = new StringBuilder();
        res.append("Stack: top ");
        res.append(list);
        return res.toString();
    }
}
