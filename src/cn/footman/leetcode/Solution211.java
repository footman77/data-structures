package cn.footman.leetcode;



import cn.footman.trie.MyTrie;

import java.util.TreeMap;

/**
 * @author footman77
 * @create 2018-11-11 1:44
 */
public class Solution211 {

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

    public Solution211(){
        this.root = new Node();
    }

    public void addWord(String word){
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
        }
    }

    public boolean search(String word){

        return match(root,word,0);
    }

    private boolean match(Node node,String word, int index){
        if(index == word.length()){
            return node.isWord;
        }

        char c = word.charAt(index);
        if(c != '.'){
            if(node.next.get(c) == null){
                return false;
            }else {
                return match(node.next.get(c),word,index + 1);
            }
        }else {
            for(char nextChar : node.next.keySet()){
                if(match(node.next.get(nextChar),word,index + 1)){
                    return true;
                }
            }
            return false;
        }

    }

}
