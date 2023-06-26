package multiThreading;

public class ThreadTask implements Runnable{
    private String stateName;

    public ThreadTask(String stateName) {
        this.stateName = stateName;
    }

    public void run(){

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        int size = this.stateName.length();
        synchronized (JoinDemonAndThreadCompletionOrder.class){
            JoinDemonAndThreadCompletionOrder.totalCount += size*size;
        }

        System.out.println("completing thread: " + this.stateName);
    }
}