package thread.procon;

import java.util.Queue;

public class Producer extends Thread {
    ThreadGroup group;
    Queue<Integer> q;

    public Producer(ThreadGroup g ,Queue<Integer> q) {
        this.group = g;
        this.q = q;
    }

    @Override
    public void run() {
        int item = 1;
        while (!Thread.currentThread().isInterrupted()) {
            synchronized (q) {
                q.offer(item);
                System.out.println("생산 : " + item);
                q.notify();
            }
            try {
                Thread.sleep((int) (Math.random() * 10));
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
            item++;
        }
    }
}
