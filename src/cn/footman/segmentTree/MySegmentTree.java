package cn.footman.segmentTree;

/**
 * @author footman77
 * @create 2018-11-09 0:59
 */
public class MySegmentTree<E> {

    private E[] tree;

    private E[] data;

    private Merger<E> merger;

    public MySegmentTree(E[] arr, Merger<E> merger) {

        this.merger = merger;

        data = (E[])new Object[arr.length];
        for(int i = 0; i < arr.length; i++){
            data[i] = arr[i];
        }
        tree = (E[])new Object[4 * arr.length];
        buildSegmentTree(0,0,data.length - 1);

    }

    /**
     * 在treeIndex的位置创建表示去加[l-r]的线段树
     * @param treeIndex
     * @param l
     * @param r
     */
    private void buildSegmentTree(int treeIndex ,int l, int r){
        if(l == r){
            tree[treeIndex] = data[l];
            return;
        }

        int leftChild = leftChild(treeIndex);
        int rightChild = rightChild(treeIndex);

        int mid = l + (r - l) / 2;

        buildSegmentTree(leftChild, l , mid);
        buildSegmentTree(rightChild, mid + 1, r);

        tree[treeIndex] = merger.merge(tree[leftChild],tree[rightChild]);
    }

    public int getSize(){
        return data.length;
    }

    public E get(int index){
        if(index < 0 || index >= data.length){
            throw  new IllegalArgumentException("index is illegal");
        }
        return data[index];
    }


    /**
     * 返回完全二叉树的数组表示中，一个索引所表示的元素的左孩子节点的索引
     * @param index
     * @return
     */
    private int leftChild(int index){
        return index * 2 + 1;
    }

    /**
     * 返回完全二叉树的数组表示中，一个索引所表示的元素的右孩子节点的索引
     * @param index
     * @return
     */
    private int rightChild(int index){
        return index * 2 + 2;
    }

    /**
     * 返回区间[queryL, queryR]的值
     * @param queryL
     * @param queryR
     * @return
     */
    public E query(int queryL,int queryR){
        if(queryL < 0 || queryL > data.length ||
                queryR < 0 || queryR > data.length || queryL > queryR){
            throw new IllegalArgumentException("Index is illegal");
        }

        return query(0,0,data.length - 1,queryL,queryR);

    }

    /**
     * 在以treeID为根的线段树中[l...r]的范围内，搜索区间[queryL...queryR]的值
     * @param treeIndex
     * @param l
     * @param r
     * @param queryL
     * @param queryR
     * @return
     */
    private E query(int treeIndex, int l, int r,int queryL, int queryR){
        if(l == queryL && r == queryR){
            return tree[treeIndex];
        }

        int mid = l + (r - l) / 2;
        int leftChild = leftChild(treeIndex);
        int rightChild = rightChild(treeIndex);
        if(queryL >= mid + 1){
            return query(rightChild, mid + 1, r, queryL, queryR);
        }else if(queryR <= mid){
            return query(leftChild,l,mid,queryL,queryR);
        }else {
            E leftResult = query(leftChild,l, mid, queryL, mid);
            E rightResult = query(rightChild, mid + 1, r, mid + 1, queryR);
            return merger.merge(leftResult,rightResult);
        }

    }

    /**
     * 将index位置的值，更新为e
     * @param index
     * @param e
     */
    public void set(int index,E e){
        data[index] = e;
        set(0,0,data.length - 1,index,e);
    }


    /**
     * 在以treeIndex为根的线段树中更新index的值为e
     * @param treeIndex
     * @param l
     * @param r
     * @param index
     * @param e
     */
    private void set(int treeIndex, int l,int r, int index, E e){
        if(l == r){
            tree[treeIndex] = e;
            return;
        }

        int mid = l + (r - l) /2;
        int leftChildIndex = leftChild(treeIndex);
        int rightChildIndex = rightChild(treeIndex);

        if(index >= mid + 1){
            set(rightChildIndex,mid + 1, r, index, e);
        }else {
            set(leftChildIndex, l, mid, index, e);
        }

        tree[treeIndex]  = merger.merge(tree[leftChildIndex],tree[rightChildIndex]);
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        res.append('[');
        for(int i = 0 ; i < tree.length; i++){
            if(tree[i] != null){
                res.append(tree[i]);
            }else {
                res.append("null");
            }
            if(i != tree.length - 1){
                res.append(",");
            }

        }

        res.append(']');
        return res.toString();
    }
}
