package thread.procon;

import java.util.Queue;

public class Consumer extends Thread {
    ThreadGroup group;
    Queue<Integer> q;
    int number;

    public Consumer(ThreadGroup g,Queue<Integer> q, int i) {
        this.group = g;
        this.q = q;
        this.number = i;
    }

    @Override
    public void run() {
        int item;
        int totalItem = 0;
        while (!Thread.currentThread().isInterrupted()) {
            synchronized (q) {
                if (q.peek() == null) {
                    try {
                        System.out.println("\t 소비자 " + number + "대기");
                        q.wait();
                    } catch (InterruptedException e) {
                        System.out.println("\t 소비자 " + number + " 총 누적 소비: " + totalItem);
                        Thread.currentThread().interrupt();
                    }
                } else {
                    item = q.poll();
                    System.out.println("\t 소비 : " + item);
                    totalItem++;
                }
            }
        }
    }
}
