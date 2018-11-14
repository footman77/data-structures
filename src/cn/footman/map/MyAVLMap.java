package cn.footman.map;

import cn.footman.AVLTree.MyAVLTree;

/**
 * @author footman77
 * @create 2018-11-12 21:32
 */
public class MyAVLMap<K extends Comparable<K>,V> implements MyMap<K,V> {

    private MyAVLTree<K,V> avl;

    public MyAVLMap(){
        this.avl = new MyAVLTree<>();
    }

    @Override
    public void add(K key, V value) {
        avl.add(key,value);
    }

    @Override
    public V remove(K key) {
        return avl.remove(key);
    }

    @Override
    public boolean contains(K key) {
        return avl.contains(key);
    }

    @Override
    public V get(K key) {
        return avl.get(key);
    }

    @Override
    public void set(K key, V value) {
        avl.set(key,value);
    }

    @Override
    public int getSize() {
        return avl.getSize();
    }

    @Override
    public boolean isEmpty() {
        return avl.isEmpty();
    }
}
