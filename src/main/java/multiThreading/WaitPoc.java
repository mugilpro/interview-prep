package multiThreading;


//wait() will release lock
//Thread that is waiting state has to be notified to resume.
public class WaitPoc {
    public static void main(String[] args) {
        WaitPoc lockedObject = new WaitPoc();
        Thread t1 = new Thread( new MyRunnable(lockedObject));
        Thread t2 = new Thread(new MyRunnable(lockedObject));

        t1.start();
        t2.start();
    }

    public synchronized void m1() throws InterruptedException {
        try {
        System.out.println("Sleeping: " + Thread.currentThread().getName());
        Thread.sleep(10000);
        System.out.println("Going to wait: " + Thread.currentThread().getName());
        //wait(2000);
        wait();
        System.out.println("Sleeping completed: " + Thread.currentThread().getName());
        System.out.println("running in thread: " + Thread.currentThread().getName());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}


class MyRunnable implements Runnable{

    public WaitPoc lockedObject;
    public MyRunnable(WaitPoc lockedObject){
        this.lockedObject = lockedObject;
    }
    public void run(){
        try {
            lockedObject.m1();
        } catch (InterruptedException e) {
            System.out.println("Testing");
        }

    }
}