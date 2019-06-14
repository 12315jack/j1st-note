

java 虚拟机：

常用监控命令：

    1.jps:
        Java版的ps命令，查看java进程及其相关的信息，如果你想找到一个java进程的pid，那可以用jps命令替代linux中的ps命令了，简单而方便。

    2.jinfo:
        是用来查看JVM参数和动态修改部分JVM参数的命令

    3.jstat:
        是JDK自带的一个轻量级工具，主要用JVM内建的指令对java应用程序的资源和性能进行实时的监控

    4.jstack:
        jstack是用来查看JVM线程快照的命令，线程快照是当前JVM线程正在执行的方法堆栈集合。
        使用jstack命令可以定位线程出现长时间卡顿的原因，例如死锁，死循环等。
        jstack还可以查看程序崩溃时生成的core文件中的stack信息。

    5.jmap:
        jmap是用来生成堆dump文件和查看堆相关的各类信息的命令，例如查看finalize执行队列，heap的详细信息和使用情况

    6.jhat:
        jhat是用来分析jmap生成dump文件的命令，jhat内置了应用服务器，可以通过网页查看dump文件分析结果，jhat一般是用在离线分析上
