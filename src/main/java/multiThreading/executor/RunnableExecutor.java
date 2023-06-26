package multiThreading.executor;


import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

//The main thread will keep executing if executor service is not shutdown. comment line 31 and 33 for action
//An exception occurred during thread execution will be thrown only at get call. uncomment line 17 in thread task for action
//Cancellation exception if timeout exceeds . Timer is common of all threads. In total 50000 not per thread
public class RunnableExecutor {

    public static void main(String[] args) throws InterruptedException, ExecutionException {
        ThreadPoolExecutor executorService = (ThreadPoolExecutor) Executors.newFixedThreadPool(2);
        try {
            Integer i = 0;
            RunnableThreadTask thread1 = new RunnableThreadTask("KERALA");
            RunnableThreadTask thread2 = new RunnableThreadTask("KARNATAKA");
            RunnableThreadTask thread3 = new RunnableThreadTask("UTTAR PRADESH");
            RunnableThreadTask thread4 = new RunnableThreadTask("TAMIL NADU");
            List<Future> futures = new ArrayList<>();
            futures.add(executorService.submit(thread1));
            futures.add(executorService.submit(thread2));
            futures.add(executorService.submit(thread3));
            futures.add(executorService.submit(thread4));
            futures.add(executorService.submit(thread1,i));
            int sum = 0;
            for (Future<Integer> future : futures) {
               // sum += (Integer)future.get();
                System.out.println("result" + future.get());
            }
            System.out.println(sum);
            executorService.shutdown();
        } finally {
            executorService.shutdown();
        }
    }

}
