package www.j1stiot.cn.collections;

import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;

/**
 * hashMap deep analysis
 */
public class HashMapDemo {

    public static void main(String[] args){

        HashMap<String,String> hashMap=new HashMap<>();
        hashMap.put("hello","hello");

        ConcurrentHashMap<String,String> concurrentHashMap=new ConcurrentHashMap<>();
        concurrentHashMap.put("hello1","hello1");


    }
}
