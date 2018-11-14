package cn.footman.heap;

import cn.footman.array.MyArray;

/**
 * @author footman77
 * @create 2018-11-07 21:12
 */
public class MaxHeap<E extends Comparable<E>> {

    private MyArray<E> data;

    public MaxHeap(int capacity){
        data = new MyArray<>(capacity);
    }

    public MaxHeap(){
        data = new MyArray<>();
    }

    public MaxHeap(E[] arr){
        data = new MyArray<>(arr);

        for(int i = parent(arr.length - 1); i >= 0; i--){
            siftDown(i);
        }

    }


    /**
     * 返回堆中的元素个数
     */
    public int size(){
        return data.getSize();
    }


    /**
     * 堆是否为空
     * @return
     */
    public boolean isEmpty(){
        return data.isEmpty();
    }


    /**
     * 返回完全二叉树的数组表示中，一个索引表示的元素的父亲节点的索引
     * @param index
     * @return
     */
    private int parent(int index){
        if(index == 0){
            throw  new IllegalArgumentException("index-0 doesn't have parent.");
        }
        return (index - 1) / 2;
    }


    /**
     * 返回完全二叉树的数组表示中，一个索引表示的元素的左孩子节点的索引
     * @param index
     * @return
     */
    private int leftChild(int index){
        return index * 2 + 1;
    }

    /**
     * 返回完全二叉树的数组表示中，一个索引表示的元素的有孩子节点的索引
     * @param index
     * @return
     */
    private int rightChild(int index){
        return index * 2 + 2;
    }


    /**
     * 向堆中添加元素e
     * @param e
     */
    public void add(E e){
        data.addLast(e);
        siftUp(data.getSize() - 1);
    }

    /**
     * 上浮
     * @param k
     */
    private void siftUp(int k){
        while (k > 0 && data.get(k).compareTo(data.get(parent(k))) > 0){
            data.swap(k,parent(k));
            k = parent(k);
        }
    }

    /**
     * 看堆中过的最大元素
     * @return
     */
    public E findMax(){
        if(data.getSize() == 0){
            throw new IllegalArgumentException("Can't findMax , the heap is empty");
        }
        return data.get(0);
    }


    /**
     * 取出堆中最大的元素
     * @return
     */
    public E extractMax(){
        E ret = findMax();

        data.swap(0,data.getSize() - 1);
        data.removeLast();

        siftDown(0);
        return ret;
    }

    /**
     * 下沉过程
     * @param k
     */
    private void siftDown(int k){

        while (leftChild(k) < data.getSize()){
            int j = leftChild(k);
            if((j + 1) < data.getSize() &&
                    data.get(j + 1).compareTo(data.get(j)) > 0){
                    j++;
//                    data.get(j)是leftChild和rightChild中的最大值
            }
            if(data.get(k).compareTo(data.get(j)) >= 0){
                break;
            }else {
                data.swap(k,j);
                k = j;
            }

        }

    }


    /**
     * 取出堆中的最大元素，并且替换成元素e
     * @param e
     * @return
     */
    public E replace(E e){
        E ret = findMax();


        data.set(0,e);
        siftDown(0);
        return ret;
    }

}
