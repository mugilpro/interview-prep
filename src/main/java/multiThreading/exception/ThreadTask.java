package multiThreading.exception;

public class ThreadTask implements Runnable{
    private String stateName;

    public ThreadTask(String stateName) {
        this.stateName = stateName;
    }

    public void run(){
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        if(stateName!=null) throw new RuntimeException("Test");
        int size = this.stateName.length();
        synchronized (MainClass.class){
            MainClass.totalCount += size*size;
        }
    }
}