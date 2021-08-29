package collections;

import java.math.BigDecimal;
import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return Objects.equals(collegeCode, student.collegeCode) && Objects.equals(stateCode, student.stateCode) && Objects.equals(seqId, student.seqId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(collegeCode, stateCode, seqId);
    }
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