
#常见问题

常见的同步辅助类功能和相互区别

AQS:abstractQueuedSynchronizer
   1.使用node实现FIFO,可以用于构建锁或者其他同步装置的基础框架
   2.利用int类型表示状态
   3.基于AQS有一个同步组件ReentrantLock实现
   4.使用方法是继承，子类通过继承并实现他的方法管理其状态{acquire 和 release}的方法来操纵状态
   5.AQS可以同时实现排他锁和共享锁（独占和共享）



1.CountDownLatch：
    类功能：
           CountLatch是一个同步辅助类，
           给定一个计数器，原子操作，调用await()方法会阻塞进程，线程调用countDown，
           使计数器的值减1，直到计数器值为0，才执行接下来的步骤
    常用方法：
        countDownLatch.countDown(); //计数减1
        countDownLatch.await();     //同步阻塞无限等待
        countDownLatch.await(10, TimeUnit.MILLISECONDS);//指定同步等待时间，超时后取消等待

2.CyclicBarrier：
    类功能：
            CyclicBarrier是一个同步辅助类
            允许一组线程相互等待，通过它可以完成多线程之间的相互等待，只有当每个线程都准备就绪后才能各自继续往下操作
    常用方法：
        barrier.await();//线程之间相互等待，直到给定的所有线程都准备就绪才开始往下执行
        barrier.await(2000, TimeUnit.MILLISECONDS);//指定等待时间
        CyclicBarrier(int parties, Runnable barrierAction);//设置回调，当指定数量的线程执行完成后，执行回调方法

#CountDownLatch与CyclicBarries对比：
     1.CyclicBarrier 计数器可以通过reset方法重复使用，CountDownLatch计数器只能使用一次
     2.CountDownLatch实现一个或者n个线程需要等待其他线程完成某项操作后才能继续往下执行，CyclicBarrier 实现多个线程之间相互等待

3.Semaphore：
   类功能：信号量，可以控制并发数量的个数，通过链表实现数量控制，常用于仅能提供有限访问的，比如数据库连接数
   常用方法：
        semaphore.acquire(); //获取一个许可
        semaphore.acquire(3); //获取多个许可
        semaphore.tryAcquire(); //尝试获取一个许可
        semaphore.tryAcquire(5000, TimeUnit.MILLISECONDS); //尝试获取一个许可
        semaphore.release(); //释放一个许可





