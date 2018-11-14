package cn.footman.set;

import cn.footman.linkedList.MyLinkedList;

import java.util.ArrayList;

/**
 * @author footman77
 * @create 2018-11-06 17:06
 */
public class MyLinkedListSet<E> implements MySet<E> {

    private MyLinkedList<E> list;

    public MyLinkedListSet(){
        this.list = new MyLinkedList<>();
    }

    @Override
    public void add(E e) {
        if(!list.contains(e)){
            list.addFirst(e);
        }

    }

    @Override
    public void remove(E e) {
        list.removeElement(e);
    }

    @Override
    public boolean contains(E e) {
        return list.contains(e);
    }

    @Override
    public int getSize() {
        return list.getSize();
    }

    @Override
    public boolean isEmpty() {
        return list.isEmpty();
    }


    public static void main(String[] args) {
        System.out.println("Pride and Prejudice");

        ArrayList<String> words1 = new ArrayList<>();
        FileOperation.readFile("pride-and-prejudice.txt",words1);
        System.out.println(" Total words: " + words1.size());

        MyLinkedListSet<String> set2 = new MyLinkedListSet<>();
        for(String word : words1){
            set2.add(word);
        }
        System.out.println("Total different words : " + set2.getSize());




    }
}
