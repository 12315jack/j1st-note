package www.j1stiot.cn.concurrency.example.thread;

public class InterruptDemo extends Thread {

    @Override
    public void run() {
        super.run();
        for (int i = 0; i < 100; i++) {
            System.out.println("i=" + (i + 1));
        }
    }

    public static void main(String[] args) {
        InterruptDemo thread = new InterruptDemo();
        thread.start();
        try {
            Thread.sleep(2000);
            thread.interrupt();
            System.out.println("是否已经停止 1？=" + Thread.interrupted());
            System.out.println("是否已经停止 2？=" + Thread.interrupted());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("end!");

        Thread.currentThread().interrupt();
        System.out.println("是否停止 1？="+Thread.interrupted());
        System.out.println("是否停止 2？="+Thread.interrupted());
        System.out.println("end!");

    }
}