package www.j1stiot.cn.thread;

import www.j1stiot.cn.thread.resources.*;

import java.util.concurrent.FutureTask;

/**
 * Thread demo
 *
 * 线程的创建方式：
 *
 *  1.实现 Runnable 接口,覆盖 run() 方法,无返回值
 *
 *  2.继承 Thread 接口,覆盖 run() 方法
 *
 *  3.实现 Callable 接口,覆盖 call() 方法,call方法可以有返回值
 *
 *
 *
 */
public class ThreadApplication {

    public static void main(String[] args) throws Exception {

        // 线程的创建方法
        Thread threadDemo = new ThreadDemo();
        threadDemo.run();

        Thread runnableDemo = new Thread(new RunnableDemo());
        runnableDemo.start();

        // Callable 接口可以有返回值，Runnable接口没有返回值
        FutureTask<String> callableDemo = new FutureTask<String>(new CallableDemo());
        Thread callableThreadDemo = new Thread(callableDemo);
        callableThreadDemo.start();

        // 线程状态（调用join()方法测试）
        Thread thread = new Thread(new JoinDemo());
        thread.start();

        for (int i = 0; i < 5; i++) {

            System.out.println("主线程第: " + i + " 次执行");

            if (i >= 2) {
                try {
                    thread.join();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }

        // 线程调用start()和run()方法的区别
        Thread t=new Thread(new StartAndRunDemo());
        t.run();
        t.start();
        System.out.print("begin");


    }
}
