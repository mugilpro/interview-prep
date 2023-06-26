package understanding.inheritence;

public class Horse extends Animal {
    public static int staticInheritance = 2;
    public void printCode(){
        System.out.println(code);
    }

    public static void main(String[] args) {
        Horse horse = new Horse();
        horse.printCode();
        Animal animal = new Animal();
        Animal animalHorse =new Horse();
//        Use the dot operator to access static members, but remember that using a
//        reference variable with the dot operator is really a syntax trick, and the compiler will substitute the class name for the reference variable, for instance
        System.out.println(horse.staticInheritance);
        System.out.println(animal.staticInheritance);
        System.out.println(animalHorse.staticInheritance);

    }
}
