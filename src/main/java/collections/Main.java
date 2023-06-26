package collections;

import java.math.BigDecimal;
import java.util.*;

public class Main {
//what is list, map, set
//HashSet vs TreeSet
//HashMap insertion logic

//equals method can be applied to list only after sorting. all elements should be in same order in same position
//equals  can be applied directly in set
//equal for map is not possible as each bucket order should match
    public static HashMap<Student,Report> studentReports = new HashMap<>();
    static {
        Student student = new Student("TN","ENG001",1L,new BigDecimal("20"));
        Student student1 = new Student("KL","ENG001",1L,new BigDecimal("10"));
        Student student2 = new Student("KA","ENG001",1L,new BigDecimal("30"));
        studentReports.put(student,new Report(1,"A+"));
        studentReports.put(student1,new Report(2,"A"));
        studentReports.put(student2,new Report(1,"A+"));

    }
    public static void main(String[] args){

       Report report = getStudent("TN","ENG001",1l);
       assert report !=null;
       assert report.getGrade().equals("A+");
       assert report.getRank()==1;
       System.out.println("validated");
       printStudentInfoBasedOnFeeDueDesc(studentReports);


    }

    public static Report getStudent(String stateCode, String collegeCode, Long seqId){
        Student student = new Student(stateCode,collegeCode,seqId,null);
        return studentReports.get(student);
    }


    public static void printStudentInfoBasedOnFeeDueDesc(HashMap<Student,Report> studentReports){
        List<Student> students = new ArrayList<>(studentReports.keySet());
        Collections.sort(students,(Student s1, Student s2) -> {
           return s2.getFeeDue().compareTo(s1.getFeeDue());
        }
        );

        students.stream().forEach(s-> {
          StringJoiner stringJoiner = new StringJoiner("-");
          stringJoiner.add(s.getStateCode());
          stringJoiner.add(s.getCollegeCode());
          stringJoiner.add(s.getSeqId().toString());
          System.out.println(stringJoiner.toString());
        });
    }

    public class col extends   Stack{

        @Override
        public boolean retainAll(Collection c) {
            return false;
        }

        @Override
        public int size() {
            return 0;
        }

        @Override
        public boolean isEmpty() {
            return false;
        }

        @Override
        public boolean contains(Object o) {
            return false;
        }

        @Override
        public Iterator iterator() {
            return null;
        }

        @Override
        public Object[] toArray() {
            return new Object[0];
        }

        @Override
        public boolean add(Object o) {
            return false;
        }

        @Override
        public Object peek() {
            return null;
        }

        @Override
        public boolean remove(Object o) {
            return false;
        }

        @Override
        public boolean addAll(Collection c) {
            return false;
        }

        @Override
        public void clear() {

        }

        @Override
        public boolean removeAll(Collection c) {
            return false;
        }

        @Override
        public boolean containsAll(Collection c) {
            return false;
        }

        @Override
        public Object[] toArray(Object[] a) {
            return new Object[0];
        }
    }
}
