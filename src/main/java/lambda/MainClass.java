package lambda;


import collections.Student;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.function.Consumer;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MainClass {
    //Stream to get user belong to TN

// Collectors.toList()
// Collectors.toMap()       return books.stream().collect(Collectors.toMap(Book::getIsbn, Book::getName));
 //   https://www.baeldung.com/java-lambda-exceptions
    //collections.stream().
    //foreach() - do returns stream just one time action. No further Lambda operation possible.
    //map()-> input one type and can return totally different  type. Each int can be converted to String also
    //reduce() -> combines stream of input to single output ("initvalue", (partialResult, Stream input") -> return partial result combined with stream input )
    //filter -> allows only records matching the filter

    //groupingBy
    //partitioningBy


    //sort  - Don't require comparator - but throws runtime exception if not comparable
    //min   - requires comparator
    //max   - requires comparator
    //findFirst - returns optional - first element of stream
    //findAny - returns optional - find any element of stream

    //Intstream
    //LongStream
    //DoubleStream
//    count
//    sum
//    average


    public static void main(String[] args) {
//        Stream can't be operated twice; E1
        ArrayList<Integer> arrayList = new ArrayList<>();
        arrayList.add(12);
        Stream stream = arrayList.stream();
        stream.map(s-> "streamOperation" +s);
//        stream.forEach(System.out::println); // E1: Exception in thread "main" java.lang.IllegalStateException: stream has already been operated upon or closed

        //       Stream keeps track of original list modification (with Exception  CopyOnWriteArrayList) but Modification while streaming to existing list give concurrent modification exception - E2
        ArrayList<Integer> streamOrder = new ArrayList<>();
        Stream streamTest = streamOrder.stream();
        streamOrder.add(99);
        streamTest.map(s-> "streamOrder" +s).forEach(System.out::println);

        //        Modification to existing list give concurrent modification exception
//        streamOrder.stream().forEach(s-> streamOrder.add(s)); // E2: Exception in thread "main" java.util.ConcurrentModificationException

        //  CopyOnWriteArray take snapshot of current list don't track changes in stream
        CopyOnWriteArrayList<Integer> cowStreamOrder = new CopyOnWriteArrayList<>();
        cowStreamOrder.add(45);
        Stream cowStreamTest = cowStreamOrder.stream();
        cowStreamOrder.add(99);
        cowStreamTest.map(s-> "cow" +s).forEach(System.out::println);

        //        Modification to existing list give concurrent modification exception
        cowStreamOrder.stream().forEach(s-> cowStreamOrder.add(s)); // Exception in thread "main" java.util.ConcurrentModificationException


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
//        System.out.println(students.stream().sorted()); //cannot be cast to class java.lang.Comparable
        System.out.println("Sorted students: " +students.stream().sorted((a,b)-> {
            if(a.getSeqId() > b.getSeqId()){return 1;}
            else if(a.getSeqId() < b.getSeqId()){return -1;}
         return 0;
        }));
        ArrayList<String> stringList = new ArrayList<>();
        stringList.add("Hello");
        stringList.add("World");
        stringList.add("Done");
        stringList.add("Hello");
        System.out.println(stringList.stream().map(String::new).filter(s -> s.equals("Hello")).collect(Collectors.toList()));
        System.out.println(stringList.stream().sorted().collect(Collectors.toList()));
        System.out.println(stringList.stream().sorted().collect(Collectors.toSet()));

        int[] intArray = new int[]{4,32,1,2,5};

        System.out.println(Arrays.stream(intArray).max());
        System.out.println(Arrays.stream(intArray).min());
        System.out.println(Arrays.stream(intArray).count());
        System.out.println(Arrays.stream(intArray).sum());
        System.out.println(Arrays.stream(intArray).average());
        int i = 10;
        students.stream().map(s-> s.getSeqId() + i).forEach(System.out::println);
        //start of non final variable usage using local variable check
        students.stream().map(s-> s.getSeqId()).forEach(getConsumer());
//         students.stream().map(s-> s.getSeqId() + i++).forEach(System.out::println); --Local variables should be final or effectively final
        // -- non final variable should be final or effectively final
        //end of non final variable usage using local variable check

        //start of non final variable usage using instance variable check
        StudentDetail checkFinalUsage = new StudentDetail("KA","ENG001",12L,new BigDecimal("30"));
        Consumer<Long> consumer = getConsumer(checkFinalUsage);
        checkFinalUsage.setSeqId(14L);
        students.stream().map(s-> s.getSeqId()).forEach(consumer);
        //end of non final variable usage using instance variable check





    }
        public static Consumer<Long> getConsumer(){
        int i = 10;
        return (var s)-> {
            System.out.println("inside getconsumer(): " + (s+i));
        };
        //i++ --Local variables should be final or effectively final
        }

    public static Consumer<Long> getConsumer(StudentDetail student){
        int i = 10;
        return (var s)-> {
            System.out.println("inside getconsumer(StudentDetails s): " + student.getSeqId());
        };
        //i++ --Local variables should be final or effectively final
    }

}
