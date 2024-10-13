package thread;

public class ThreadStop2 {
    public static void main(String[] args) {
        RunningThread2 t = new RunningThread2();
        t.start();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        t.interrupt();
    }
}

class RunningThread2 extends Thread {
    public void run() {
        try {
            while (!Thread.currentThread().isInterrupted()) {
                System.out.println("스레드 작동 중");
                Thread.sleep(200);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("스레드 종료");
    }
}
