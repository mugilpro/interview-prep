package understanding;


// A simple Java program to demonstrate multiple
// inheritance through default methods.
interface TestInterface1
{
    int val=1;
    // default method
    default void show()
    {
        System.out.println("Default TestInterface1");
    }
}

interface TestInterface2
{
    int val=2;
    // Default method
    default void show()
    {
        System.out.println("Default TestInterface2");
    }
}

//// Implementation class code
//public class DefaultConstructor implements TestInterface1, TestInterface2
//{
////    // Overriding default show method
////    public void show()
////    {
////        // use super keyword to call the show
////        // method of TestInterface1 interface
////        TestInterface1.super.show();
////
////        // use super keyword to call the show
////        // method of TestInterface2 interface
////        TestInterface2.super.show();
////    }
//
//    public static void main(String args[])
//    {
//        DefaultConstructor d = new DefaultConstructor();
//        d.show();
//        TestInterface1 t1 = new DefaultConstructor();
//
//        System.out.println(t1.val);
//    }
//}