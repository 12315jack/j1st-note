package www.j1stiot.cn.thread.entity;

/**
 * create thread by implements Runnable interface
 *
 */
public class RunnableDemo implements Runnable{
    @Override
    public void run() {
        System.out.println(" create thread by implements Runnable interface");
    }
}
