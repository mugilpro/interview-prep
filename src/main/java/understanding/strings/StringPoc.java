package understanding.strings;

import java.util.ArrayList;

public class StringPoc {

    //String are immutable
    //imagine concat(string s) would be like
//    {
//        new String(this.byte[] combined with s.byte[])
//    }

    //StringBuffer - Thread safe and mutable and slower
    //StringBuilder - Non Thread safe and mutable and faster

// When string literal is encountered the Java will use intern of the literal to see if string exists in string pool. If it don't exist then it creates string in string pool
// "Hello" vs "new String("Hello");
    // "Hello" will create/reuse string only string pool
    // "new String("Hello") will create heap string object along with placing string in string pool. Hence there is more memory used when we use new keyword as in below example

//Since java 7 the string pool is moved to heap memory. Earlier it was in permgen which can't grow at runtime causing OOM
//Since java 9 string can either byte[] (1 byte) or char[] (2 byte). Earlier it was only char[]. So based content, it might use byte[] to save memory

//7,383,744
//    6,377,024
//109,408
    public static void main(String[] args) throws InterruptedException {
        Runtime rt = Runtime.getRuntime();
        rt.gc();
        Long currentMemory  = rt.freeMemory();
        System.out.println("current memory:" + rt.freeMemory());
        ArrayList<String> list = new ArrayList<>();
        for (int i = 0; i< 2000; i++) {
//           String s ="Hello000000000000000000000000000000000000";
//           current memory:529656304
//after memory:529656304
           String s = new String("Hello000000000000000000000000000000000000");
           list.add(s);
//           if(i%1000000 ==0) System.out.println("i=" + i);
        }
//        current memory:529656296
//after memory:522775944
        rt.gc();
        Thread.sleep(10000);
        Long afterMemory  = rt.freeMemory();
        System.out.println("sleeping:");
        Thread.sleep(100000);
        System.out.println("after memory:" + rt.freeMemory());
        System.out.println("Difference: " + (afterMemory- currentMemory));

//Important methods:
        //"Hello world"
//chatAt(2)
//concat(String s)
//length()

//substring(int begin)
//substring(int being, int end) = being inclusive, end exclusive
// replace (char old, char new)


//equalsIgnoreCase(String s)
// toLowerCase
// toUpperCase

//rtrim
//ltrim
//trim

        String str = "Hello World";
        System.out.println("length: " + str.length());
        System.out.println("char at 4: "+str.charAt(4));
        System.out.println("substring: " + str.substring(2));
        System.out.println("substring: " + str.substring(2,5));

    }
}
