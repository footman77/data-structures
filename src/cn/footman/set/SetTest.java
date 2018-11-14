package cn.footman.set;

import com.sun.org.apache.bcel.internal.generic.NEW;
import org.junit.Test;

import java.io.File;
import java.util.ArrayList;

/**
 * @author footman77
 * @create 2018-11-06 16:04
 */
public class SetTest {

    public static void main(String[] args) {
        System.out.println("Pride and Prejudice");

        ArrayList<String> words1 = new ArrayList<>();
        FileOperation.readFile("pride-and-prejudice.txt",words1);
        System.out.println(" Total words: " + words1.size());

        MyBSTSet<String> set1 = new MyBSTSet<>();
        for(String word : words1){
            set1.add(word);
        }
        System.out.println("Total different words" + set1.getSize());

//        File file = new File("pride-and-prejudice.txt");
//        System.out.println(file.exists());

    }


    private double testSet(MySet<String> mySet, String filename){

        long startTime = System.nanoTime();

        System.out.println(filename);

        ArrayList<String> words = new ArrayList<>();
        if(FileOperation.readFile(filename,words)){
            System.out.println("Total words: " + words.size());

            for(String word : words){
                mySet.add(word);
            }
            System.out.println("Total different words: " + mySet.getSize());

        }


        long endTime = System.nanoTime();

        return (endTime - startTime) / 1000000000.0;
    }


    @Test
    public void test01(){
        String filename = "pride-and-prejudice.txt";
        MyBSTSet<String> setBST = new MyBSTSet<>();

        double time1 = testSet(setBST, filename);
        System.out.println("BSTSet time: " + time1);
        System.out.println("=============");

        MyLinkedListSet<String> setLinkedlist = new MyLinkedListSet<>();
        double time2 = testSet(setLinkedlist, filename);
        System.out.println("LinkedListSet time: " + time2);
        System.out.println("============");
        MyAVLSet<String> avlSet = new MyAVLSet<>();
        double time3 = testSet(avlSet, filename);
        System.out.println("avlSet time: " + time3);
    }

}
