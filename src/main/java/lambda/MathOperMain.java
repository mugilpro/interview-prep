package lambda;

public class MathOperMain {

    public static void main(String[] args) {

        System.out.println(callMathOper((a,b,c) -> {
            if(c.equals("+")){
                return a+b;
            } else {
                return 0;
            }
        }));
    }

    public static int callMathOper(MathsOper m){
        return m.process(3,2,"+");
    }
}
