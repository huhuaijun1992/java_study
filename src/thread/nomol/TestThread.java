package thread.nomol;


public class TestThread {
    public static void main(String[] args) {
        Counter counter = new Counter();
        WorkThread workThread1 = new WorkThread(counter);
        WorkThread workThread2 = new WorkThread(counter);
        workThread1.start();
        workThread2.start();
    }
}
