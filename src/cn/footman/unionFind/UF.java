package cn.footman.unionFind;

/**
 * @author footman77
 * @create 2018-11-11 18:22
 */
public interface UF {



    int getSize();

    boolean isConnected(int p, int q);

    void unionElements(int p, int q);

}
