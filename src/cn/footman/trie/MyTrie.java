package cn.footman.trie;

import java.util.TreeMap;

/**
 * @author footman77
 * @create 2018-11-10 23:34
 */
public class MyTrie {


    private class Node{
        boolean isWord;

        public TreeMap<Character,Node> next;

        public Node(boolean isWord){
            this.isWord = isWord;
            next = new TreeMap<>();
        }

        public Node(){
            this(false);
        }
    }


    private Node root;
    private int size;

    public MyTrie(){
        this.root = new Node();
        this.size = 0;
    }

    /**
     * 获得Trie中存储的单词数量
     * @return
     */
    public int getSize(){
        return size;
    }

    /**
     * 向Trie中添加一个新的单词word
     * @param word
     */
    public void add(String word){

        Node cur = root;

        for(int i = 0; i < word.length(); i++){
            char c = word.charAt(i);
            if(cur.next.get(c) == null){
                cur.next.put(c, new Node());
            }
            cur = cur.next.get(c);
        }
        if(!cur.isWord){
            cur.isWord = true;
            size++;
        }

    }


    /**
     * 查看单词word是否在Trie中
     * @param word
     * @return
     */
    public boolean contains(String word){

        Node cur = root;

        for(int i = 0; i < word.length(); i ++){
            char c = word.charAt(i);
            if(cur.next.get(c) != null){

                cur = cur.next.get(c);
            }else {
                return false;
            }
        }
        return cur.isWord;
    }

    /**
     * 查询是否在Trie中有单词以prefix为前缀
     * @return
     */
    public boolean isPrefix(String prefix){

        Node cur = root;
        for(int i = 0; i < prefix.length();i ++){
            char c = prefix.charAt(i);
            if(cur.next.get(c) != null){
                cur = cur.next.get(c);
            }else {
                return false;
            }
        }
        return true;
    }

}
