package www.j1stiot.cn.concurrency.example.frequent;

import java.util.concurrent.CountDownLatch;

/**
 * 更像是个计数器，调用await()方法，知道计数器减为0后再往后执行
 */
public class CountDownLatchDemo {
    public static void main(String[] args) {

        CountDownLatch start = new CountDownLatch(1);
        CountDownLatch end = new CountDownLatch(5);
        for (int i = 0; i < 5; i++) {
            new Thread(new Worker(start, end)).start();
        }

        try {
            //这里就是你所需要添加条件的地方，条件满足就执行下面的方法，这是阻塞的线程既可以再次开始了
            if(true) {
                start.countDown();
            }
            end.await();    //等待所有操作执行完，计数器减为0，才继续往下执行
            System.out.println("所有任务做完了，接下来你可以干自己想干的了");
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

    public static class Worker implements Runnable{
        CountDownLatch start;
        CountDownLatch end;

        public Worker(CountDownLatch cLatch, CountDownLatch cLatch2) {
            super();
            this.start = cLatch;
            this.end = cLatch2;
        }

        @Override
        public void run() {
            try {
                System.out.println("执行你任务的前半部分  = "+Thread.currentThread().getName());
                start.await();
                System.out.println("执行你任务的后半部分  = "+Thread.currentThread().getName());
                end.countDown();
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }

        }

    }
}
