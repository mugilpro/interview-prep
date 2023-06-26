package collections.concurrent;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;


//Either separate iterator or foreach iterator will throw CME if actual arraylist changes.
//Either separate iterator or foreach iterator will NOT throw CME if actual copyOnArraylist changes.

public class CopyOnWriteArrayListDemo {

    public static void main(String[] args) {

        List<Integer> intCOWList = new CopyOnWriteArrayList<>();
        intCOWList.add(1);
        intCOWList.add(2);
        intCOWList.add(3);
        Iterator<Integer> itr = intCOWList.iterator();
        while (itr.hasNext()){
            int i = itr.next();
            if(i == 2){
                intCOWList.add(4);
            }
            System.out.println("Inside COW iterator"+i);

        }
        intCOWList.forEach(i-> {
            if(i == 2){
                intCOWList.add(4);
            }
            System.out.println("Inside COW "+i);
        });

        List<Integer> intList = new ArrayList<>();

        intList.add(1);
        intList.add(2);
        intList.add(3);
        Iterator<Integer> intListItr = intList.iterator();
        while (intListItr.hasNext()){
            int i = intListItr.next();
            if(i == 2){
                intList.add(4);
            }
            System.out.println("Inside AL iterator"+i);

        }
        intList.forEach(i-> {
            if(i == 2) intList.add(4);
            System.out.println("Inside AL iterator"+i);
        });
    }
}
