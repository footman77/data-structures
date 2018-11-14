package cn.footman.hashcode;

import java.util.HashMap;
import java.util.HashSet;

/**
 * @author footman77
 * @create 2018-11-14 0:56
 */
public class hashTest01 {
    public static void main(String[] args) {
        int a = 3;
        System.out.println(((Integer)a).hashCode() );

        Student student = new Student(3, 2, "kokio", "yao");
        System.out.println(student.hashCode());

        HashSet<Student> set = new HashSet<>();
        set.add(student);

        HashMap<Student, Integer> scores = new HashMap<>();
        scores.put(student, 100);

        Student student2 = new Student(3, 2, "kokio", "yao");
        System.out.println(student2.hashCode());
    }
}
