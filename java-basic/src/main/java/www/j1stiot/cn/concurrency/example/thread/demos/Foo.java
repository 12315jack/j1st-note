package www.j1stiot.cn.concurrency.example.thread.demos;

import java.util.concurrent.CountDownLatch;

/**
 * 多线程保证线程执行顺序例子
 */
public class Foo {

    //控制变量
    private int flag = 1;

    public Foo() {
    }

    public void first(Runnable printFirst) throws InterruptedException {
        synchronized (this){
            //如果flag不为1则让first线程等待，while循环控制first线程如果不满住条件就一直在while代码块中，防止出现中途跳入，执行下面的代码，其余线程while循环同理
            while( flag != 1){
                this.wait();
            }

            printFirst.run();
            //定义成员变量为 2
            flag = 2;
            //唤醒其余所有的线程
            this.notifyAll();
        }
    }
    public void second(Runnable printSecond) throws InterruptedException {
        synchronized (this){
            //如果成员变量不为2则让二号等待
            while (flag != 2){
                this.wait();
            }
            // printSecond.run() outputs "second". Do not change or remove this line.
            printSecond.run();
            //如果成员变量为 2 ，则代表first线程刚执行完，所以执行second，并且改变成员变量为 3
            flag = 3;
            //唤醒其余所有的线程
            this.notifyAll();
        }
    }
    public void third(Runnable printThird) throws InterruptedException {
        synchronized (this){
            //如果flag不等于3 则一直处于等待的状态
            while (flag != 3){
                this.wait();
            }
            // printThird.run() outputs "third". Do not change or remove this line.
            //如果成员变量为 3 ，则代表second线程刚执行完，所以执行third，并且改变成员变量为 1
            printThird.run();
            flag = 1;
            this.notifyAll();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Foo foo=new Foo();

        foo.first(new Runnable() {
            @Override
            public void run() {
                System.out.print("first");
            }
        });

        foo.second(new Runnable() {
            @Override
            public void run() {
                System.out.print("second");
            }
        });

        foo.third(new Runnable() {
            @Override
            public void run() {
                System.out.print("third");
            }
        });
    }
}


//解法二：CountDownLatch
//public class Foo {
//    //声明两个 CountDownLatch变量
//    private CountDownLatch countDownLatch01;
//    private CountDownLatch countDownLatch02;
//
//    public Foo() {
//        //初始化每个CountDownLatch的值为1，表示有一个线程执行完后，执行等待的线程
//        countDownLatch01 = new CountDownLatch(1);
//        countDownLatch02 = new CountDownLatch(1);
//    }
//    public void first(Runnable printFirst) throws InterruptedException {
//        //当前只有first线程没有任何的阻碍，其余两个线程都处于等待阶段
//        // printFirst.run() outputs "first". Do not change or remove this line.
//        printFirst.run();
//        //直到CountDownLatch01里面计数为0才执行因调用该countDownCatch01.await()而等待的线程
//        countDownLatch01.countDown();
//    }
//    public void second(Runnable printSecond) throws InterruptedException {
//        //只有countDownLatch01为0才能通过，否则会一直阻塞
//        countDownLatch01.await();
//        // printSecond.run() outputs "second". Do not change or remove this line.
//        printSecond.run();
//        //直到CountDownLatch02里面计数为0才执行因调用该countDownCatch02.await()而等待的线程
//        countDownLatch02.countDown();
//    }
//    public void third(Runnable printThird) throws InterruptedException {
//        //只有countDownLatch02为0才能通过，否则会一直阻塞
//        countDownLatch02.await();
//        // printThird.run() outputs "third". Do not change or remove this line.
//        printThird.run();
//    }
//
//    public static void main(String[] args) throws InterruptedException {
//        Foo foo=new Foo();
//
//        foo.first(new Runnable() {
//            @Override
//            public void run() {
//                System.out.print("first");
//            }
//        });
//
//        foo.second(new Runnable() {
//            @Override
//            public void run() {
//                System.out.print("second");
//            }
//        });
//
//        foo.third(new Runnable() {
//            @Override
//            public void run() {
//                System.out.print("third");
//            }
//        });
//    }
//
//}

//解法三：Semaphore（信号量）
//Semaphore与CountDownLatch相似，不同的地方在于Semaphore的值被获取到后是可以释放的，并不像CountDownLatch那样一直减到底
//获得Semaphore的线程处理完它的逻辑之后，你就可以调用它的Release()函数将它的计数器重新加1，这样其它被阻塞的线程就可以得到调用了
//public class Foo03 {
//    //声明两个 Semaphore变量
//    private Semaphore spa,spb;
//    public Foo03() {
//        //初始化Semaphore为0的原因：如果这个Semaphore为零，如果另一线程调用(acquire)这个Semaphore就会产生阻塞，便可以控制second和third线程的执行
//        spa = new Semaphore(0);
//        spb = new Semaphore(0);
//    }
//    public void first(Runnable printFirst) throws InterruptedException {
//        // printFirst.run() outputs "first". Do not change or remove this line.
//        printFirst.run();
//        //只有等first线程释放Semaphore后使Semaphore值为1,另外一个线程才可以调用（acquire）
//        spa.release();
//    }
//    public void second(Runnable printSecond) throws InterruptedException {
//        //只有spa为1才能执行acquire，如果为0就会产生阻塞
//        spa.acquire();
//        // printSecond.run() outputs "second". Do not change or remove this line.
//        printSecond.run();
//        spb.release();
//    }
//    public void third(Runnable printThird) throws InterruptedException {
//        //只有spb为1才能通过，如果为0就会阻塞
//        spb.acquire();
//        // printThird.run() outputs "third". Do not change or remove this line.
//        printThird.run();
//    }
//}

