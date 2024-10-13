package thread;

public class FirstThreadTest {
    public static void main(String[] args) {
        FirstThread t = new FirstThread();
        t.start();
    }
}

class FirstThread extends Thread{
    public void run() {
        System.out.println("Thread 클래스 상속");
    }
}
