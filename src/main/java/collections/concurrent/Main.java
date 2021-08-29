package collections.concurrent;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class Main {

    public static void main(String[] args) {
        List<Integer> intList = new ArrayList<>();
        intList.add(1);
        intList.add(2);
        intList.add(3);
        intList.forEach(i-> {
           if(i == 2) intList.add(4);
            System.out.println(i);
        });

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
            System.out.println(i);

        }
        intCOWList.forEach(i-> {
            if(i == 2){
                intCOWList.add(4);
            }
            System.out.println(i);
        });
    }
}
