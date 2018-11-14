package cn.footman.RedBlackTree;



import cn.footman.set.FileOperation;
import com.sun.org.apache.regexp.internal.RE;

import java.util.ArrayList;

/**
 * @author footman77
 * @create 2018-11-13 12:56
 */
public class MyRBTree<K extends Comparable<K>,V> {

    private static final boolean RED = true;
    private static final boolean BLACK = false;

    private class Node{
        public K key;
        public V value;
        public Node left,right;
        public boolean color;

        public Node(K key,V value){
            this.key = key;
            this.value = value;
            this.left = null;
            this.right = null;
            this.color = RED;
        }

    }


    private int size;
    private Node root;

    public MyRBTree(){
        this.size = 0;
        this.root = null;
    }


    private boolean isRed(Node node){
        if(node == null){
            return BLACK;
        }
        return node.color;
    }


    //   node                     x
    //  /   \     左旋转         /  \
    // T1   x   --------->   node   T3
    //     / \              /   \
    //    T2 T3            T1   T2
    private Node leftRotate(Node node){
        Node x = node.right;
        //左旋转
        node.right = x.left;
        x.left = node;

        x.color = node.color;
        node.color = RED;

        return x;
    }


    /**
     * 右旋转
     * @param node
     * @return
     */
    //     node                   x
    //    /   \     右旋转       /  \
    //   x    T2   ------->   y   node
    //  / \                       /  \
    // y  T1                     T1  T2
    private Node rightRotate(Node node){
        Node x = node.left;

        node.left = x.right;
        x.right = node;


        x.color = node.color;
        node.color = RED;


        return x;

    }

    //颜色反转
    private void flipColors(Node node){
        node.color = RED;
        node.left.color = BLACK;
        node.right.color = BLACK;
    }




    /**
     * 向红黑树添加新的元素(key,value)
     * @param key
     * @param value
     */
    public void add(K key, V value) {

        root = add(key,value,root);
        root.color = BLACK;//最终根节点为黑色节点
    }

    /**
     * 向以node为根的红黑树中插入元素（key,value),递归算法
     * 返回插入新节点后红黑树的根
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

        //左旋转
        if(isRed(root.right) && !isRed(root.left)){
            root = leftRotate(root);
        }
        //右旋转
        if(isRed(root.left) && isRed(root.left.left)){
            root = rightRotate(root);
        }
        //颜色反转
        if(isRed(root.left) && isRed(root.right)){
            flipColors(root);
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
    private Node remove(Node root, K key){
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




    public boolean contains(K key) {
        return getNode(root,key) != null;
    }


    public V get(K key) {
        Node node = getNode(root, key);

        return node != null ? node.value : null;
    }


    public void set(K key, V newValue) {
        Node node = getNode(root, key);
        if(node == null){
            throw new IllegalArgumentException("key isn't exist");
        }

        node.value = newValue;
    }


    public int getSize() {
        return size;
    }


    public boolean isEmpty() {
        return size == 0;
    }

    public static void main(String[] args) {
        System.out.println("Pride and Prejudice");

        ArrayList<String> words1 = new ArrayList<>();
        FileOperation.readFile("pride-and-prejudice.txt",words1);
        System.out.println(" Total words: " + words1.size());

//        MyLinkedListMap<String, Integer> map1 = new MyLinkedListMap<>();
        MyRBTree<String, Integer> map1 = new MyRBTree<>();
        for(String word : words1){
            if(map1.contains(word)){
                map1.set(word,map1.get(word) + 1);
            }else {
                map1.add(word,1);
            }

        }
        System.out.println("Total different words" + map1.getSize());
        System.out.println(map1.get("pride"));
//        System.out.println("is BST :" + map1.isBST());
//        System.out.println("is AVL :" + map1.isBalanced());


        System.out.println();
    }
}
