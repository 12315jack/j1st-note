package www.j1stiot.cn.concurrency.example.aqs;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import www.j1stiot.cn.concurrency.example.hystrix.HystrixController1;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 线程不安全，多线程修改同一个静态变量时候，各个线程修改的数据
 * 可能会发生数据覆盖
 *
 * CountLatch是一个同步辅助类，
 *  给定一个计数器，原子操作，调用await()方法会阻塞进程，线程调用countDown，
 *  使计数器的值减1，直到计数器值为0，才执行接下来的步骤
 */
public class CountDownLatchExample1 {

    // logger
    private static final Logger log = LoggerFactory.getLogger(CountDownLatchExample1.class);

    private final static int threadCount = 20;

    public static void main(String[] args) throws Exception {

        ExecutorService exec = Executors.newCachedThreadPool();

        final CountDownLatch countDownLatch = new CountDownLatch(threadCount);

        for (int i = 0; i < threadCount; i++) {
            final int threadNum = i;
            exec.execute(() -> {
                try {
                    test(threadNum);
                } catch (Exception e) {
                    log.error("exception", e);
                } finally {
                    countDownLatch.countDown();
                }
            });
        }
        countDownLatch.await();
        log.info("finish");
        exec.shutdown();
    }

    private static void test(int threadNum) throws Exception {
        Thread.sleep(100);
        log.info("{}", threadNum);
        Thread.sleep(100);
    }
}
