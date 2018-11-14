package cn.footman.leetcode;

/**
 * @author footman77
 * @create 2018-11-09 19:37
 */
public class NumArray2 {

    //sum[i]表示前i个元素的和
    private int[] sum;

    public NumArray2(int[] nums){
        this.sum = new int[nums.length];
        if(nums.length > 0){
            for(int i = 0; i < nums.length; i++){
                sum[i] = getSum(nums, i);
            }
        }
    }

    private int getSum(int[] nums,int i){
        int res = 0;
        for(int j = 0; j <= i; j++){
            res = nums[j] + res;
        }

        return res;
    }

    public int sumRange(int i,int j){
        if(sum.length == 0){
            throw new IllegalArgumentException("there is not num");
        }
        if(i == 0){
            return sum[j];
        }else {
            return sum[j] - sum[i - 1];
        }
    }


    public static void main(String[] args) {
        int[] nums = {-2,0,3,-5,2,-1};
        NumArray2 array2 = new NumArray2(nums);
        int i = array2.sumRange(2, 5);
        System.out.println(i);
    }
}
