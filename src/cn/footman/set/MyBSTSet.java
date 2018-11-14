package cn.footman.set;

import cn.footman.BST.BST;

/**
 * @author footman77
 * @create 2018-11-06 15:45
 */
public class MyBSTSet<E extends Comparable<E>> implements MySet<E> {

    private BST<E> bst;

    public MyBSTSet(){
        bst = new BST<>();
    }



    @Override
    public void add(E e) {

        bst.add(e);
    }

    @Override
    public void remove(E e) {
        bst.remove(e);
    }

    @Override
    public boolean contains(E e) {
        return bst.contains(e);
    }

    @Override
    public int getSize() {
        return bst.size();
    }

    @Override
    public boolean isEmpty() {
        return bst.isEmpty();
    }
}
