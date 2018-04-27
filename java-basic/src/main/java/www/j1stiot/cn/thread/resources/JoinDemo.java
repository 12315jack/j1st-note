package www.j1stiot.cn.thread.resources;

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
}
