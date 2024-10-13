package thread;

public class ThreadStop {
    public static void main(String[] args) {
        RunningThread t = new RunningThread();
        t.start();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        t.stopThread();
    }
}

class RunningThread extends Thread {
    boolean stopFlag = false;

    public void run() {
        while (!stopFlag) {
            System.out.println("스레드 작동 중");
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("스레드 종료");
    }

    public void stopThread() {
        stopFlag = true;
    }
}
