package understanding.cleaner;

import java.lang.ref.Cleaner;
//Finalize method is deprecated use cleaner method instead
public class CleanerTest {

    public static void main(String[] args) throws InterruptedException {
        System.out.println("Start MyCleanerTest...");
        Cleaner cleaner = Cleaner.create();
        CleanerTest myObject = new CleanerTest();
        cleaner.register(myObject, new MyCleanerRunnable());
        /**
         * This for loop is to force JVM to garbage collect myObject initialization.
         **/
        for (int i = 1; i <= 100000; i++) {
            String[] dummyString = new String[10000];
            try {
                Thread.sleep(1);
                if(i%1000 ==0) System.out.println(i);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.gc();
        Thread.sleep(5000);
        System.out.println("Execution Finished...");
     //   System.out.println("Execution Finished..." + myObject);
    }

    public void cleanerRegistry(CleanerTest cleanerTest, Cleaner cleaner){
        cleaner.register(cleanerTest, new MyCleanerRunnable());
    }
    private static class MyCleanerRunnable implements Runnable {
        public void run() {
            System.out.println("MyCleanerTest cleaning action executed...");
        }
    }


}