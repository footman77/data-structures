package cn.footman.queue;


import cn.footman.linkedList.MyLinkedList;

/**
 * @author footman77
 * @create 2018-11-04 1:00
 */
public class MyLinkedListQueue<E> implements MyQueue<E> {



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


    private Node head, tail;
    private int size;

    public MyLinkedListQueue(){
        this.head = null;
        this.tail = null;
        this.size = 0;
    }



    @Override
    public int getSize() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public void enqueue(E e) {
        if(tail == null){
            tail = new Node(e);
            head = tail;
        }else {
            tail.next = new Node(e);
            tail = tail.next;
        }
        size++;
    }

    @Override
    public E dequeue() {
        if(isEmpty()){
            throw new IllegalArgumentException("Cannot dequeue from an empty queue");
        }
        Node retNode = head;
        head = head.next;
        retNode.next = null;
        //当只有一个元素时，还需要维护tail
        if(head == null){
            tail = null;
        }
        size--;
        return retNode.e;
    }

    @Override
    public E getFront() {
        if(isEmpty()){
            throw new IllegalArgumentException("Cannot dequeue from an empty queue");
        }
        return head.e;
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        res.append("Queue: front ");
        //第一种循环写法
        Node cur = head;

        while (cur != null){
            res.append(cur + "->");
            cur = cur.next;
        }



        res.append("NULL tail");

        return res.toString();
    }


    public static void main(String[] args) {
        MyLinkedListQueue<Integer> queue = new MyLinkedListQueue<>();
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
