package thread.atomitic;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * 原子性
 */
public class Atomtic {
    public static void main(String[] args) {
        AtomicInteger a = new AtomicInteger(0);
        System.out.println("结果"+a.get());
        /*增加并且获取新值*/
        a.addAndGet(1);
        System.out.println("a当前的值："+a.get());
        /*设置期望值，更新值*/
        boolean c =a.compareAndSet(2,3);
        System.out.println("期望值和新值执行原子操作执行结果:"+c);

        /*设置新值，并返回旧值*/
        int old=a.getAndSet(5);
        System.out.println("===结果:"+a.get()+"旧值"+old);

    }
}
