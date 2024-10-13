package thread.procon;

import java.util.LinkedList;
import java.util.Queue;

public class ProConEx {
    public static void main(String[] args) {
        Queue<Integer> queue = new LinkedList<Integer>();
        ThreadGroup mainGroup = Thread.currentThread().getThreadGroup();

        Thread proTh = new Producer(mainGroup, queue);
        Thread conTh1 = new Consumer(mainGroup ,queue, 1);
        Thread conTh2 = new Consumer(mainGroup ,queue, 2);
        Thread conTh3 = new Consumer(mainGroup ,queue, 3);
        Thread conTh4 = new Consumer(mainGroup ,queue, 4);
        Thread conTh5 = new Consumer(mainGroup ,queue, 5);

        conTh1.setPriority(1);
        conTh2.setPriority(3);
        conTh3.setPriority(5);
        conTh4.setPriority(8);
        conTh5.setPriority(10);

        proTh.start();
        conTh1.start();
        conTh2.start();
        conTh3.start();
        conTh4.start();
        conTh5.start();

        try {
            Thread.sleep(5000);
            mainGroup.interrupt();
        } catch (InterruptedException e) {

        }
        System.out.println("메인 스레드 종료");
    }
}
