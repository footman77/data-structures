package cn.footman.BST;

import java.util.ArrayList;
import java.util.Random;

/**
 * @author footman77
 * @create 2018-11-06 0:47
 */
public class BSTTest2 {

    public static void main(String[] args) {
        BST<Integer> bst = new BST<>();
        Random random = new Random();

        int n = 1000;

        for(int i = 0; i < n ; i++){
            bst.add(random.nextInt(10000));
        }

        ArrayList<Integer> nums = new ArrayList<>();
        while (!bst.isEmpty()){
            nums.add(bst.removeMin());
        }

        System.out.println(nums);
        for(int i = 1; i < nums.size(); i++){
            if(nums.get(i - 1) > nums.get(i)){
                throw new IllegalArgumentException("Error");
            }
        }

        System.out.println("removeMin test completed");

    }
}
