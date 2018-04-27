package www.j1stiot.cn.thread.resources;

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
