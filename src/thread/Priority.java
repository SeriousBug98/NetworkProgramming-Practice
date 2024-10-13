package thread;

public class Priority extends Thread {
    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println(getName() + " : " + i);
        }
    }

    public static void main(String[] args) {
        Priority t1 = new Priority();
        Priority t2 = new Priority();
        t1.setPriority(MAX_PRIORITY);
        t2.setPriority(MIN_PRIORITY);
        t1.start();
        t2.start();
    }
}
