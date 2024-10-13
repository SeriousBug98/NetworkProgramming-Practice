package thread;

public class DaemonThread extends Thread {
    public void run() {
        try {
            Thread.sleep(200);
        } catch (InterruptedException e) {}
        System.out.println("스레드 작동 중");
    }

    public static void main(String[] args) {
        DaemonThread t = new DaemonThread();
        t.setDaemon(true);
        t.start();
        System.out.println("메인 함수 종료");
    }
}
