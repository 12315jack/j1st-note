package www.j1stiot.cn.concurrency.example.thread;

import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Callable和Runnable区别
 */
public class ThreadDemo {

    public static void main(String[] args) {
        Callable<Integer> callable = new Callable<Integer>() {
            @Override
            public Integer call() throws Exception {
                Thread.sleep(6000);
                return new Random().nextInt();
            }
        };
        FutureTask<Integer> future = new FutureTask<>(callable);
        new Thread(future).start();
        try {
            Thread.sleep(1000);
            System.out.println("hello begin");
            System.out.println(future.isDone());
            System.out.println(future.get());
            System.out.println(future.isDone());
            System.out.println("hello end");
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

//    public static void main(String[] args) throws ExecutionException, InterruptedException {
//
//        FutureTask<Integer> ft = new FutureTask<>(() -> {
//            int i;
//            for (i = 0; i < 10; i += 2) {
//                System.out.println(Thread.currentThread().getName() + "-" + i);
//            }
//            return i;
//        });
//        new Thread(ft, "有返回值的线程").start();
//        System.out.println("子线程的返回值" + ft.get());
//    }

//    public static void main(String[] args) {
//
//        // final Object lock = new Object();
//        final Lock lock = new ReentrantLock();
//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//                System.out.println("thread A is waiting to get lock");
//                synchronized (lock) {
//                    try {
//                        System.out.println("thread A get lock");
//                        TimeUnit.SECONDS.sleep(3);
//                        System.out.println("thread A do wait method");
//                        lock.wait();
//                        System.out.println("wait end");
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
//                }
//            }
//        }).start();
//
//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//                System.out.println("thread B is waiting to get lock");
//                synchronized (lock) {
//                    System.out.println("thread B get lock");
//                    try {
//                        TimeUnit.SECONDS.sleep(5);
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
//                    System.out.println("thread B do notify method");
//                    lock.notify();
//                    System.out.println("thread A will be alive in five seconds");
//                    try {
//                        TimeUnit.SECONDS.sleep(5);
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
//
//                }
//                try {
//                    System.out.println("thread B aready notify thread A");
//                    TimeUnit.SECONDS.sleep(5);
//                    System.out.println("特么我睡醒了");
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//            }
//        }).start();
//    }

}
