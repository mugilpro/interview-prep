package collections.concurrent;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.IntStream;

//Either separate iterator or foreach iterator will throw CME if actual HashMap changes.
//Either separate iterator or foreach iterator will NOT throw CME if actual ConcurrentHashMap changes.

public class ConcurrentMapMain {
    public static void main(String[] args) throws InterruptedException {

      IntStream.iterate(0,i-> i+1).limit(500).forEach(i-> {
            try {
                System.out.println("Iteration begin:" +  i);
                //normal();
                concurrent();
                System.out.println("Iteration end" +  i);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });    }


    private static void concurrent() throws InterruptedException {
        Map<String, Integer> conMap = new ConcurrentHashMap<>();
        MapHelper1 mapHelper1 = new MapHelper1(conMap,"1");
        MapHelper1 mapHelper2 = new MapHelper1(conMap,"2");
        MapHelper1 mapHelper3 = new MapHelper1(conMap,"3");
        MapHelper1 mapHelper4 = new MapHelper1(conMap,"4");

        for (Map.Entry<String, Integer> e : conMap.entrySet()) {
            System.out.println("[printing]" + conMap.entrySet());
            Thread.sleep(1000);
            System.out.println(e.getKey() + "=" + e.getValue());
        }
    }

    private static void normal() throws InterruptedException {
        Map<String, Integer> conMap = new HashMap<>();
        MapHelper1 mapHelper1 = new MapHelper1(conMap,"1");
        MapHelper1 mapHelper2 = new MapHelper1(conMap,"2");
        MapHelper1 mapHelper3 = new MapHelper1(conMap,"3");
        MapHelper1 mapHelper4 = new MapHelper1(conMap,"4");

        for (Map.Entry<String, Integer> e : conMap.entrySet()) {
            System.out.println("[printing]" + conMap.entrySet());
            Thread.sleep(1000);
            System.out.println(e.getKey() + "=" + e.getValue());
        }
    }

}
 class MapHelper1 implements Runnable {
    Map<String, Integer> map;
    String key;
    public MapHelper1(Map<String, Integer> map,String key) {
        this.map = map;
        this.key = key;
        new Thread(this, "MapHelper1").start();
    }

    public void run() {
        try {
//            if(!key.equals("1")) {
//                Thread.sleep(100);
//                System.out.println(key + " sleeping");
//            }
            map.put(key, 1);
        //    System.out.println("Inserted " + key);

        } catch (Exception e) {
            System.out.println(e);
        }

    }
}