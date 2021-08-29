package multiThreading.executor;

import multiThreading.MainClass;

import java.util.concurrent.Callable;

public class ThreadTask implements Callable<Integer> {
    private String stateName;

    public ThreadTask(String stateName) {
        this.stateName = stateName;
    }

    @Override
    public Integer call() throws Exception {
       Thread.sleep(3000);
       return this.stateName.length()*this.stateName.length();
        }
    }
