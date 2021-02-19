package thread.nomol;

public class WorkThread extends Thread {

    public Counter counter;

    public WorkThread(Counter counter) {
        this.counter = counter;
    }

    @Override
    public void run() {
        super.run();
        while (counter.count<99){
            if (counter !=null){
//                counter.add();
                counter.syncAdd();
            }
        }
    }
}
