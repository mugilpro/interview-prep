package generics;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

public class Main2 {

    public static void main(String[] args) throws InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
//        List<Object> refers only to a List<Object>, while List<?> or
//List<? extends Object> can hold any type of object, but for access only
        List<?> plainList = new ArrayList<String>(); //Access only no modification
        List<Object> objectList = new ArrayList<Object>();
//        List<Object> stringObjectList = new ArrayList<String>();
//
//        plainList.add("test");
        objectList.add("test");


        System.out.println(testing("Hello",String.class));
    }


    public static <T> T testing(T t,Class<T> clazz) throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        return clazz.getDeclaredConstructor(String.class).newInstance("Hello");

    }
}
