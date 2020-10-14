package www.j1stiot.cn.concurrency.example.aqs;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 同步辅助类
 * 允许一组线程相互等待，通过它可以完成多线程之间的相互等待，只有当每个线程都准备就绪后才能各自继续往下操作
 *
 *
 * CyclicBarrier 与 CountDownLatch的区别
 *
 *  1.CyclicBarrier 计数器可以通过reset方法重复使用，CountDownLatch计数器只能使用一次
 *  2.CountDownLatch实现一个或者n个线程需要等待其他线程完成某项操作后才能继续往下执行，
 *  CyclicBarrier 实现多个线程之间相互等待
 *
 *
 */
public class CyclicBarrierExample1 {

    // logger
    private static final Logger log = LoggerFactory.getLogger(CyclicBarrierExample1.class);

    private static CyclicBarrier barrier = new CyclicBarrier(5);

    public static void main(String[] args) throws Exception {

        ExecutorService executor = Executors.newCachedThreadPool();

        for (int i = 0; i < 10; i++) {
            final int threadNum = i;
            Thread.sleep(1000);
            executor.execute(() -> {
                try {
                    race(threadNum);
                } catch (Exception e) {
                    log.error("exception", e);
                }
            });
        }
        executor.shutdown();
    }

    private static void race(int threadNum) throws Exception {
        Thread.sleep(1000);
        log.info("{} is ready", threadNum);
        barrier.await();
        log.info("{} continue", threadNum);
    }
}
