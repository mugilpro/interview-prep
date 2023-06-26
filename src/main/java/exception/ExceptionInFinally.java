package exception;
//https://www.baeldung.com/java-suppressed-exceptions
//suppressed exception won't add up automatically if it is from finally block we have to add it explicitly
//suppressed exception  add up automatically for exception closable class - try with resource function - refer another example
public class ExceptionInFinally {
    public static void main(String[] args) {
        System.out.println(getValueFromFinally());
        try{
            System.out.println(getValue());
        }catch (Exception e){
            System.out.println(e.getMessage() + "-"+ e.getSuppressed().length);

        }
        try{
            System.out.println(getSuppressedValue());
        }catch (Exception e){
            System.out.println(e.getMessage() + "-"+ e.getSuppressed().length);

        }
    }
    static int getValueFromFinally(){
        try{
        throw new RuntimeException("try");
        }catch (Exception e){
            throw new RuntimeException("catch");
        } finally {
            return 1;
        }
    }

    static int getValue(){
        try{
            throw new RuntimeException("try");
        }catch (Exception e){
            throw new RuntimeException("catch");
        }finally {
            throw new RuntimeException("final");
        }
    }

    static int getSuppressedValue(){
        Throwable firstException = null;
        try{
            throw new RuntimeException("try");
        }catch (Exception e){
            firstException = e;
            throw new RuntimeException("catch");
        }finally {
            try {
                throw new RuntimeException("final");
            } catch (Exception npe) {
                if (firstException != null) {

                    npe.addSuppressed(firstException);
                }
                throw npe;
            }
        }
    }
}
