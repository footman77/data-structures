package cn.footman.array;

/**
 * @author footman77
 * @create 2018-11-02 18:06
 */
public class Student {
    private String name;
    private int score;

    public Student(String name, int score) {
        this.name = name;
        this.score = score;
    }


    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", score=" + score +
                '}';
    }

    public static void main(String[] args) {
        MyArray<Student> arr = new MyArray<>();
        arr.addLast(new Student("lili",100));
        arr.addLast(new Student("fangfang",32));
        arr.addLast(new Student("xiaohuang",90));
        System.out.println(arr);
    }
}
