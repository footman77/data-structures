package cn.footman.AVLTree;

import cn.footman.BST.BST;
import cn.footman.map.MyBSTMap;
import cn.footman.set.FileOperation;

import java.util.ArrayList;
import java.util.Collections;

/**
 * @author footman77
 * @create 2018-11-12 20:39
 */
public class AVLTest {
    public static void main(String[] args) {


        System.out.println("Pride and Prejudice");

        ArrayList<String> words1 = new ArrayList<>();
        FileOperation.readFile("pride-and-prejudice.txt",words1);
        Collections.sort(words1);//退化链表
        //System.out.println(" Total words: " + words1.size());

//        MyLinkedListMap<String, Integer> map1 = new MyLinkedListMap<>();
        long startTime = System.nanoTime();

        MyBSTMap<String, Integer> bst = new MyBSTMap<>();
        for(String word : words1){
            if(bst.contains(word)){
                bst.set(word,bst.get(word) + 1);
            }else {
                bst.add(word,1);
            }

        }

        for(String word : words1){
            bst.contains(word);
        }
        System.out.println("Total different words" + bst.getSize());
        System.out.println(bst.get("pride"));

        long endTime = System.nanoTime();
        System.out.println("bst" + (endTime - startTime) / 1000000000.0);

        System.out.println("------------");

        startTime = System.nanoTime();

        MyAVLTree<String, Integer> avl = new MyAVLTree<>();
        for(String word : words1){
            if(avl.contains(word)){
                avl.set(word,avl.get(word) + 1);
            }else {
                avl.add(word,1);
            }

        }

        for(String word : words1){
            avl.contains(word);
        }
        System.out.println("Total different words" + avl.getSize());
        System.out.println(avl.get("pride"));

        endTime = System.nanoTime();
        System.out.println("avl time: " + (endTime - startTime) / 1000000000.0);
    }



}
