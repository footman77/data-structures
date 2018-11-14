package cn.footman.heap;

import org.junit.Test;

import java.util.Random;

/**
 * @author footman77
 * @create 2018-11-07 22:45
 */
public class HeapTest {

    private double testHeap(Integer[] testData, boolean isHeapify){
        long startTime = System.nanoTime();

        MaxHeap<Integer> maxHeap;
        if(isHeapify){
            maxHeap = new MaxHeap<>(testData);
        }else {
            maxHeap = new MaxHeap<>();
            for(int i = 0; i < testData.length; i++){
                maxHeap.add(testData[i]);
            }
        }
        int[] arr = new int[testData.length];
        for(int i = 0; i < testData.length ; i++){
            arr[i] = maxHeap.extractMax();
        }

        for(int i = 1; i < testData.length; i++){
            if(arr[i - 1] < arr[i]){
                throw new IllegalArgumentException("error");
            }
        }
        System.out.println("text maxHeap completed.");


        long endTime = System.nanoTime();
        return  (endTime - startTime) / 1000000000.0;
    }

    @Test
    public void test01(){
        int n = 5000000;
        Random random = new Random();
        Integer[] arr = new Integer[n];
        for(int i = 0; i < n; i++){
            arr[i] = random.nextInt(Integer.MAX_VALUE);
        }
        double time2 = testHeap(arr, false);
        System.out.println("normal time : " + time2);
        double time1 = testHeap(arr, true);
        System.out.println("heapify time : " + time1);

    }




    public static void main(String[] args) {
        int n = 1000000;
        MaxHeap<Integer> maxHeap = new MaxHeap<>();
        Random random = new Random();
        for(int i = 0; i < n; i++){
            maxHeap.add(random.nextInt(Integer.MAX_VALUE));
        }

        int[] arr = new int[n];
        for(int i = 0; i < n ; i++){
            arr[i] = maxHeap.extractMax();
        }

        for(int i = 1; i < n; i++){
            if(arr[i - 1] < arr[i]){
                throw new IllegalArgumentException("error");
            }
        }
        System.out.println("text maxHeap completed.");
    }
}
