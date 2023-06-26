package understanding.innerclass;

public class MyOuter {
    double price;
    // nested class
    class Processor{

        // members of nested class
        double cores;
        String manufacturer;

        double getCache(){
            MyInner myInner = new MyInner();
            return 4.3;
        }
    }

    // nested protected class
    protected class MyInner {

        // members of protected nested class
        double memory;
        String manufacturer;

        double getClockSpeed(){
            return 5.5;
        }
    }

    public static void main(String[] args) {

        // create object of Outer class CPU
        MyOuter mo = new MyOuter();

        // create an object of inner class Processor using outer class
        MyOuter.Processor processor = mo.new Processor();

        // create an object of inner class RAM using outer class CPU
        MyInner myInner = mo.new MyInner();
        System.out.println("Processor Cache = " + processor.getCache());
        System.out.println("Ram Clock speed = " + myInner.getClockSpeed());
    }
}

