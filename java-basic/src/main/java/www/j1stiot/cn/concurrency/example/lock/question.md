

#ReentrantLock 与 Synchronized
    1.可重入性
    2.锁的实现：ReentrantLock是基于JDK实现，Synchronized是基于JVM实现的
    3.性能的区别
    4.功能区别：

#ReentrantLock 独有功能
    1.可指定是公平锁还是非公平锁
    2.提供一个Condition类，可以分组唤醒需要唤醒的线程
    3.提供能够中断等待锁的线程机制，lock.lockInterruptibly()
