package www.j1stiot.cn.concurrency.example.sync;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * synchronized 修饰一个方法和修饰一个代码块效果一样
 */
@Slf4j
public class SynchronizedExample1 {

    public static void main(String[] args) {

        //测试synchronized修饰方法和代码块，生成二个对象，调用同一个方法和代码，结果是乱序输出，互不影响
        SynchronizedExample1 example1 = new SynchronizedExample1();
        SynchronizedExample1 example2 = new SynchronizedExample1();
        ExecutorService executorService = Executors.newCachedThreadPool();
        executorService.execute(() -> {
            example1.test2(1);
        });
        executorService.execute(() -> {
            example2.test2(2);
        });
    }

    /**
     * 当 synchronized 修饰一个代码块,作用域为当前调用的对象
     * 不同调用对象相互不影响
     */
    public void test1(int j) {
        synchronized (this) {
            for (int i = 0; i < 10; i++) {
                log.info("sync-test-1 {} - {}", j, i);
            }
        }
    }

    /**
     * 当 synchronized 修饰一个方法,作用域为当前调用
     * 不同调用对象相互不影响
     * 子类继承父类的时候无法获取 synchronized 修饰符，需要手动添加如果需要的话
     */
    public synchronized void test2(int j) {
        for (int i = 0; i < 10; i++) {
            log.info("sync-test-2 {} - {}", j, i);
        }
    }
}
