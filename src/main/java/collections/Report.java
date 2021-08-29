package collections;

public class Report {

    public Report(int rank, String grade) {
        this.rank = rank;
        this.grade = grade;
    }

    private int rank;
    private String grade;

    public int getRank() {
        return rank;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }
}
