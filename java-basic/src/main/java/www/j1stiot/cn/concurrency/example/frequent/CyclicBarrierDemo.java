package www.j1stiot.cn.concurrency.example.frequent;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * 主要方法为 wait()
 *  等待所有线程执行结束，达到指定的条件后再一起向后执行
 */
public class CyclicBarrierDemo {

    public static void main(String[] args)  {

        int num = 10;
        CyclicBarrier barrier = new CyclicBarrier(num, new Runnable() {
            @Override
            public void run() {
                System.out.println("前半部分任务执行完了，这里在执行点自己任务，执行完后就可以执行后半部分任务了!");
            }
        });

        List<Thread> list = new ArrayList<>();
        for (int i = 1; i <= num; i++) {
            Thread thread = new Thread(new CyclicBarrierWorker(i, barrier));
            list.add(thread);
            thread.start();
        }

        //这里是为了让子线程的任务先执行完在执行主线程的任务
        for (Thread thread : list) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        System.out.println("所有的后半部分任务都执行完了，你可以做自己的事了");

    }

    public static class CyclicBarrierWorker implements Runnable {
        private int id;
        private CyclicBarrier barrier;

        public CyclicBarrierWorker(int id, final CyclicBarrier barrier) {
            this.id = id;
            this.barrier = barrier;
        }

        @Override
        public void run() {
            // TODO Auto-generated method stub
            try {
                System.out.println("前半部分任务 id = "+id);
                barrier.await(); // 大家等待最后一个线程到达
                System.out.println("后半部分任务 id = "+id);
            } catch (InterruptedException | BrokenBarrierException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }

}
