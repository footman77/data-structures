package cn.footman.map;

import cn.footman.set.FileOperation;
import cn.footman.set.MyBSTSet;
import org.junit.Test;

import java.util.ArrayList;

/**
 * @author footman77
 * @create 2018-11-07 1:18
 */
public class MapTest {
    public static void main(String[] args) {
        System.out.println("Pride and Prejudice");

        ArrayList<String> words1 = new ArrayList<>();
        FileOperation.readFile("pride-and-prejudice.txt",words1);
        System.out.println(" Total words: " + words1.size());

//        MyLinkedListMap<String, Integer> map1 = new MyLinkedListMap<>();
        MyBSTMap<String, Integer> map1 = new MyBSTMap<>();
        for(String word : words1){
            if(map1.contains(word)){
                map1.set(word,map1.get(word) + 1);
            }else {
                map1.add(word,1);
            }

        }
        System.out.println("Total different words" + map1.getSize());
        System.out.println(map1.get("pride"));
    }




    private double test(MyMap<String,Integer> myMap,String filename){
        long startTime = System.nanoTime();

        System.out.println("Pride and Prejudice");

        ArrayList<String> words1 = new ArrayList<>();
        FileOperation.readFile("pride-and-prejudice.txt",words1);
        System.out.println(" Total words: " + words1.size());

//        MyLinkedListMap<String, Integer> map1 = new MyLinkedListMap<>();

        for(String word : words1){
            if(myMap.contains(word)){
                myMap.set(word,myMap.get(word) + 1);
            }else {
                myMap.add(word,1);
            }

        }
        System.out.println("Total different words" + myMap.getSize());
        System.out.println(myMap.get("pride"));

        long endTime = System.nanoTime();
        return (endTime - startTime) / 1000000000.0;
    }

    @Test
    public void test01(){
        MyBSTMap<String, Integer> map1 = new MyBSTMap<>();
        String filename = "pride-and-prejudice.txt";
        double time1 = test(map1, filename);
        System.out.println("BST time : " + time1);

        System.out.println("=============");

        MyLinkedListMap<String, Integer> map2 = new MyLinkedListMap<>();
        double time2 = test(map2, filename);
        System.out.println("LinkedList time : " + time2);

        System.out.println("==============");
        MyAVLMap<String, Integer> map3 = new MyAVLMap<>();
        double time3 = test(map3, filename);
        System.out.println("LinkedList time : " + time3);


    }
}
