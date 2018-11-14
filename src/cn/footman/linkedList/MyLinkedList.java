package cn.footman.linkedList;

/**
 * @author footman77
 * @create 2018-11-03 19:47
 */
public class MyLinkedList<E> {


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

    public MyLinkedList(){
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


        Node prev = dummyHead;
        for(int i = 0 ; i < index ; i++){
            prev = prev.next;
        }
//            Node node = new Node(e);
//            node.next = prev.next;
//            prev.next = node;

        prev.next = new Node(e, prev.next);
        size++;



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

        Node cur = dummyHead.next;
        for(int i = 0; i < index; i++){
            cur = cur.next;
        }
        return cur.e;
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

         Node cur = dummyHead.next;
         for(int i = 0; i < index; i++){
             cur = cur.next;
         }
         cur.e = e;
    }

    /**
     * 查找元素中是否存在元素e
     */
    public boolean contains(E e){
        Node cur = dummyHead.next;

        while (cur != null){
            if(cur.e.equals(e)){
                return true;
            }
            cur = cur.next;
        }
        return false;
    }


    /**
     * 从链表中删除index位置的元素，返回删除元素
     * @return
     */
    public E remove(int index){

        if(index < 0 || index >= size ){
            throw new IllegalArgumentException("remove failed , index is illegal");
        }

        Node prev = dummyHead;
        for(int i = 0; i < index ; i++){
            prev = prev.next;
        }
        Node delNode = prev.next;
        prev.next = delNode.next;
        delNode.next = null;
        size--;

        return delNode.e;
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



    public void removeElement(E e){
        Node prev = dummyHead;

        while (prev.next != null){
            if(prev.next.e.equals(e)){
               break;
            }
            prev = prev.next;
        }

        if(prev.next != null){
            Node delNode = prev.next;
            prev.next = delNode.next;
            delNode.next = null;
            size--;

        }
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
