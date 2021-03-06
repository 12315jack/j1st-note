package www.j1stiot.cn.concurrency.example.commonUnsafe;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import www.j1stiot.cn.concurrency.annoations.NotThreadSafe;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.*;

@NotThreadSafe
public class HashMapExample {

    //Logger
    private static final Logger log = LoggerFactory.getLogger(HashMapExample.class);

    // 请求总数
    public static int clientTotal = 5000;

    // 同时并发执行的线程数
    public static int threadTotal = 200;

    private static Map<Integer, Integer> map = new HashMap<>();

    public static void main(String[] args) throws Exception {

        ExecutorService executorService = Executors.newCachedThreadPool();
        final Semaphore semaphore = new Semaphore(threadTotal);
        final CountDownLatch countDownLatch = new CountDownLatch(clientTotal);
        for (int i = 0; i < clientTotal; i++) {
            final int count = i;
            executorService.execute(() -> {
                try {
                    semaphore.acquire();
                    update(count);
                    semaphore.release();
                } catch (Exception e) {
                    log.error("exception", e);
                }
                countDownLatch.countDown();
            });
        }
        countDownLatch.await();
        executorService.shutdown();
        log.info("size:{}", map.size());
    }

    private static void update(int i) {
        map.put(i, i);
    }
}
