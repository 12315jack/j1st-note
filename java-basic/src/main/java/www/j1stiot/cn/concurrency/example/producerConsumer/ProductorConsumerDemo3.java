package www.j1stiot.cn.concurrency.example.producerConsumer;

import java.util.Random;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * 使用BlockingQueue实现生产者-消费者
 * 由于BlockingQueue内部实现就附加了两个阻塞操作。即当队列已满时，
 * 阻塞向队列中插入数据的线程，直至队列中未满；当队列为空时，
 * 阻塞从队列中获取数据的线程，直至队列非空时为止。
 * 关于BlockingQueue更多细节可以看这篇文章。可
 * 以利用BlockingQueue实现生产者-消费者为题，阻塞队列完全可以充当共享数据区域，就可以很好的完成生产者和消费者线程之间的协作。
 */
public class ProductorConsumerDemo3 {
    private static LinkedBlockingQueue<Integer> queue = new LinkedBlockingQueue<>();
    public static void main(String[] args) {
        ExecutorService service = Executors.newFixedThreadPool(15);
        for (int i = 0; i < 5; i++) {
            service.submit(new Productor(queue));
        }
        for (int i = 0; i < 10; i++) {
            service.submit(new Consumer(queue));
        }
    }

    static class Productor implements Runnable {
        private BlockingQueue queue;
        public Productor(BlockingQueue queue) {
            this.queue = queue;
        }

        @Override
        public void run() {
            try {
                while (true) {
                    Random random = new Random();
                    int i = random.nextInt();
                    System.out.println("生产者" + Thread.currentThread().getName() + "生产数据" + i);
                    queue.put(i);
                    Thread.sleep(1000);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    static class Consumer implements Runnable {
        private BlockingQueue queue;
        public Consumer(BlockingQueue queue) {
            this.queue = queue;
        }
        @Override
        public void run() {
            try {
                while (true) {
                    Integer element = (Integer) queue.take();
                    System.out.println("消费者" + Thread.currentThread().getName() + "正在消费数据" + element);
                    Thread.sleep(1000);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
