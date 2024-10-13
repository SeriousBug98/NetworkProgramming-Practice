package thread;

public class JoinThread extends Thread {
    @Override
    public void run() {
        try {
            Thread.sleep(200);
        } catch (InterruptedException e) {}
        System.out.println("스레드 작동 중");
    }

    public static void main(String[] args) {
        JoinThread t = new JoinThread();
        t.start();
        try {
            t.join();
        }  catch (InterruptedException e) {}
        System.out.println("메인 함수 종료");
    }
}
