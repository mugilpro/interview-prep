package exception;

import java.io.Closeable;
import java.io.IOException;

public class SupperresExceptionAndTryWithResource {
    public static void main(String[] args) {
        try {
            try (ClosableClass closableClass = new ClosableClass()) {
                System.out.println("try");
                throw new RuntimeException("Inside try");
            } catch (Exception e){
                // We will get suppressed exception here from finally block
                System.out.println("catch");
                System.out.println(e.getMessage() + ":" +e.getSuppressed()[0].getMessage() + ":" + e.getSuppressed().length);
                throw new RuntimeException("Inside catch");
            }finally {
                System.out.println("finally");
                throw new RuntimeException("Inside finally");
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println(e.getSuppressed().length);
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