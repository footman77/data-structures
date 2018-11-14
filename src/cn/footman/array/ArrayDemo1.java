package cn.footman.array;

/**
 * @author footman77
 * @create 2018-11-01 21:39
 */
public class ArrayDemo1 {

    public static void main(String[] args) {

//        int[] arr = new int[10];
//        for(int i = 0; i < arr.length; i++){
//            arr[i] = i;
//        }
//
//
//        int[] scores = new int[]{90,92,93};
//        for(int score : scores){
//            System.out.println(score);
//        }


        MyArray myArray = new MyArray<Integer>();
        for(int i = 0; i < 10; i++ ){
            myArray.addLast(i);
        }
        System.out.println(myArray);
        myArray.add(4,11);
        System.out.println(myArray);


        myArray.addFirst(12);
        System.out.println(myArray);

        myArray.set(2,99);

        System.out.println(myArray);

//
        myArray.remove(4);
        System.out.println(myArray);

        myArray.removeElement(2);
        System.out.println(myArray);
//
        myArray.removeFirst();
        System.out.println(myArray);
    }

}
