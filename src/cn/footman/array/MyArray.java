package cn.footman.array;

/**
 * @author footman77
 * @create 2018-11-01 21:59
 */
public class MyArray<E> {

    private E[] data;
    private int size;

    /**
     * 构造函数，传入数组的容量capacity构造ArrayDemo2
     * @param capacity
     */
    public MyArray(int capacity){
        data = (E[])new Object[capacity];
        size = 0;
    }

    public MyArray(E[] arr){
        data = (E[])new Object[arr.length];
        for(int i = 0; i < arr.length; i++){
            data[i] = arr[i];
        }
        size = arr.length;
    }

    /**
     * 无参构造函数，调用有参的构造函数，默认容量为10
     */
    public MyArray(){
        this(10);
    }

    /**
     * 获取数组中的元素个数
     * @return
     */
    public int getSize(){
        return size;
    }

    /**
     * 获取数组的容量
     * @return
     */
    public int getCapacity(){
        return data.length;
    }

    /**
     * 返回数组是否为空
     * @return
     */
    public boolean isEmpty(){
        return size == 0;
    }

    /**
     * 向所有元素后添加一个新元素
     * @param e 添加的新元素
     */
    public void addLast(E e){
//        if(size == data.length){
//          throw new IllegalArgumentException("AddLast failed. Array is full.");
//        }
//        data[size] = e;
//        size++;

        add(size,e);
    }

    /**
     * 向数组头添加一个元素
     * @param e
     */
    public void addFirst(E e){
        add(0,e);
    }

    /**
     * 在第index位置插入一个新的元素e
     * @param index
     * @param e
     */
    public void add(int index,E e){

        if(index < 0 || index > size){
            throw new IllegalArgumentException("Add failed. Require index >= 0 && index <= size");
        }

        if(size == data.length){
            resize(2 * data.length);
        }
//        int flag = size;
//        while (index < size){
//            data[size + 1] = data[size];
//            size--;
//        }
//        data[index] = e;
//        size = flag + 1;
        for(int i = size - 1; i >= index; i--){
            data[i + 1] = data[i];
        }
        data[index] = e;
        size++;
    }





    /**
     * 获取index位置的元素
     * @param index
     * @return
     */
    public E get(int index){
        if(index < 0 || index >= size){
            throw new IllegalArgumentException("Get failed,index is illegal");
        }
        return data[index];
    }

    /**
     * 获取最后一个元素
     * @return
     */
    public E getLast(){
        return get(size - 1);
    }

    /**
     * 获取第一个元素
     * @return
     */
    public E getFirst(){
        return get(0);
    }

    /**
     * 修改index位置的元素为e
     * @param index
     * @param e
     */
    public void set(int index,E e){
        if(index < 0 || index >= size){
            throw new IllegalArgumentException("Get failed,index is illegal");
        }
        data[index] = e;
    }

    /**
     * 判断数组中是否包含元素e
     * @return
     */
    public boolean  contains(E e){
        for(int i = 0; i < size ;i++){
            if(data[i].equals(e)){
                return true;
            }
        }
        return false;
    }


    /**
     * 查找数组中元素e所在的索引，如果不存在，则返回-1
     * @param e
     * @return
     */
    public int find(E e){
        for(int i = 0; i < size; i++){
            if(data[i].equals(e)){
                return i;
            }
        }
        return -1;
    }


    /**
     * 删除数组中索引为index的元素,并返回删除的元素
     * @param index
     * @return
     */
    public E remove(int index){
        if(index < 0 || index >= size){
            throw new IllegalArgumentException("remove failed, index is illeagal");
        }
        E temp = data[index];
        for(int i = index; i < size - 1; i++){
            data[i] = data[i + 1];
        }
        size--;
        data[size] = null; //loitering object  != memory leak

        if(size == data.length / 4 && data.length / 2 != 0){
            resize(data.length / 2);
        }
        return temp;
    }


    /**
     * 删除第一个元素
     * @return
     */
    public E removeFirst(){
        return remove(0);
    }


    /**
     * 从数组中删除元素e
     * @param e
     */
    public void removeElement(E e){
        int index = find(e);
        if(index != -1){
            remove(index);
        }
    }


    /**
     * 删除最后一个元素
     * @return
     */
    public E removeLast(){
        return remove(size - 1);
    }

    /**
     * 交换两个索引的值
     * @param i
     * @param j
     */
    public void swap(int i ,int j){
        if(i < 0 || i >= size || j < 0 || j >= size){
            throw new IllegalArgumentException("index is illegal");
        }

        E t = data[i];
        data[i] = data[j];
        data[j] = t;
    }


    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        res.append(String.format("Array: size = %d , capacity = %d\n", size,data.length));
        res.append('[');
        for(int i = 0; i < size; i++){
            res.append(data[i]);
            if(i != size - 1 ){
                res.append(',');
            }
        }
        res.append(']');
        return res.toString();
    }


    /**
     * 数组自动扩容
     * @param newCapacity
     */
    private void resize(int newCapacity){

        E[] newData = (E[]) new Object[newCapacity];

        for(int i = 0; i < size; i++){
            newData[i] = data[i];
        }
        data = newData;

    }
}
