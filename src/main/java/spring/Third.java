package spring;

public class Third {

    @Autowired
    private First first;

    public Third() {
        System.out.println("creating third");
    }

    public First getFirst() {
        System.out.println("third getting first");
        return first;
    }

    public void setFirst(First first) {
        System.out.println("third setting first");
        this.first = first;
    }
}
