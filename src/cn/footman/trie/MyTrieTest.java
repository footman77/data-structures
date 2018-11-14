package cn.footman.trie;

import cn.footman.set.FileOperation;
import cn.footman.set.MyBSTSet;
import org.junit.Test;

import java.util.ArrayList;

/**
 * @author footman77
 * @create 2018-11-11 0:43
 */
public class MyTrieTest {

    public static void main(String[] args) {

    }

    @Test
    public  void testTrie(){
        System.out.println("Pride and Prejudice");

        ArrayList<String> words = new ArrayList<>();
        if(FileOperation.readFile("pride-and-prejudice.txt",words)){

            long startTime = System.nanoTime();

            MyBSTSet<String> set = new MyBSTSet<>();
            for(String word : words){
                set.add(word);
            }
            for(String word : words){
                set.contains(word);
            }

            long endTime = System.nanoTime();
            double time = (endTime - startTime) / 1000000000.0;
            System.out.println("Total different words: " + set.getSize());
            System.out.println("Total BSTtime: " + time + "s");

            System.out.println("--------------");

            startTime = System.nanoTime();

            MyTrie myTrie = new MyTrie();
            for(String word : words){
                myTrie.add(word);
            }
            for(String word : words){
                myTrie.contains(word);
            }

            endTime = System.nanoTime();
            time = (endTime - startTime) / 1000000000.0;
            System.out.println("Total different words: " + myTrie.getSize());
            System.out.println("Total TrieTime: " + time + "s");
        }


    }
}
