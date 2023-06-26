package understanding.arrays;

import java.util.ArrayList;

public class Arrays {

    public static void main(String[] args) {
        //need size upfront
        //int[] a = new int[]


        int[] a = new int[5];
        int b[] = new int[5];

//        We've said it before, but it's important enough to repeat: array elements are given
//        their default values (0, false, null, '\u0000', etc.) regardless of whether the array
//        is declared as an instance or local variable
        System.out.println(a[4]);
        //It is enough know the size of first dimension
        int[ ][ ] myArray = new int[3][ ];
        myArray[0] = new int[2];
        myArray[0][0] = 6;
        myArray[0][1] = 7;
        myArray[1] = new int[3];
        myArray[1][0] = 9;
        myArray[1][1] = 8;
        myArray[1][2] = 5;
        //myArray[2] = new Long[4]; won't work

        int[ ][ ][] threeDim = new int[3][ ][];


//Is-A Assignment possible but assignment operation can possibly throw exception at runtime
        Animal[] animals = new Horse[2];
  //      animals[0] = new Animal(); //ArrayStoreException

        //Heterogenous - No Runtime Exception during assignment
        ArrayList<String> stringArrayList = new ArrayList<String>();
        ArrayList list = stringArrayList;
        list.add("a");
        list.add(1);    // OK -  No Runtime Exception until we try to access
        list.add(new Object());
        //Runtime Exception below when casting
//        for(String s: stringArrayList){
//            System.out.println(s);
//        }

        //Homogenous - Runtime Exception during assignment

        Object[] array = new String[3];
        array[0] = "a";
//        array[1] = 1; //Exception in thread "main" java.lang.ArrayStoreException: java.lang.Integer
//        array[1] = Integer.valueOf(1); //Exception in thread "main" java.lang.ArrayStoreException: java.lang.Integer


    }
}
