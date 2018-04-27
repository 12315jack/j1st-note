package www.j1stiot.cn.thread.resources;

/**
 * entity of Thread
 */
public class ThreadDemo extends Thread{

    @Override
    public void run() {
        System.out.println(" create thread by extends Thread class");
    }
}
