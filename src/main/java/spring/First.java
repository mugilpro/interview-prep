package spring;

public class First {
    private Second second;
    public First(Second second) {
        System.out.println("creating first");
    }

    public Second getSecond() {
        System.out.println("second getting second");
        return second;
    }

    public void setSecond(Second second) {
        System.out.println("second setting second");
        this.second = second;
    }
}
