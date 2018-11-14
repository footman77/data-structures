package cn.footman.queue;


import java.util.Random;

/**
 * @author footman77
 * @create 2018-11-03 16:31
 */
public class EfficiencyTest {

    /**
     * 测试使用q运行opCount个enqueue和dequeue操作所需要的时间，单位秒
     * @param q
     * @return
     */
    private static double testQueue(MyQueue<Integer> q, int opCount){
        long startTime = System.nanoTime();

        Random random = new Random();


        for(int i = 0; i < opCount; i++){
            q.enqueue(random.nextInt(Integer.MAX_VALUE));
        }

        for(int i = 0; i < opCount; i++){
            q.dequeue();
        }

        long endTime = System.nanoTime();

        return (endTime - startTime) / 1000000000.0;
    }

    public static void main(String[] args) {
        int opCount = 100000;
        MyArrayQueue<Integer> arrayQueue = new MyArrayQueue<>();
        MyLoopQueue<Integer> loopQueue = new MyLoopQueue<>();
        MyLinkedListQueue<Integer> listQueue = new MyLinkedListQueue<>();



        double time1 = testQueue(arrayQueue, opCount);
        System.out.println("ArrayQueue, time :" + time1 + "s");
        double time2 = testQueue(loopQueue, opCount);
        System.out.println("LoopQueue, time :" + time2 + "s");
        double time3 = testQueue(listQueue, opCount);
        System.out.println("ListQueue, time : " + time3 + "s");
    }
}
