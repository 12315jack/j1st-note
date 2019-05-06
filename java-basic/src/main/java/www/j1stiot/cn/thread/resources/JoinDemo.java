package www.j1stiot.cn.thread.resources;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

/**
 *
 * join()方法测试
 *
 */
public class JoinDemo implements Runnable{

    @Override
    public void run() {
        for(int i=0;i<5;i++){
            System.out.println("线程1第: "+i+" 次执行");
        }
    }

    public static void main(String[] args) {
        Lock lock = new Lock() {
            @Override
            public void lock() {

            }

            @Override
            public void lockInterruptibly() throws InterruptedException {

            }

            @Override
            public boolean tryLock() {
                return false;
            }

            @Override
            public boolean tryLock(long time, TimeUnit unit) throws InterruptedException {
                return false;
            }

            @Override
            public void unlock() {

            }

            @Override
            public Condition newCondition() {
                return null;
            }
        };


    }
}
