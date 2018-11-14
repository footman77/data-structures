package cn.footman.segmentTree;

/**
 * @author footman77
 * @create 2018-11-09 14:05
 */
public class SegmentTest {
    public static void main(String[] args) {

        Integer[] nums = {-1, 3, -4, 9, 2};
        MySegmentTree<Integer> segmentTree
                = new MySegmentTree<Integer>(nums, (a,b) -> a + b);

//        System.out.println(segmentTree);
        Integer query = segmentTree.query(1, 3);
        System.out.println(query);
    }
}
