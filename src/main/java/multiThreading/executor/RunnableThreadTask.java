package multiThreading.executor;

import java.util.concurrent.Callable;

public class RunnableThreadTask implements Runnable {
    private String stateName;

    public RunnableThreadTask(String stateName) {
        this.stateName = stateName;
    }



    @Override
    public void run() {
        System.out.println("completing thread: " + this.stateName);    }
}
