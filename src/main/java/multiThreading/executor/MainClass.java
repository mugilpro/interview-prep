package multiThreading.executor;


import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class MainClass {

    public static void main(String[] args) throws InterruptedException, ExecutionException {
        ThreadTask thread1  = new ThreadTask("KERALA");
        ThreadTask  thread2  = new ThreadTask("KARNATAKA");
        ThreadTask  thread3  = new ThreadTask("UTTAR PRADESH");
        ThreadTask  thread4  = new ThreadTask("TAMIL NADU");
        List<Callable<Integer>> callableList = new ArrayList<>();
        callableList.add(thread1);
        callableList.add(thread2);
        callableList.add(thread3);
        callableList.add(thread4);
        ThreadPoolExecutor executorService =(ThreadPoolExecutor) Executors.newFixedThreadPool(2);
        List<Future<Integer>> futures =  executorService.invokeAll(callableList);
        int sum = 0;
        for(Future<Integer> future: futures){
           sum += future.get();
        }
        System.out.println(sum);
       executorService.shutdown();
    }

}
