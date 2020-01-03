package www.j1stiot.cn.concurrency.example.syncContainer;

import www.j1stiot.cn.concurrency.annoations.NotThreadSafe;

import java.util.Vector;

@NotThreadSafe
public class VectorExample2 {

    private static Vector<Integer> vector = new Vector<>();

    public static void main(String[] args) {

        while (true) {

            for (int i = 0; i < 10; i++) {
                vector.add(i);
            }

            Thread thread1 = new Thread() {
                public void run() {
                    for (int i = 0; i < vector.size(); i++) {
                        vector.remove(i);
                    }
                }
            };

            Thread thread2 = new Thread() {
                public void run() {
                    for (int i = 0; i < vector.size(); i++) {
                        vector.get(i);
                    }
                }
            };

            //会跑出数组越界异常，由于多线程中线程执行顺序的问题，同一个位置的元素如果被先remove了，然后在get这个元素就会报数组越界问题
            thread1.start();
            thread2.start();

        }
    }
}
