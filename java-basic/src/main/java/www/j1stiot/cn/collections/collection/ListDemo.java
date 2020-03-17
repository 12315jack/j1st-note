package www.j1stiot.cn.collections.collection;

import org.checkerframework.checker.units.qual.A;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Vector;

/**
 * 集合 List 接口
 */
public class ListDemo {

    public static void main(String[] args) {
        //TODO 1.实现类
        //ArrayList 底层数据结构是数组，查询快，增删慢，线程不安全，效率高，可以存储重复元素
        //LinkedList 底层数据结构是链表，查询慢，增删快，线程不安全，效率高，可以存储重复元素
        //Vector 底层数据结构是数组，查询快，增删慢，线程安全，效率低，可以存储重复元素

        //TODO 2.源码分析
        List<String> demoList=new ArrayList<>();
        List<String> demoLinked=new LinkedList<>();
        List<String> demoVector=new Vector<>();



    }
}
