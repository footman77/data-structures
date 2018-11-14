package cn.footman.map;

import cn.footman.linkedList.MyLinkedList;

/**
 * @author footman77
 * @create 2018-11-07 0:11
 */
public class MyLinkedListMap<K, V> implements MyMap<K, V> {



    private class Node{
        public K key;
        public V value;
        public Node next;

        public Node(K key, V value, Node next) {
            this.key = key;
            this.value = value;
            this.next = next;
        }

        public Node() {
        }

        public Node(K key){
            this(key,null,null);
        }

        public Node(K key,V value){
            this(key,value,null);
        }

        @Override
        public String toString() {
            return key.toString() + value.toString();
        }
    }


    private int size;
    private Node dummyHead;//虚拟头指针

    public MyLinkedListMap(){
        this.size = 0;
        dummyHead = new Node();
    }

    /**
     * 通过key来获得当前对应的Node
     * @param key
     * @return
     */
    private Node getNode(K key){
        Node cur = dummyHead.next;
        while (cur != null){
            if(cur.key.equals(key)){
                return cur;
            }
            cur = cur.next;
        }
        return null;
    }



    @Override
    public void add(K key, V value) {
        //判断是否已经有该数据
        Node node = getNode(key);
        if(node == null){
            dummyHead.next = new Node(key,value,dummyHead.next);
            size++;
        }else {
            node.value = value;
        }

    }



    @Override
    public V remove(K key) {


        Node prev = dummyHead;
        while (prev.next != null){
            if(prev.next.key.equals(key)){
                break;
            }
            prev = prev.next;
        }

        if(prev.next != null){
            Node delNode = prev.next;
            prev.next = delNode.next;
            delNode.next =null;
            size--;
            return delNode.value;
        }
        return null;
    }

    @Override
    public boolean contains(K key) {
        return getNode(key) != null;

    }

    @Override
    public V get(K key) {
        Node node = getNode(key);
        return node != null ? node.value : null;
    }

    @Override
    public void set(K key, V newValue) {
        Node node = getNode(key);
        if(node == null){
            throw new IllegalArgumentException("set failed,  no such key");
        }else {
            node.value = newValue;
        }

    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }
}
