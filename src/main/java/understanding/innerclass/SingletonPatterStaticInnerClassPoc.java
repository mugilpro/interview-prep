package understanding.innerclass;

public class SingletonPatterStaticInnerClassPoc {

//    https://www.baeldung.com/java-reflection
//        Goat goat = new Goat("goat");
//    Class<?> goatClass = goat.getClass();
//    Package pkg = goatClass.getPackage();                             - To get package
//    assertEquals("com.baeldung.reflection", pkg.getName());
//    goatClass.getSuperclass()                                         - To get super class
//
//    Constructor<?>[] constructors = goatClass.getConstructors();      - To get constructors // newInstance();
//    Field[] fields = animalClass.getDeclaredFields();                 - To get Fields //getName(); getType() return class<>  ; setAccessible() ; field.getBoolean(bird)
//    Method[] methods = animalClass.getDeclaredMethods();              - To get methods //  setAccessible() ; invoke
//https://www.baeldung.com/java-composition-aggregation-association
    public static void main(String[] args) {
        //Singleton Singleton = new Singleton();
    }
}

//Eager initialization
class SingletonSimple {
    private static SingletonSimple instance = new SingletonSimple();
    private SingletonSimple(){
    }


    public static SingletonSimple getInstance(){
        return instance;
    }


}
//Lazy initialization
class Singleton {

    private Singleton(){
    }

    private static class SingletonHelper{
         static Singleton instance = new Singleton();
    }

    public static Singleton getInstance(){
        return Singleton.SingletonHelper.instance;
    }


}