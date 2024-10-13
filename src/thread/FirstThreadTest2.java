package thread;

public class FirstThreadTest2 {
    public static void main(String[] args) {
        Thread t = new Thread(new FirstThread2());
        t.start();
    }
}

class FirstThread2 implements Runnable {

    @Override
    public void run() {
        System.out.println("Runnable 인터페이스 구현");
    }
}
