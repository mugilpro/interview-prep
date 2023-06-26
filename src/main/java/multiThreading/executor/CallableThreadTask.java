package multiThreading.executor;

import java.util.concurrent.Callable;

public class CallableThreadTask implements Callable<Integer> {
    private String stateName;

    public CallableThreadTask(String stateName) {
        this.stateName = stateName;
    }

    @Override
    public Integer call() throws Exception {
       Thread.sleep(3000);
    //    if(stateName.equals("TAMIL NADU")) throw new RuntimeException("Test");
        System.out.println("completing thread: " + this.stateName);
       return this.stateName.length()*this.stateName.length();
        }
    }
