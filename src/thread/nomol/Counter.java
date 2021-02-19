package thread.nomol;

public class Counter {
    public int count;

    /**
     *非同步自增方法
     */
    public void add(){
        String threadName=Thread.currentThread().getName();
        count++;
        System.out.println("当前执行线程名"+threadName+"当前执行结果："+ count);
    }

    /**
     * 同步自增方法
     */
    public synchronized void syncAdd(){
        String threadName=Thread.currentThread().getName();
        count++;
        System.out.println("当前执行线程名"+threadName+"当前执行结果："+ count);
    }
}
