package cn.footman.stack;

import cn.footman.linkedList.MyLinkedList;
import org.junit.Test;

import java.util.Random;
import java.util.Stack;

/**
 * @author footman77
 * @create 2018-11-02 22:22
 */
public class StackTest {

    public static void main(String[] args) {

        MyArrayStack<Integer> myArrayStack = new MyArrayStack<>();

        for(int i = 0; i < 5; i++){
            myArrayStack.push(i);
            System.out.println(myArrayStack);
        }

        myArrayStack.pop();
        System.out.println(myArrayStack);
    }

    @Test
    public void LinkedListTest(){
        MyLinkedListStack<Integer> linkedList = new MyLinkedListStack<>();
        for(int i = 0; i < 5; i++){
            linkedList.push(i);
            System.out.println(linkedList);
        }

        linkedList.pop();
        System.out.println(linkedList);
    }

    private double testStack(MyStack<Integer> myStack,int opCount){
        long startTime = System.nanoTime();

        Random random = new Random();
        for(int i = 0; i < opCount; i++){
            myStack.push(random.nextInt(Integer.MAX_VALUE));
        }
        for(int i = 0; i < opCount; i++){
            myStack.pop();
        }


        long entTime = System.nanoTime();

        return (entTime - startTime) / 1000000000.0;


    }

    @Test
    public void efficiencyTest(){
        int opCount = 10000000;

        MyLinkedListStack<Integer> linkedList = new MyLinkedListStack<>();

        double time1 = testStack(linkedList, opCount);
        System.out.println("LinkedListStack time : " + time1 + "s");

        MyArrayStack<Integer> arrayStack = new MyArrayStack<>();

        double time2 = testStack(arrayStack, opCount);
        System.out.println("ArrayStack time : " + time2 + "s");


    }
}
