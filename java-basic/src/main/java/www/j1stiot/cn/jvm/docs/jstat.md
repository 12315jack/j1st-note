

#jvm jstat 使用方法:

    Jstat是JDK自带的一个轻量级工具，主要用JVM内建的指令对java应用程序的资源和性能进行实时的监控。

    基本语法

    　　jstat <option> [-t] [-h] <pid>  <interval> <count>

    　　参数解释：

    option 可以从下面参数中选择:
        -class              显示ClassLoad的相关信息；
        -compiler           显示JIT编译的相关信息；
        -gc                 显示和gc相关的堆信息；
        -gccapacity         显示各个代的容量以及使用情况；
        -gccause            显示垃圾回收的相关信息（通-gcutil）,同时显示最后一次或当前正在发生的垃圾回收的诱因；
        -gcnew              显示新生代信息；
        -gcnewcapacity      显示新生代大小和使用情况；
        -gcold              显示老年代和永久代的信息；
        -gcoldcapacity      显示老年代的大小；
        -gcpermcapacity     显示永久代的大小；
        -gcutil             显示垃圾收集信息；
        -printcompilation   输出JIT编译的方法信息；
        -t                  可以在打印的列加上Timestamp列，用于显示系统运行的时间
        -h                  可以在周期性数据数据的时候，可以在指定输出多少行以后输出一次表头

    interval 执行每次的间隔时间，单位为毫秒

    count     用于指定输出多少次记录，缺省则会一直打印

    使用说明:
        首先我们 使用linux命令 ps -ef|grep resin 查看我要监视进程的pid 23814

    1、-class （jstat -class pid 1000 5 查看pid为23814的ClassLoad相关信息，每秒钟打印一次，总共打印5次）

            Loaded 加载类的数量
            Bytes 加载类合计大小
            Unloaded 卸载类的数量
            Bytes 卸载类合计大小
            Time 表示加载和卸载类总共的耗时
            加载了9276个类，总大小为18045.9byte 卸载类0个，总大小为0byte,卸载和加载总耗时9.24ms

    2、-compiler （Jstat -cpmpiler pid）

            Compiled 表示编译任务执行的次数
            Failed 表示编译失败的次数
            Invalid 表示编译不可用的次数
            Time 表示编译的总耗时
            FailedType 表示最后一次编译的类型
            FailedMethod 表示最后一次编译失败的类名和方法名


    3、-gc (jstat -gc pid 1000 5 )

            S0C: Survivor0(幸存区0)大小（KB）
            S1C: Survivor1(幸存区1)1大小（KB）
            S0U: Survivor0(幸存区0)已使用大小（KB）
            S1U: Survivor1(幸存区1)已使用大小（KB）
             EC: Eden（伊甸区）大小（KB）
             EU: Eden（伊甸区）已使用大小（KB）
             OC: 老年代大小（KB）
             OU: 老年代已使用大小（KB）
             MC：方法区大小
             MU：方法区使用大小
             PC: Perm永久代大小（KB）
             PU: Perm永久代已使用大小（KB）
            YGC: 新生代GC个数
           YGCT: 新生代GC的耗时（秒）
            FGC: Full GC次数
           FGCT: Full GC耗时（秒）
            GCT: GC总耗时（秒）　


    4、-gccapacity(jstat -gccapacity pid：显示各个代的容量的信息)

            NGCMN：新生代最小值（KB）
            NGVMX：新生代最大值（KB）
              NGC：当前新生代大小（KB）
              S0C：同上
              S1C：同上
               EC：同上
            OGCMN：老年代最小值（KB）
            OGCMX：老年代最大值（KB）
              OGC：当前老年代大小（KB）
               OC：同上
            PGCMN：永久代最小值（KB）
            PGCMX：永久代最大值（KB）
              PGC：当前永久代大小（KB）
               PC：同上
              YGC：同上
              FGC：同上

    5、-gccause(jstat -gccause pid:显示最近一次GC的原因)

            LGCC：上一次GC的原因，是G1垃圾回收器回收
            GCC ：当前GC的原因

    6、-gcnew (jstat -gcnew pid：显示新生代的详细信息)

            TT:新生代到老年代的年龄；
            MTT:新生代到老年代的最大年龄；
            DSS:所需的survivor的大小；

    7、-gcnewcapacity(jstat -gcnewcapacity pid:输出新生代各个区的详细信息)

            S0CMX:S0最大空间大小（KB）
            S1CMX:S1最大空间大小（KB）
            ECMX:Eden最大空间大小（KB）
            NGCMX:年轻代最大空间大小（KB）

    8、-gcold(jstat -gcold pid:显示老年代GC的详细情况)

    　　
    9、-gcoldcapacity(jstat -gcoldcapacitp pid:输出老年代的详细信息)

    　　
    10、-gcutil(jstat -gcutil pid:查看每个代区域使用的百分比情况)

            S0：年轻代中第一个survivor（幸存区）已使用的占当前容量百分比
            S1：年轻代中第二个survivor（幸存区）已使用的占当前容量百分比
             E：年轻代中Eden（伊甸园）已使用的占当前容量百分比
             O：老年代使用比例
             M：元数据区使用比例
           CCS：压缩使用比例
           YGC：年轻代垃圾回收次数
           FGC：老年代垃圾回收次数
           FGCT：老年代垃圾回收消耗时间
           GCT：垃圾回收消耗总时间

    　



