package collections;

import java.math.BigDecimal;
import java.util.*;
import java.util.function.Consumer;
import java.util.stream.Stream;

//Condition                                              Required                        Not Required (But Allowed)
//        x.equals(y) == true               x.hashCode() == y.hashCode()
//        x.hashCode() == y.hashCode()                                                    x.equals(y) == true
//        x.equals(y) == false                                                            no hashCode() requirements
//        x.hashCode() != y.hashCode()          x.equals(y) == false


public class Student {
    private String stateCode;
    private String collegeCode;
    private Long seqId;
    private BigDecimal feeDue;

    public Student() {
    }

    public Student( String stateCode, String collegeCode,Long seqId, BigDecimal feeDue) {
        this.collegeCode = collegeCode;
        this.stateCode = stateCode;
        this.seqId = seqId;
        this.feeDue = feeDue;
    }

    public static void main(String[] args) {
        HashSet set1 =   new HashSet();
        set1.add(new Student("KA", "C001", 1l, BigDecimal.valueOf(100l)));
        set1.add(new Student("MH", "C001", 1l, BigDecimal.valueOf(100l)));
        set1.add(new Student("KA", "C002", 1l, BigDecimal.valueOf(100l)));
       ArrayList s =   new ArrayList();//new TreeSet<Object>();
//        s.add //Object e  = new Student();
        Stream t = s.stream();
       s.add(new Student());
       t.forEach(stu-> {
           Student st = (Student)stu;
           st.setCollegeCode("1"
           );
       });
Consumer c = new Consumer(){
    @Override
    public void accept(Object o) {
        Student st = (Student)o;
        st.setCollegeCode("1");
    }
};
        System.out.println(((Student)s.get(0)).getCollegeCode());
    }
    public String getStateCode() {
        return stateCode;
    }
    public void setStateCode(String stateCode) {
        this.stateCode = stateCode;
    }
    public String getCollegeCode() {
        return collegeCode;
    }
    public void setCollegeCode(String collegeCode) {
        this.collegeCode = collegeCode;
    }
    public Long getSeqId() {
        return seqId;
    }
    public void setSeqId(Long seqId) {
        this.seqId = seqId;
    }
    public BigDecimal getFeeDue() {
        return feeDue;
    }
    public void setFeeDue(BigDecimal feeDue) {
        this.feeDue = feeDue;
    }
//
//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//        Student student = (Student) o;
//        return Objects.equals(collegeCode, student.collegeCode) && Objects.equals(stateCode, student.stateCode) && Objects.equals(seqId, student.seqId);
//    }
//
//    @Override
//    public int hashCode() {
//        return Objects.hash(collegeCode, stateCode, seqId);
//    }
}

//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//        collections.Student student = (collections.Student) o;
//        return Objects.equals(collegeCode, student.collegeCode) && Objects.equals(stateCode, student.stateCode) && Objects.equals(seqId, student.seqId) && Objects.equals(due, student.due);
//    }
//
//    @Override
//    public int hashCode() {
//        return Objects.hash(collegeCode, stateCode, seqId, due);
//    }

//

//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//        collections.Student student = (collections.Student) o;
//        return collegeCode.equals(student.collegeCode) && stateCode.equals(student.stateCode) && seqId.equals(student.seqId);
//    }
//
//    @Override
//    public int hashCode() {
//        return Objects.hash(collegeCode, stateCode, seqId);
//    }