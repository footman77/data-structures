package cn.footman.linkedList;

/**
 * @author footman77
 * @create 2018-11-03 23:33
 */
public class ListTest {
    public static void main(String[] args) {
        MyLinkedListR<Integer> linkedList = new MyLinkedListR<>();

        for(int i = 0; i <  5; i++){
            linkedList.addFirst(i);
            System.out.println(linkedList);
        }
        linkedList.add(2,89);
        System.out.println(linkedList);
//
        linkedList.remove(2);
        System.out.println(linkedList);
//
        linkedList.removeFirst();
        System.out.println(linkedList);
        linkedList.removeLast();
        System.out.println(linkedList);
    }
}
