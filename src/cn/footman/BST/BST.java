package cn.footman.BST;

import javax.swing.text.html.HTMLWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * @author footman77
 * @create 2018-11-05 12:06
 */
public class BST<E extends Comparable<E>> {

    /**
     * 节点类
     */
    private class Node{
        public E e;
        public Node left,right;

        public Node(E e){
            this.e = e;
            this.left = null;
            this.right = null;
        }
    }


    private Node root;
    private int size;

    public BST(){
        this.root = null;
        this.size = 0;
    }

    public int size(){
        return size;
    }

    public boolean isEmpty(){
        return size == 0;
    }


    /**
     * 向二分搜索树中添加新的元素e
     * @param e
     */
    public void add(E e){
        //改善前
//        if(root == null ){
//            root = new Node(e);
//            size++;
//        }else {
//            add(e,root);
//            size++;
//        }

        //改善后
        root = add(e,root);
    }

    /**
     * 向以root为根的二分搜索树中插入元素e，递归调用
     * 返回插入新节点后二分搜索树的根
     * @param e
     * @param root
     */
    private Node add(E e,Node root){

        if(root == null){
            size++;
            return new Node(e);
        }


        if(e.compareTo(root.e) > 0){
            root.right = add(e,root.right);
        }else if(e.compareTo(root.e) < 0){
            root.left = add(e,root.left);
        }
        return root;
    }
//    private void add(E e,Node root){
//
//        if(e.equals(root.e)){
//            return;
//        }else if(e.compareTo(root.e) < 0 && root.left == null){
//            root.left = new Node(e);
//            size++;
//            return;
//        }else if(e.compareTo(root.e) > 0 && root.right == null){
//            root.right = new Node(e);
//            size++;
//            return;
//        }
//
//
//        if(e.compareTo(root.e) > 0){
//            root = root.right;
//        }
//        if(e.compareTo(root.e) < 0){
//            root = root.left;
//        }
//        add(e,root);
//    }

    /**
     * 看二分搜索树中是否包含元素e
     * @param e
     * @return
     */
    public boolean contains(E e){
        return contains(e,root);
    }

    /**
     * 看以root为根的二分搜索树中是否包含元素e
     * @param e
     * @param root
     * @return
     */
    private boolean contains(E e,Node root){

        if(root == null){
            return false;
        }

        if(e.compareTo(root.e) == 0){
            return true;
        }else if(e.compareTo(root.e) > 0){
            return contains(e,root.right);
        }else {
            return contains(e,root.left);
        }


    }


    /**
     * 二分搜索树的前序遍历
     */
    public void preOrder(){
        preOrder(root);
    }

    private void preOrder(Node root){
        if(root == null){
            return;
        }

        System.out.println(root.e);
        preOrder(root.left);
        preOrder(root.right);
    }

