package collections.concurrent;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;




public class MapMain {
    public static void main(String[] args) {
        Map<String, Integer> conMap = new ConcurrentHashMap<>();
        MapHelper1 mapHelper1 = new MapHelper1(conMap);
        MapHelper1 mapHelper2 = new MapHelper1(conMap);
        MapHelper1 mapHelper3 = new MapHelper1(conMap);
        MapHelper1 mapHelper4 = new MapHelper1(conMap);

        for (Map.Entry<String, Integer> e : conMap.entrySet()) {
            System.out.println(e.getKey() + "=" + e.getValue());
        }

    }

}
 class MapHelper1 implements Runnable {
    Map<String, Integer> map;

    public MapHelper1(Map<String, Integer> map) {
        this.map = map;
        new Thread(this, "MapHelper1").start();
    }

    public void run() {
        map.put("One", 1);
        try {
            System.out.println("MapHelper1 sleeping");
            Thread.sleep(100);
        } catch (Exception e) {
            System.out.println(e);
        }

    }
}