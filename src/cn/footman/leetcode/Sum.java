package cn.footman.leetcode;

import org.junit.Test;

/**
 * @author footman77
 * @create 2018-11-04 16:29
 */
public class Sum {

    public int sum(int[] arr){

        return sum(arr,0);
    }


    /**
     * 计算arr[l...n)这个区间内所有数字的和
     * @param arr
     * @param l
     * @return
     */
    public int sum(int[] arr, int l){

        if(l == arr.length){
            return 0;
        }
        return arr[l] + sum(arr,l + 1);
    }

    @Test
    public void test(){
        int[] arr = {1, 2, 3, 4, 6, 4};
        int sum = sum(arr);
        System.out.println(sum);
    }
}
