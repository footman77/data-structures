package cn.footman.BST;

/**
 * @author footman77
 * @create 2018-11-05 15:34
 */
public class BSTTest {
    public static void main(String[] args) {
        BST<Integer> bst = new BST<>();
        int[] nums = {32, 6, 7, 1, 10};
        for(int i = 0 ; i < nums.length; i++){
            bst.add(nums[i]);
        }

        bst.levelOrder();

//        bst.preOrder();
//        System.out.println();
//
//        bst.preOrderNR();
//        System.out.println();
////
//        bst.postOrderNR();
//        System.out.println("--------");

//        bst.post();
//        System.out.println();
//
//
//        bst.inOrder();
//        System.out.println();
//
//        bst.postOrder();
//        System.out.println();
//        System.out.println("------------");
//
//        System.out.println(bst);
    }
}
