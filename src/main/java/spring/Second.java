package spring;

public class Second {

    private First first;

    public Second(First first) {
        System.out.println("creating second");
    }

    public First getFirst() {
        System.out.println("second getting first");
        return first;
    }

    public void setFirst(First first) {
        System.out.println("second setting first");
        this.first = first;
    }
}
