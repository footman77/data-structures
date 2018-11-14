package cn.footman.leetcode;

import org.junit.Test;

/**
 * @author footman77
 * @create 2018-11-04 13:40
 */
public class Solution {

    public ListNode removeElements(ListNode head,int val){

        while (head != null && head.val == val){
//            ListNode delNode = head;
            head = head.next;
//            delNode.next = null;
        }

        if(head == null){
            return null;
        }

        ListNode prev = head;
        while (prev.next != null){
            if(prev.next.val == val){
//                ListNode  delNode = prev.next;
//                prev.next = delNode.next;
//                delNode.next = null;
                prev.next = prev.next.next;
            }else {
                prev = prev.next;
            }
        }
        return head;
    }


    public ListNode removeElements2(ListNode head,int val){

        //虚拟头节点
        ListNode dummyHead = new ListNode(-1);
        dummyHead.next = head;



        ListNode prev = dummyHead;
        while (prev.next != null){
            if(prev.next.val == val){
//                ListNode  delNode = prev.next;
//                prev.next = delNode.next;
//                delNode.next = null;
                prev.next = prev.next.next;
            }else {
                prev = prev.next;
            }
        }
        return dummyHead.next;
    }


    /**
     * 使用递归
     * @param head
     * @param val
     * @return
     */
    public ListNode removeElements3(ListNode head,int val, int depth){

        String depthString = generateDepthString(depth);
        System.out.print(depthString);
        System.out.println("Call : remove " + val + "in" + head);

        if(head == null){
            System.out.print(depthString);
            System.out.println("Return : " + head);
            return null;
        }

        ListNode res = removeElements3(head.next, val, depth + 1);
        System.out.print(depthString);
        System.out.println("After remove : " + val + ": " + res);
//        head.next = removeElements3(head.next,val,depth + 1);
        ListNode ret;
        if(head.val == val){
            ret =  res;

        }else {
            head.next = res;
            ret =  head;
        }
        System.out.print(depthString);
        System.out.println("Return : "+ ret);
        return ret;

//        return head.val == val ? head.next : head;
    }


    private String generateDepthString(int depth){
        StringBuilder res = new StringBuilder();
        for(int i = 0; i < depth; i++){
            res.append("--");
        }
        return res.toString();
    }

    @Test
    public void test01(){
        int[] nums = {1,2,6,3,4,5,6};
        ListNode head = new ListNode(nums);
        System.out.println(head);

        ListNode head1 = removeElements3(head, 6,0);
        System.out.println(head1);
    }

}
