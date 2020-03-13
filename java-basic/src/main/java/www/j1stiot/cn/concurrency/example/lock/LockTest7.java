package www.j1stiot.cn.concurrency.example.lock;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

public class LockTest7 {

    // logger
    private static final Logger logger = LoggerFactory.getLogger(LockTest7.class);

    private static final ReentrantLock lock=new ReentrantLock(true);

    public static void main(String[] args) {
        new Thread(() ->test(),"线程A").start();
        new Thread(() ->test(),"线程B").start();
    }

    public static void test(){
        try{
            lock.lock();
            logger.info(Thread.currentThread().getName()+"获取了锁");
            TimeUnit.SECONDS.sleep(5);
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            logger.info(Thread.currentThread().getName()+"释放了锁");
            lock.unlock();
        }
    }

}
