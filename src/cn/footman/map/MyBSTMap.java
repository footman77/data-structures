package cn.footman.map;




/**
 * @author footman77
 * @create 2018-11-07 1:29
 */
public class MyBSTMap<K extends Comparable<K>,V> implements MyMap<K,V> {

    private class Node{
        public K key;
        public V value;
        public Node left,right;

        public Node(K key,V value){
            this.key = key;
            this.value = value;
            this.left = null;
            this.right = null;
        }

    }


    private int size;
    private Node root;

    public MyBSTMap(){
        this.size = 0;
        this.root = null;
    }


    /**
     * 向二分搜索树添加新的元素(key,value)
     * @param key
     * @param value
     */
    @Override
    public void add(K key, V value) {

        root = add(key,value,root);
    }

    /**
     * 向以node为根的二分搜索树中插入元素（key,value),递归算法
     * 返回插入新节点后二分搜索树的根
     * @param key
     * @param value
     * @param root
     * @return
     */
    private Node add(K key, V value, Node root){

        if(root == null){
            size++;
            return new Node(key,value);
        }


        if(key.compareTo(root.key) > 0){
            root.right = add(key,value,root.right);
        }else if(key.compareTo(root.key) < 0){
            root.left = add(key,value,root.left);
        }else {//key.compartTo(root.key) == 0
            root.value = value;
        }
        return root;
    }


    //返回以node为根节点的二分搜索树中，以key所在的节点
    private Node getNode(Node root, K key){
        if(root == null){
            return null;
        }

        if(root.key.equals(key)){
            return root;
        }else if(key.compareTo(root.key) < 0){
            return getNode(root.left,key);
        }else {
            return getNode(root.right,key);
        }

//        Node cur = root;
//        while (cur != null){
//            if(key.compareTo(cur.key) > 0){
//                cur = cur.right;
//            }else if(key.compareTo(cur.key) < 0){
//                cur = cur.left;
//            }else {
//                break;
//            }
//        }
//        return cur;
    }

    /**
     * 删除掉以root为根的二分搜索树中K 为key的节点
     * @param key
     * @return
     */
    @Override
    public V remove(K key) {
        Node node = getNode(root,key);
        if(node != null){
            root = remove(root, key);
            return node.value;
        }
        return null;

    }

    /**
     * 删除掉以root为根的二分搜索树中K 为key的节点，递归算法
     * 返回删除节点后新的二分搜索树的根
     * @param root
     * @param key
     * @return
     */
    private Node remove(Node root,K key){
        if(root == null){
            return null;
        }

        if(key.compareTo(root.key) < 0){
            root.left = remove(root.left,key);
            return root;
        }else if(key.compareTo(root.key) > 0){
            root.right = remove(root.right, key);
            return root;
        }else {
            //带删除节点左子树为空
            if (root.left == null) {
                Node rootRight = root.right;
                root.right = null;
                size--;
                return rootRight;
            }
            //待删除节点右子树为空
            if (root.right == null) {
                Node rootLeft = root.left;
                root.left = null;
                size--;
                return rootLeft;
            }

            //带删除节点左右子树均不为空
            //找到比待删除节点大的最小节点，即待删除节点右子树的最小节点
            //用这个节点顶替待删除节点的位置
            Node successor = minimum(root.right);
            successor.right = removeMin(root.right);
            successor.left = root.left;

            root.left = root.right = null;

            return successor;
        }
    }


    /**
     * 返回以root为根的二分搜索树的最小值所在的节点
     * @param root
     * @return
     */
    private Node minimum(Node root){
        if(root.left == null){
            return root;
        }
        return minimum(root.left);

    }

    /**
     * 删除掉以root为根的二分搜索树中的最小节点
     * 返回删除节点后新的二分搜索树的根
     * @param root
     * @return
     */
    private Node removeMin(Node root){
        if(root.left == null){
            Node rightNode = root.right;
            root.right = null;
            size--;
            return rightNode;
        }

        root.left = removeMin(root.left);
        return root;
    }



    @Override
    public boolean contains(K key) {
        return getNode(root,key) != null;
    }

    @Override
    public V get(K key) {
        Node node = getNode(root, key);

        return node != null ? node.value : null;
    }

    @Override
    public void set(K key, V newValue) {
        Node node = getNode(root, key);
        if(node == null){
            throw new IllegalArgumentException("key isn't exist");
        }

        node.value = newValue;
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


