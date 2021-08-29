package lambda;


import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class MainClass {
    //Stream to get user belong to TN
    public static void main(String[] args) {
        StudentDetail student = new StudentDetail("TN","ENG001",1L,new BigDecimal("20"));
        StudentDetail student1 = new StudentDetail("KL","ENG001",1L,new BigDecimal("10"));
        StudentDetail student2 = new StudentDetail("KA","ENG001",1L,new BigDecimal("30"));
        List<StudentDetail> students = new ArrayList<>();
        students.add(student);
        students.add(student1);
        students.add(student2);
        String value = students.stream().map(s-> s.getStateCode()).reduce("",(partialResult, code)-> partialResult + code);
        System.out.println(value);
        String value1 = students.stream().reduce("",(partialResult, s)-> partialResult + s.getStateCode(),String::concat);
        System.out.println(value1);
    }

}
