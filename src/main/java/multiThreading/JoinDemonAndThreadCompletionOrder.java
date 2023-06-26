package multiThreading;

public class JoinDemonAndThreadCompletionOrder {

    //Main thread end will  NOT NOT NOT stop child thread until unless it demon thread. comment four join statement and set demon to true to see action
    //below is example of join statement
    public static int totalCount = 0;
    public static void main(String[] args) throws InterruptedException {
        Thread  thread1  = new Thread(new ThreadTask("KERALA"));
        Thread  thread2  = new Thread(new ThreadTask("KARNATAKA"));
        Thread  thread3  = new Thread(new ThreadTask("UTTAR PRADESH"));
        Thread  thread4  = new Thread(new ThreadTask("TAMIL NADU"));
//        thread1.setDaemon(true);
//        thread2.setDaemon(true);
//        thread3.setDaemon(true);
//        thread4.setDaemon(true);
        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();
        thread1.join();
        System.out.println("join: "+ "KERALA");
        thread2.join();
        System.out.println("join: "+ "KARNATAKA");
        thread3.join();
        System.out.println("join: "+ "UTTAR PRADESH");
        thread4.join();
        System.out.println("join: "+ "TAMIL NADU");
        System.out.println(totalCount);
    }


}
