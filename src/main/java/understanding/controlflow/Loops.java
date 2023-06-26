package understanding.controlflow;

public class Loops {
    public static void main(String[] args) {
        //switch expression can byte, short, int, char , enum (5+), String (7+)
        //case as to literal or if variable then it is has to compile time constant
        switch ("Hello") { //expression
            case "case": //case literal
                System.out.println("case");
            case "Hello":
                System.out.println("hello");
            case "done":
                System.out.println("done");
        }

        //enhanced for loop
        int[] intArr = new int[5];
        for (int a : intArr) {
            System.out.println(a);
        }

        //break - stops entire loop
        //continue - stops current iteration
    }
}
