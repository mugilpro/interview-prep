package generics;

import java.util.ArrayList;
import java.util.List;

public class Main1 {
    public static void main(String args[]) {
        List<? super Integer> numbers = new ArrayList<Number>();
        List<? super Integer> intNumbers = new ArrayList<Integer>();
//        List<? super Integer> floatNumbers = new ArrayList<Float>();
//
        Object value = numbers.get(0);
//        Integer intValue = intNumbers.get(0);
//        Float floatValue = numbers.get(0);
//
        numbers.add(Integer.valueOf(1));
//        numbers.add(Float.valueOf(1));
    }
}
