package cn.footman.set;

import cn.footman.AVLTree.MyAVLTree;

/**
 * @author footman77
 * @create 2018-11-12 21:39
 */
public class MyAVLSet<E extends Comparable<E>> implements MySet<E> {

    private MyAVLTree<E, Object> avl;

    public MyAVLSet(){
        this.avl = new MyAVLTree<>();
    }

    @Override
    public void add(E e) {
        avl.add(e,null);
    }

    @Override
    public void remove(E e) {
        avl.remove(e);
    }

    @Override
    public boolean contains(E e) {
        return avl.contains(e);
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
