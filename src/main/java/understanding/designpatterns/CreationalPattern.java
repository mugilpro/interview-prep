package understanding.designpatterns;


//When object is created based on certain logic not explict saying what object of a single family tree
public class CreationalPattern {
    public static void main(String[] args) {
        new ShapesFactory().create("4").print(); //Factory pattern
        //Abstract factory pattern - Factory of Factories
        System.out.println(FactoryBuilder.getFactory("animal").create("CARNIVORES"));
        //Builder pattern
        System.out.println(Employee.builder().withId(1).withName("Hello").build());
    }
}

interface Shape {
    public void print();
}

class Triangle implements Shape {
    public void print(){
        System.out.println("Triangle");
    }
}

class Square implements Shape {
    public void print(){
        System.out.println("Square");
    }
}
class Pentagon implements Shape {
    public void print(){
        System.out.println("Pentagon");
    }
}

class ShapesFactory extends Factory<Shape>{
    public Shape create(String sides) {
        if (sides.equals("3")) return new Triangle();
        if (sides.equals("4")) return new Square();
        if (sides.equals("5")) return new Pentagon();
        return null;
    }


}

    interface Animal {
        public void print();
    }

    class Lion implements Animal {
        public void print(){
            System.out.println("Lion");
        }
    }

    class Human implements Animal {
        public void print(){
            System.out.println("Human");
        }
    }

    class Deer implements Animal {
        public void print(){
            System.out.println("Deer");
        }
    }

    class AnimalFactory extends Factory<Animal>{


        public Animal create(String type) {
            if (type.equals("CARNIVORES")) return new Lion();
            if (type.equals("HERBIVORES")) return new Deer();
            if (type.equals("OMNIVORES")) return new Human();
            return null;
        }
    }

    abstract class Factory<T> {
           public abstract T create(String type);
        }
    class FactoryBuilder{
    public static final Factory getFactory(String type){
        if(type.equals("shape")) return new ShapesFactory();
        if(type.equals("animal")) return new AnimalFactory();
        return null;
    }
    }

     class Employee{
         String name;
         int id;

    public Employee(String name, int id ){
        this.id = id;
        this.name = name;
    }
    public static EmployeeBuilder builder(){
        return new EmployeeBuilder();
    }

    public String toString(){
        return this.name + " - "+this.id;
    }

    static class EmployeeBuilder{
    String name;
    int id;
    public EmployeeBuilder withName(String name){
        this.name = name;
        return this;
    }
    public EmployeeBuilder withId(int id){
        this.id = id;
        return this;
    }
    public Employee build(){
        return new Employee(name,id);
    }
    }

    }

