package www.j1stiot.cn.thread.resources;

/**
 * Different between start() and run()
 */
public class StartAndRunDemo extends Thread{

    @Override
    public void run() {
        System.out.print("run");
        super.run();
    }
}
