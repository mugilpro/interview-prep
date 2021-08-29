package exception;

import java.io.Closeable;
import java.io.IOException;

public class MainClass {
    public static void main(String[] args) {
        try {
            try (ClosableClass closableClass = new ClosableClass()) {
                System.out.println("try");
                throw new RuntimeException("Inside try");
            } catch (Exception e){
                // We will get suppressed exception here from finally block
                System.out.println("catch");
                throw new RuntimeException("Inside catch");
            }finally {
                System.out.println("finally");
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }


    }
}
class ClosableClass implements Closeable{

    @Override
    public void close()  {
        System.out.println("close");
        throw new RuntimeException("Inside close");
    }
}