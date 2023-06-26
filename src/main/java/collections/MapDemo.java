package collections;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class MapDemo {
    public static void main(String[] args) {
        test();
        testDiff();
    }
    public static void test(){

                // Creating an empty Map
                Map<Integer, String> map1 = new HashMap<Integer, String>();
                Map<Integer, String> map2 = new HashMap<Integer, String>();

                // Mapping string values to int keys for map1
                map1.put(10, "Geeks");
                map1.put(15, "4");
                map1.put(20, "Geeks");
                map1.put(25, "Welcomes");
                map1.put(30, "You");

                // Mapping string values to int keys for map2
                map2.put(10, "Geeks");
                map2.put(15, "4");
                map2.put(20, "Geeks");
                map2.put(25, "Welcomes");
                map2.put(30, "You");


                // Displaying the map 1
                System.out.println("First Map: " + map1);

                // Displaying the map 2
                System.out.println("Second Map: " + map2);

                // Displaying the equality
                System.out.println("Equality: " + map1.equals(map2));

                map1.computeIfAbsent(35, k-> {
                    System.out.println();
                    return "10"+"20" +k;});
                // Displaying the map 2
                System.out.println("computeIfAbsent: " + map1);
        map1.putIfAbsent(35,"testing");
        System.out.println("putIfAbsent: " + map1);

        for(Map.Entry<Integer,String> entry : map1.entrySet() ){
            System.out.println("entry set: " + entry.getKey()+ " - "+entry.getValue());
        }

    }
    public static void testDiff(){

        // Creating an empty Map
        Map<Integer, String> map1 = new HashMap<Integer, String>();
        Map<Integer, String> map2 = new HashMap<Integer, String>();

        // Mapping string values to int keys for map1
        map1.put(10, "G");
        map1.put(15, "4");
        map1.put(20, "Geeks");
        map1.put(25, "Welcomes");
        map1.put(30, "You");

        // Mapping string values to int keys for map2
        map2.put(10, "Geeks");
        map2.put(15, "4");
        map2.put(20, "Geeks");
        map2.put(25, "Welcomes");
        map2.put(30, "You");

        // Displaying the map 1
        System.out.println("First Map: " + map1);

        // Displaying the map 2
        System.out.println("Second Map: " + map2);

        // Displaying the equality
        System.out.println("Equality: " + map1.equals(map2));


    }


}
