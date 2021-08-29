package exception;
//https://www.baeldung.com/java-suppressed-exceptions
public class ExceptionInFinally {
    public static void main(String[] args) {
        System.out.println(getValueFromFinally());
        try{
            getValue();
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
        }
    }
}
