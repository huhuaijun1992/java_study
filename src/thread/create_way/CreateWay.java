package thread.create_way;


import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

import static java.lang.Thread.sleep;

/**
 * Java多线程的创建方式,官方给的简介里面只有2种
 */
public class CreateWay {
    public static void main(String[] args) {
        try {
//            //实现方式一
//            WorkThread workThread = new WorkThread();
//            //记住Thead要调用start方法，不然就不会启动线程，该对象就是一个普通的对象
//            workThread.start();
//            /*实现方式二*/
//            Thread thread = new Thread(new WorkRunnable());
//            thread.start();
//            /*WorkThread线程调用线程的join方法，main线程会获得WorkThread的线程的对象锁*，调用该对象的wait()，直到该对象唤醒main线程*/
//            workThread.join(1000);

            /*使用Callable的方式配合FutureTask创建线程，调用futuretask的想的get()来获得子线程的执行结束之后的返回值*/
            MyCallable callable = new MyCallable();
            FutureTask<Integer> ft = new FutureTask<>(callable);
            new Thread(ft,"有返回值线程").start();
            int result = ft.get();
            System.out.println("ft的返回值:"+result);
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("======");
    }

    /**
     * 方式一 ：通过继承Thread
     */
    static class WorkThread extends Thread {
        @Override
        public void run() {
            super.run();
            try {
                sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("通过继承thread，重写run()方法实现");
        }
    }

    /**
     * 方式二：
     */
    static class WorkRunnable implements Runnable {

        @Override
        public void run() {
            System.out.println("通过实现Runnable接口实现");
        }
    }

    /**
     * 通过Callable
     */
    static class MyCallable implements Callable<Integer> {

        @Override
        public Integer call() throws Exception {
            int result = 0;
            for (int j = 0; j < 10; j++) {
                result++;
                System.out.println("执行结果：" + result);
                sleep(1000);
            }
            return result;
        }
    }

}


