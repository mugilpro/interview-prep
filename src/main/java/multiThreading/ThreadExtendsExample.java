package multiThreading;
//Thread instantiation using extends
public class ThreadExtendsExample {
    public static void main(String[] args) {
        ThreadProg threadProg =  new ThreadProg();
        threadProg.start();
        }
}

class ThreadProg extends Thread{
    public void run(){
        int i = 0;
        while(i<=50){
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("value: " + i++);
        }
    }

        }