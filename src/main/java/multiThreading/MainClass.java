package multiThreading;

public class MainClass {
    //Ways to create thread
    //Main thread end will stop child thread
    public static int totalCount = 0;
    public static void main(String[] args) throws InterruptedException {
        Thread  thread1  = new Thread(new ThreadTask("KERALA"));
        Thread  thread2  = new Thread(new ThreadTask("KARNATAKA"));
        Thread  thread3  = new Thread(new ThreadTask("UTTAR PRADESH"));
        Thread  thread4  = new Thread(new ThreadTask("TAMIL NADU"));
        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();
        thread1.join();
        thread2.join();
        thread3.join();
        thread4.join();
        System.out.println(totalCount);
    }


}
