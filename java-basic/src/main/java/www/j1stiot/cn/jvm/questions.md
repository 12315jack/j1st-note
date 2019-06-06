

java 虚拟机：

#查看jvm当前虚拟机堆大小限制

    #jinfo -flag MaxHeapSize 6461(PID)
    #linux: java -XX:+PrintFlagsFinal -version 2>&1 | grep MaxHeapSize