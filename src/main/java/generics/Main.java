package generics;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String args[]){
        List withNoType = new ArrayList<String>();
        List<String>  withType= new ArrayList();
//        withType.add(Integer.valueOf(2))//
        withNoType.add(Integer.valueOf(2));

//Is-A Assignment not possible.
        List< Number> numbers = new ArrayList<Number>();

//        List< Number> intNumbers = new ArrayList<Integer>();
//        List< Number> floatNumbers = new ArrayList<Float>();
        numbers.add(Integer.valueOf(1));
        numbers.add(Float.valueOf(1));
        System.out.println(numbers.get(0));
//Is-A Assignment possible with extends but add operation not possible
        List<? extends Number> numbersExtend = new ArrayList<Number>();
        List<? extends Number> intNumbersExtend = new ArrayList<Integer>();
        List<? extends Number> floatNumbersExtend = new ArrayList<Float>();

//        numbersExtend.add(Integer.valueOf(1));
//        java: incompatible types: java.lang.Integer cannot be converted to capture#1 of ? extends java.lang.Number
//        intNumbers.add(Integer.valueOf(1));
//        java: incompatible types: java.lang.Integer cannot be converted to capture#1 of ? extends java.lang.Number
        Object o =new Object();
        //java.lang.Object cannot be converted to capture#1 of ? extends java.lang.Number
//        intNumbers.add(o);

        Number value = numbersExtend.get(0);
        Number intValue = intNumbersExtend.get(0);
        Number floatValue= floatNumbersExtend.get(0);
//        Integer intValue = intNumbersExtend.get(0);
//        Float floatValue= floatNumbersExtend.get(0);
//
    }
}
