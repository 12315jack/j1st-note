package www.j1stiot.cn.thread.resources;

import java.util.concurrent.Callable;

/**
 * create thread by implements Callable interface
 *
 */
public class CallableDemo implements Callable{
    @Override
    public String call() throws Exception {
        System.out.println(" create thread by implements Callable interface");
        return "OK";
    }
}
