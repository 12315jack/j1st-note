package www.j1stiot.cn.concurrency.example.singleton;


import www.j1stiot.cn.concurrency.annoations.ThreadSafe;

/**
 * 饿汉模式
 * 单例实例在类装载时进行创建
 * 线程安全的类
 */
@ThreadSafe
public class SingletonExample2 {

    // 单例对象
    private static SingletonExample2 instance = new SingletonExample2();

    // 私有构造函数
    private SingletonExample2() {

    }

    // 静态的工厂方法
    public static SingletonExample2 getInstance() {
        return instance;
    }
}
