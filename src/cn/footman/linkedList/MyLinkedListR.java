package cn.footman.linkedList;

import cn.footman.leetcode.ListNode;

/**
 * @author footman77
 * @create 2018-11-03 19:47
 */
public class MyLinkedListR<E> {


    private class Node{
        public E e;
        public Node next;

        public Node(E e, Node next) {
            this.e = e;
            this.next = next;
        }

        public Node(E e) {
            this(e,null);
        }

        public Node() {
            this(null,null);
        }


        @Override
        public String toString() {
            return e.toString();
        }
    }


    //虚拟头节点
    private Node dummyHead;

    private int size;

    public MyLinkedListR(){
        this.dummyHead = new Node(null,null);
        this.size = 0;
    }

    /**
     * 获取链表中的元素个数
     * @return
     */
    public int getSize(){
        return size;
    }

    /**
     * 链表是否为空
     * @return
     */
    public boolean isEmpty(){
        return size == 0;
    }





    /**
     * 在链表的index(0-based)位置添加新的元素e
     * 在链表中不是一个常用的操作
     * @param e
     */
    public void add(int index,E e){
        if(index < 0 || index > size){
            throw new IllegalArgumentException("Add failed , illegal index");
        }

        dummyHead.next = add(index,e,dummyHead.next);
        size++;

    }


    public Node add(int index, E e, Node head){
        if(index == 0){
            return new Node(e,head);
        }
        head.next = add(index - 1, e, head.next);

        return head;

    }


    /**
     * 在链表头添加新的元素e
     * @param e
     */
    public void addFirst(E e){
//        Node node = new Node(e);
//        node.next = head;
//        head = node;
        add(0,e);
    }

    /**
     * 向链表的末尾添加新的元素e
     * @param e
     */
    public void addLast(E e){
        add(size, e);
    }

    /**
     * 获得链表的第index（0-based）个位置元素
     * 在链表中不是一个常用的操作
     */
    public E get(int index){
        if(index < 0 || index >= size){
            throw new IllegalArgumentException("Get failed,Illegal index");
        }

        return get(index,dummyHead.next);
    }


    public E get(int index,Node head){
        if(index == 0){
            return head.e;
        }
        return get(index - 1,head.next);
    }


    /**
     * 获得链表的第一个元素
     * @return
     */
    public E getFirst(){
        return get(0);
    }


    /**
     * 获得链表的最后一个元素
     * @return
     */
    public E getLast(){
        return get(size - 1);
    }


    /**
     * 修改链表中的第index(0-based)个位置的元素e
     * 在链表中不是一个常用的操作
     */
    public void set(int index, E e){
         if(index < 0 || index >= size){
             throw new IllegalArgumentException("Get failed,Illegal index");
         }

        set(index,e,dummyHead.next);
    }

    public void set(int index, E e, Node head){
        if(index == 0){
            head.e = e;
            return;
        }
        set(index - 1, e, head.next);
    }


    /**
     * 查找元素中是否存在元素e
     */
    public boolean contains(E e){
        return contains(e,dummyHead.next);
    }

    public boolean contains(E e, Node head){
        if(head == null){
            return false;
        }
        if(head.e.equals(e)){
            return true;
        }
        return contains(e,head.next);
    }


    /**
     * 从链表中删除index位置的元素，返回删除元素
     * @return
     */
    public E remove(int index){

        if(index < 0 || index >= size ){
            throw new IllegalArgumentException("remove failed , index is illegal");
        }

        E e = remove(index, dummyHead);
        size--;
        return e;
    }

    public E remove(int index,Node prev){
       if(index == 0){
           Node delNode = prev.next;

           prev.next = delNode.next;
           delNode.next = null;
           return delNode.e;
       }
       return remove(index - 1, prev.next);
    }


    /**
     * 从链表删除第一个元素
     * @return
     */
    public E removeFirst(){
        return remove(0);
    }


    /**
     * 删除最后一个元素
     * @return
     */
    public E removeLast(){
        return remove(size - 1);
    }

    @Override
    public String toString() {

        StringBuilder res = new StringBuilder();

        //第一种循环写法
//        Node cur = dummyHead.next;
//
//        while (cur != null){
//            res.append(cur + "->");
//            cur = cur.next;
//        }

        //第二种循环写法
        for(Node cur = dummyHead.next; cur != null;cur = cur.next){
            res.append(cur + "->");
        }

        res.append("NULL");

        return res.toString();
    }
}
