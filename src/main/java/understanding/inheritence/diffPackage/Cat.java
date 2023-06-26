package understanding.inheritence.diffPackage;

import understanding.inheritence.Animal;

public class Cat extends Animal {
    public void printCode(){
        System.out.println(code);
    }

    public static void main(String[] args) {
        Cat c = new Cat();
        System.out.println(c.code);
        Animal a = new Animal();
        Animal ac= new Cat();
//        For a subclass outside the package, the protected member can be accessed only
//        through inheritance.
//        System.out.println(a.code);
//        System.out.println(ac.code);
    }
}
//Abstract Class:
//Helps you to define a common interface for its subclasses
//Abstract class allows code reusability.

//Interface:
//It helps you to achieve loose coupling.