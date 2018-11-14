package cn.footman.AVLTree;


import cn.footman.map.MyBSTMap;
import cn.footman.set.FileOperation;

import java.util.ArrayList;

/**
 * @author footman77
 * @create 2018-11-12 14:38
 */
public class MyAVLTree<K extends Comparable<K>,V> {


    private class Node{
        public K key;
        public V value;
        public Node left,right;
        public int height;

        public Node(K key,V value){
            this.key = key;
            this.value = value;
            this.left = null;
            this.right = null;
            this.height = 1;
        }

    }


    private int size;
    private Node root;

    public MyAVLTree(){
        this.size = 0;
        this.root = null;
    }


    /**
     * 获得节点的高度值
     * @param node
     * @return
     */
    private int getHeight(Node node){
        if(node == null){
            return 0;
        }
        return node.height;
    }

    /**
     * 获得节点node的平衡因子
     * @param node
     * @return
     */
    private int getBalanceFactor(Node node){
        if(node == null){
            return 0;
        }
        return getHeight(node.left) - getHeight(node.right);
    }


    /**
     * 判断该二叉树是否是一个二分搜索树
     * @return
     */
    public boolean isBST(){
        ArrayList<K> keys = new ArrayList<>();
        inOrder(root,keys);
        for(int i = 1; i < keys.size(); i++){
            if(keys.get(i - 1).compareTo(keys.get(i)) > 0){
                return false;
            }
        }
        return true;
    }


    /**
     * 判断该二叉树是否是一颗平衡二叉树
     * @return
     */
    public boolean isBalanced(){
        return isBalanced(root);
    }

    private boolean isBalanced(Node node){
        if(node == null){
            return true;
        }
        int balanceFactor = getBalanceFactor(node);
        if(Math.abs(balanceFactor) > 1){
            return false;
        }
        return isBalanced(node.left) && isBalanced(node.right);
    }

    private void inOrder(Node node,ArrayList<K> keys){
        if(node == null){
            return;
        }

        inOrder(node.left,keys);
        keys.add(node.key);
        inOrder(node.right,keys);
    }


    /**
     // 对节点y进行向右旋转操作，返回旋转后新的根节点x
     //        y                              x
     //       / \                           /   \
     //      x   T4     向右旋转 (y)        z     y
     //     / \       - - - - - - - ->    / \   / \
     //    z   T3                       T1  T2 T3 T4
     //   / \
     // T1   T2
     * @param y
     * @return
     */
    private Node rightRotate(Node y){

        Node x = y.left;
        Node T3 = x.right;
        x.right = y;
        y.left = T3;
        //更新height
        y.height = Math.max(getHeight(y.left),getHeight(y.right)) + 1;
        x.height = Math.max(getHeight(x.left),getHeight(x.right)) + 1;
        return x;
    }

    // 对节点y进行向左旋转操作，返回旋转后新的根节点x
    //    y                             x
    //  /  \                          /   \
    // T1   x      向左旋转 (y)       y     z
    //     / \   - - - - - - - ->   / \   / \
    //   T2  z                     T1 T2 T3 T4
    //      / \
    //     T3 T4
    private Node leftRotate(Node y){
        Node x = y.right;
        Node T2 = x.left;

        x.left = y;
        y.right = T2;
        //更新height
        y.height = Math.max(getHeight(y.left),getHeight(y.right)) + 1;
        x.height = Math.max(getHeight(x.left),getHeight(x.right)) + 1;

        return x;

    }


    /**
     * 向二分搜索树添加新的元素(key,value)
     * @param key
     * @param value
     */
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

        //更新height
        root.height = 1 + Math.max(getHeight(root.left),getHeight(root.right));

        int balanceFactor = getBalanceFactor(root);
//        if(Math.abs(balanceFactor) > 1) {
//            System.out.println("unbalanced:" + balanceFactor);
//        }
        //左边高于右边,平衡维护
        //LL
        if(balanceFactor > 1 && getBalanceFactor(root.left) >= 0 ){
            return rightRotate(root);
        }
        //右边高于左边
        //RR
        if(balanceFactor < -1 && getBalanceFactor(root.right) <= 0){
            return leftRotate(root);
        }
        //LR
        if(balanceFactor > 1 && getBalanceFactor(root.left) < 0){
            root.left = leftRotate(root.left);
            return rightRotate(root);
        }
        //RL
        if(balanceFactor < -1 && getBalanceFactor(root.right) > 0){
            root.right = rightRotate(root.right);
            return leftRotate(root);
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

        Node retNode;
        if(key.compareTo(root.key) < 0){
            root.left = remove(root.left,key);
            retNode = root;
        }else if(key.compareTo(root.key) > 0){
            root.right = remove(root.right, key);
            retNode = root;
        }else {
            //带删除节点左子树为空
            if (root.left == null) {
                Node rootRight = root.right;
                root.right = null;
                size--;
                retNode =  rootRight;
            }
            //待删除节点右子树为空
            else if (root.right == null) {
                Node rootLeft = root.left;
                root.left = null;
                size--;
                retNode = rootLeft;
            }
            else {
                //带删除节点左右子树均不为空
                //找到比待删除节点大的最小节点，即待删除节点右子树的最小节点
                //用这个节点顶替待删除节点的位置
                Node successor = minimum(root.right);
                successor.right = remove(root.right,successor.key);
                successor.left = root.left;

                root.left = root.right = null;

                retNode = successor;
            }

        }
        if(retNode == null){
            return null;
        }

        //更新height
        retNode.height = 1 + Math.max(getHeight(retNode.left),getHeight(retNode.right));

        int balanceFactor = getBalanceFactor(retNode);
//        if(Math.abs(balanceFactor) > 1) {
//            System.out.println("unbalanced:" + balanceFactor);
//        }
        //左边高于右边,平衡维护
        //LL
        if(balanceFactor > 1 && getBalanceFactor(retNode.left) >= 0 ){
            return rightRotate(retNode);
        }
        //右边高于左边
        //RR
        if(balanceFactor < -1 && getBalanceFactor(retNode.right) <= 0){
            return leftRotate(retNode);
        }
        //LR
        if(balanceFactor > 1 && getBalanceFactor(retNode.left) < 0){
            retNode.left = leftRotate(retNode.left);
            return rightRotate(retNode);
        }
        //RL
        if(balanceFactor < -1 && getBalanceFactor(retNode.right) > 0){
            retNode.right = rightRotate(retNode.right);
            return leftRotate(retNode);
        }

        return retNode;
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
        MyAVLTree<String, Integer> map1 = new MyAVLTree<>();
        for(String word : words1){
            if(map1.contains(word)){
                map1.set(word,map1.get(word) + 1);
            }else {
                map1.add(word,1);
            }

        }
        System.out.println("Total different words" + map1.getSize());
        System.out.println(map1.get("pride"));
        System.out.println("is BST :" + map1.isBST());
        System.out.println("is AVL :" + map1.isBalanced());

        for(String word : words1){
            map1.remove(word);
            if(!map1.isBalanced() || !map1.isBST()){
                throw new RuntimeException("error");
            }
        }
        System.out.println();
    }
}
