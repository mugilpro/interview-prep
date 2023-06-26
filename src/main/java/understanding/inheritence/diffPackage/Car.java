package understanding.inheritence.diffPackage;

public class Car {
    public static void main(String[] args) {
        Cat c = new Cat();
//        A protected member inherited by a subclass from another package is
//        not accessible to any other class in the subclass package, except for the
//        subclass' own subclasses

//        System.out.println(c.code);
    }
}
