package cn.footman.RedBlackTree;

import cn.footman.map.MyAVLMap;
import cn.footman.map.MyBSTMap;

import java.util.ArrayList;
import java.util.Random;

/**
 * @author footman77
 * @create 2018-11-13 19:38
 */
public class Test3 {

    public static void main(String[] args) {
        int n = 20000000;


        ArrayList<Integer> testData = new ArrayList<>();
        for(int i = 0; i < n; i ++){
            testData.add(i);
        }

//        long startTime = System.nanoTime();
//
//        MyBSTMap<Integer, Integer> bstMap = new MyBSTMap<>();
//        for(Integer x : testData){
//            bstMap.add(x,null);
//        }
//        long endTime = System.nanoTime();
//
//        System.out.println("bst time : " + (endTime - startTime) / 1000000000.0);
//
//        System.out.println("============");

        long startTime = System.nanoTime();

        MyAVLMap<Integer, Integer> avlMap = new MyAVLMap<>();


        for(Integer x : testData){
            avlMap.add(x,null);
        }
        long endTime = System.nanoTime();

        System.out.println("avl time : " + (endTime - startTime) / 1000000000.0);

        System.out.println("============");
        startTime = System.nanoTime();

        MyRBTree<Integer, Integer> rbtMap = new MyRBTree<>();

        for(Integer x : testData){
            rbtMap.add(x,null);
        }
        endTime = System.nanoTime();

        System.out.println("rbt time : " + (endTime - startTime) / 1000000000.0);


    }
}