    /**
     * 二分搜索树的非递归前序遍历
     */
    public void preOrderNR(){

        if(root == null){
            return;
        }

        Stack<Node> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()){
            Node cur = stack.pop();
            System.out.println(cur.e);

            if(cur.right != null){
                stack.push(cur.right);
            }
            if(cur.left != null){
                stack.push(cur.left);
            }

        }

    }

    /**
     * 非递归先序遍历
     *
     */
    public void preOrderNR2(){
        //用来暂存节点的栈
        Stack<Node> stack = new Stack<>();

        //当遍历到最后一个节点的时候，无论它的左右子树都为空，并且栈也为空
        //所以，只要不同时满足这两点，都需要进入循环
        while (root != null || !stack.isEmpty()){

            while (root != null){
                System.out.println(root.e);
                //为了之后能找到该节点的右子树，暂存节点
                stack.push(root);
                root = root.left;
            }

            //一直到左树为空，则开始考虑右子树
            // 如果栈已空，就不需要再考虑
            // 弹出栈顶元素，将游标等于该节点的右子树
            if(!stack.isEmpty()){
                root = stack.pop();
                root = root.right;
            }

        }

    }


    /**
     * 二分搜索树的中序遍历
     */
    public void inOrder(){
        inOrder(root);
    }


    private void inOrder(Node root){
        if(root == null){
            return;
        }

        inOrder(root.left);
        System.out.println(root.e);
        inOrder(root.right);
    }


    /**
     * 非递归中序遍历
     */
    public void inOrderNR(){
        Stack<Node> stack = new Stack<>();

        while (root != null || !stack.isEmpty()){
            if(root != null){
                stack.push(root);
                root = root.left;
            }else {
                root = stack.pop();
                System.out.println(root.e);
                root = root.right;
            }

        }



    }


    /**
     * 后序遍历
     */
    public void postOrder(){
        postOrder(root);
    }

    private void postOrder(Node root){
        if(root == null){
            return;
        }

        postOrder(root.left);
        postOrder(root.right);
        System.out.println(root.e);
    }


    /**
     * 非递归后序遍历
     */
    public void postOrderNR(){

        Stack<Node> stack = new Stack<>();
        Stack<Node> output = new Stack<>();

        while (root != null || !stack.isEmpty()){
            if(root != null){
                stack.push(root);
                output.push(root);
                root = root.right;
            }else {
                root = stack.pop();

                root = root.left;
            }

        }
        while (!output.isEmpty()){
            System.out.println(output.pop().e);
        }

    }




    /**
     * 二分搜索树层序遍历
     */
    public void levelOrder(){
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()){
            Node cur = q.remove();
            System.out.println(cur.e);

            if(cur.left != null){
                q.add(cur.left);
            }
            if(cur.right != null){
                q.add(cur.right);
            }
        }
    }


    /**
     * 寻找二分搜索树的最小元素
     * @return
     */
    public E minimum(){
        if(size == 0){
            throw new IllegalArgumentException("BST is empty");
        }

        Node node = minimum(root);
        return node.e;

    }

    private Node minimum(Node root){
        if(root.left == null){
            return root;
        }
        return minimum(root.left);

    }


    /**
     * 寻找二分搜索树的最大元素
     * @return
     */
    public E maximum(){
        if(size == 0){
            throw new IllegalArgumentException("BST is empty");
        }

        return maximum(root).e;
    }

    private Node maximum(Node root){
        if(root.right == null){
            return root;
        }

        return maximum(root.right);
    }


    /**
     * 从二分搜索树中删除最小值所在节点，返回最小值
     * @return
     */
    public E removeMin(){
        E ret = minimum();

        root = removeMin(root);
        return ret;
    }

    /**
     * 删掉以root为根的二分搜索树中的最小节点
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


    /**
     * 从二分搜索树中删除最大值所在节点，返回最大值
     * @return
     */
    public E removeMax(){
        E ret = maximum();

        root = removeMax(root);
        return ret;
    }

    public Node removeMax(Node root){
        if(root.right == null){
            Node leftNode = root.left;
            root.left = null;
            size--;
            return leftNode;
        }

        root.right = removeMax(root.right);
        return root;
    }


    /**
     * 从二分搜索树中删除元素为e的节点
     * @param e
     */
    public void remove(E e){

    }

    /**
     * 删除以node为根的二分搜索树中值为e的节点，递归算法
     * 返回删除节点后新的二分搜索树的根
     * @param root
     * @param e
     * @return
     */
    private Node remove(Node root, E e){

        if(root == null){
            return null;
        }

        if(e.compareTo(root.e) < 0){
            root.left = remove(root.left,e);
            return root;
        }else if(e.compareTo(root.e) > 0){
            root.right = remove(root.right, e);
            return root;
        }else {
            //带删除节点左子树为空
            if(root.left == null){
                Node rootRight = root.right;
                root.right = null;
                size--;
                return rootRight;
            }
            //待删除节点右子树为空
            if(root.right == null){
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



    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        generateBSTString(root, 0, res);
        return res.toString();
    }


    private void generateBSTString(Node root,int depth, StringBuilder res){
        if(root == null){
            res.append(generateDepthString(depth) + "null\n");
            return;
        }

        res.append(generateDepthString(depth) + root.e + "\n");

        generateBSTString(root.left, depth + 1, res);
        generateBSTString(root.right,depth + 1, res);
    }

    private String generateDepthString(int depth){
        StringBuilder res = new StringBuilder();
        for(int i = 0; i < depth; i++){
            res.append("--");
        }
        return res.toString();
    }
}
