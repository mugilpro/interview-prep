package multiThreading.executor;


import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;
//The main thread will keep executing if executor service is not shutdown. comment line 31 and 33 for action
//An exception occurred during thread execution will be thrown only at get call. uncomment line 17 in thread task for action
//Cancellation exception if timeout exceeds . Timer is common of all threads. In total 50000 not per thread
public class CallableExecutor {

    public static void main(String[] args) throws InterruptedException, ExecutionException {
        ThreadPoolExecutor executorService = (ThreadPoolExecutor) Executors.newFixedThreadPool(2);
        try {
            CallableThreadTask thread1 = new CallableThreadTask("KERALA");
            CallableThreadTask thread2 = new CallableThreadTask("KARNATAKA");
            CallableThreadTask thread3 = new CallableThreadTask("UTTAR PRADESH");
            CallableThreadTask thread4 = new CallableThreadTask("TAMIL NADU");
            List<Callable<Integer>> callableList = new ArrayList<>();
            callableList.add(thread1);
            callableList.add(thread2);
            callableList.add(thread3);
            callableList.add(thread4);

            List<Future<Integer>> futures = executorService.invokeAll(callableList,50000,TimeUnit.MILLISECONDS);
            int sum = 0;
            for (Future<Integer> future : futures) {
                sum += future.get();
                System.out.println("got result");
            }
            System.out.println(sum);
            executorService.shutdown();
        } finally {
            executorService.shutdown();
        }
    }

}
