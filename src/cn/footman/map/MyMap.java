package cn.footman.map;

/**
 * @author footman77
 * @create 2018-11-07 0:08
 */
public interface MyMap<K,V> {

    void add(K key, V value);
    V remove(K key);
    boolean contains(K key);
    V get(K key);
    void set(K key, V value);
    int getSize();
    boolean isEmpty();
}
