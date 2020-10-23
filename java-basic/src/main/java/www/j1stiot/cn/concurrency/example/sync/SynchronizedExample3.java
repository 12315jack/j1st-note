package www.j1stiot.cn.concurrency.example.sync;

/**
 * 同步代码块测试
 */
public class SynchronizedExample3 implements Runnable{

    private static int i=0;

    private synchronized void add(){
        i++;
    }

    @Override
    public void run() {
        for(int i=0;i<1000000;++i){
            add();
        }
    }

    public static void main(String[] args){

        Thread t1=new Thread(new SynchronizedExample3());
        Thread t2=new Thread(new SynchronizedExample3());

        t1.start();
        t2.start();

        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("最终得变量i值为："+i);

    }


}
