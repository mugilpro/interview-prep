package collections.concurrent;

import java.util.HashSet;
import java.util.Objects;

public class HashSetDemo {

    //Same by equals by different hashcode will add two entry. Must obey hascode equals contract

    public static void main(String[] args) {

        HashSet<SetEmployee> hashSet = new HashSet<>();
        hashSet.add(new SetEmployee(1,"Hello"));
        hashSet.add(new SetEmployee(1,"HelloDiff"));
        System.out.println(hashSet.size());
    }

}

class SetEmployee {
    int id;
    String name;

    public SetEmployee(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int hashCode(){
        System.out.println("Inside HashCode");
        return name.hashCode();
    }

    public boolean equals(Object o){
        System.out.println("Inside equals");
        if(o==null || !(o instanceof SetEmployee)){
            return false;
        }
        SetEmployee e = (SetEmployee) o;
        return Objects.equals(this.id,e.id);
    }
}
