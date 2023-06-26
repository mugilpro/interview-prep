package collections.concurrent;

import java.util.*;

//Tree set always uses comparator for comparison not equals method
//contains also used compareTo rather than equals of the class

public class TreeSetDemo {

    public static void main(String[] args) {

        TreeSet<TreeEmployee> treeSet = new TreeSet<>();
        treeSet.add(new TreeEmployee(1,"Hello"));
        treeSet.add(new TreeEmployee(1,"HelloDiff"));
        System.out.println(treeSet.size());
        treeSet.contains(new TreeEmployee(2,"odff"));

    }

}

class TreeEmployee implements Comparable<TreeEmployee> {
    int id;
    String name;

    public TreeEmployee(int id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public int hashCode(){

        System.out.println("Inside Hashcode");
        return name.hashCode();
    }
    @Override
    public boolean equals(Object o){
        System.out.println("inside equals");
        if(o==null || !(o instanceof TreeEmployee)){
            return false;
        }
        TreeEmployee e = (TreeEmployee) o;
        return Objects.equals(this.id,e.id);
    }

    @Override
    public int compareTo(TreeEmployee o) {
        System.out.println("inside comparator");
        if(this.id == o.id) return 0;
        else if(this.id <= o.id) return -1;
        else return 1;
    }
}
