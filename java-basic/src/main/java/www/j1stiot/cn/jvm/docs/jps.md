
#jvm jps 用法:
    Java版的ps命令，查看java进程及其相关的信息，如果你想找到一个java进程的pid，那可以用jps命令替代linux中的ps命令了，简单而方便。
    命令格式：

    jps [options] [hostid]

    options参数解释：
        -l : 输出主类全名或jar路径
        -q : 只输出LVMID
        -m : 输出JVM启动时传递给main()的参数
        -v : 输出JVM启动时显示指定的JVM参数

    最常用示例：
        1.jps -l 输出jar包路径，类全名
        2.jps -m 输出main参数
        3.jps -v 输出JVM参数

    例子：
        '''
        root@iZuf6fs05owv18qnxn8t75Z:/home/application/M2M/smart-charger-m2m-1.0.0-SNAPSHOT# jps
        21779 SmartChargerM2M
        26667 Jps
        '''