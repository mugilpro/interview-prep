package understanding.assignments;

public class Assignment {

    public static void main(String[] args) {
        int intOne = 1;
        long logOne = 1L;
        //   int intOne = 1L;
        byte byteOne = 1;
        byte byteTwo = 2;

//        We know that a literal integer is always an int, but more importantly, the result
//        of an expression involving anything int-sized or smaller is always an int
        // byte byteSumCheck = byteOne + byteTwo;
        byte byteSum = (byte) (byteOne + byteTwo);

//Rules
// primitives
// putting Lower into higher is possible - implicitly
// putting higher to lower - explicit - loss to precision eg. 130 int assignment to byte would -126 byte due to rotation
// == is only possible value

// wrapper
// putting Lower into higher OR higher to lower is not possible either as literal or reference - use xxxValue to corresponding higher value
// == works fine if values is between -128 to 127 or boolean value. So never use ==. Always use equals. if both are wrapper
// If == is between primitive and wrapper then wrapper will be coverted to primitive and == works fine
// Wrapper objects are immutable
        //Three important methods
//  object.intvalue(), object.longValue() return int primitive
//Integer.parseValue(String) returns int primitive
//Integer.valueOf(String) returns Integer wrapper

//primitive overloading: For primitive as reference type : m1(int a) passing primitive input - lowest datatype is matched
//primitive overloading: For primitive as reference type: m1(int a) passing wrapper input eg: new Byte(10) - Unbox and widen - lowest datatype is matched
//wrapper overloading: For wrapper as reference type: m1(Integer a)-  widen is not possible except object reference. either box and widen or direct widen is not possible. new Byte(10) or byte primitive input is not possible.


//Wrapper Constructor
//        First constructor takes corresponding primitive data as an argument - Integer(int a)
//        Second constructor takes string as an argument - Integer(String a)

//***************  primitives ***************//
        //Low to higher no cast for literal
        byte lowerByte = 50;
        int higherInt = lowerByte;
        long higherLong = higherInt;
        float higherFloat = higherInt;
        float higherFloat1 = higherLong;
        double higherDouble1 = higherInt;
        double higherDouble2 = higherLong;
        double higherDouble3 = higherFloat;
        double higherDouble4 = higherFloat1;


        // higher to lower requires casting
//        lowerByte = higherInt ;
        lowerByte = (byte)higherInt ;
//        higherInt = higherLong ;
        higherInt =(int) higherLong ;
//        higherInt = higherFloat ;
        higherInt = (int) higherFloat ;
//        higherLong = higherFloat1 ;
        higherLong = (long) higherFloat1 ;
//        higherInt = higherDouble1 ;
        higherInt = (int) higherDouble1 ;
//        higherLong =  higherDouble2 ;
        higherLong = (long)higherDouble2 ;
//        higherFloat = higherDouble3 ;
        higherFloat = (float) higherDouble3 ;
//        higherFloat1 =  higherDouble4;
        higherFloat1 = (float) higherDouble4;

        // Loss of precision example
        byte signed = (byte) 129;
        //0b10000001 - two's complement
        //  reverse - 01111110
        //add 1 - 011111111
        //= -127
        System.out.println(signed);

        //There is no  signed or unsigned datatype. By default all are signed
        int unsigned =  0b10000000000000000000000000000001;
        System.out.println("Default signed:" + unsigned);

        System.out.println("Unsigned:" +Integer.toUnsignedString(unsigned));


        //***************  wrapper ***************//

        //Low to higher or higher to lower for wrapper objects either as reference or as literal is NOT possible automatically use xxxValue()
        Byte lowerByteObj = 50;
        Integer ObjInt = 50;
//             lowerByteObj = (Byte) ObjInt;
//             ObjInt = (Integer) lowerByteObj;
        lowerByteObj = ObjInt.byteValue();
        ObjInt = lowerByteObj.intValue();





        Integer i1 = 10;
        Integer i2 = 10;
        Integer i3 = 128;
        Integer i4 = 128;

        // For wrapper objects == when their
        //primitive values are the same:
        //■ Boolean
        //■ Byte
        //■ Character from \u0000 to \u007f (
        //Short/Integer from -128 to 127
        //Others will not be equal

        System.out.println("i1==i2" +  (i1==i2));
        System.out.println("i3==i4" +  (i3==i4));
        System.out.println("i3>i4" +  (i3>i4));
        System.out.println("i3<i4" +  (i3<i4));

        //When == is used to compare a primitive to a wrapper, the wrapper will be
        //unwrapped and the comparison will be primitive to primitive

        System.out.println("i3==128" +  (i3==128));

        // compiler error as it is int not Integer
        // System.out.println(Integer.parseInt("20") instanceof Integer);
        System.out.println("instanceof: " + (Integer.valueOf("20") instanceof Integer));





        //primitive overloading - lowest datatype is matched
        int intArg = 10;
        byte byteArg = 10;
        float floatArg = 10f;
        System.out.println("int passing " + primitiveOverloading(intArg));
        System.out.println("byte passing " + primitiveOverloading(byteArg));
        System.out.println("float passing " + primitiveOverloading(floatArg));

        //************************************************* Boxing/Unboxing *****************************************//

        //AutoBoxing
        Integer box = 20;

        //Auto Unboxing
        int unbox = box;

        Integer objIntArg = 10;
        Byte  objByteArg = 10;
        Float  objFloatArg = 10f;

//For wrapper as reference widen is not possible except object reference. either box and widen or direct widen not possible
//        (box and widen) or (widen and box) - not possible expect only widen to Object reference
        System.out.println("int passing" +  wrapperOverloading(intArg));
//        System.out.println("byte passing" +  wrapperOverloading(byteArg));
//        System.out.println("float passing" +  wrapperOverloading(floatArg));

//     direct widen
        System.out.println("int passing" +  wrapperOverloading(objIntArg));
//        System.out.println("byte passing" +  wrapperOverloading(objByteArg));
//        System.out.println("float passing" +  wrapperOverloading(objFloatArg));


        // unbox and widen is possible. So works same as primitive - lowest datatype is matched

        System.out.println("int passing " + primitiveOverloading(objIntArg));
        System.out.println("byte passing " + primitiveOverloading(objByteArg));
        System.out.println("float passing " + primitiveOverloading(objFloatArg));

        //primitive wrapper conflict - take short path without boxing or unboxing
        System.out.println("int passing " + primitiveWrapperConflict(intArg));
        System.out.println("Integer passing " + primitiveWrapperConflict(objIntArg));
        System.out.println("Byte passing "+primitiveWrapperConflict(objByteArg));

    }


    public static String primitiveOverloading(int a){
        return "int matching ";
    }

    public static String primitiveOverloading(short a){
        return "short matching ";
    }

    public static String primitiveOverloading(long  a){
        return "long matching ";
    }
    public static String primitiveOverloading(double  a){
        return "double matching ";
    }

      public static String wrapperOverloading(Integer a){
        return "Integer matching ";
    }

    public static String wrapperOverloading(Short a){
        return "Short matching ";
    }

    public static String wrapperOverloading(Long  a){
        return "Long matching ";
    }
    public static String wrapperOverloading(Double  a){
        return "Double matching ";
    }


    public static String primitiveWrapperConflict(Integer a) {
        return "primitiveWrapperConflict Integer matching ";
    }
    public static String primitiveWrapperConflict(int a) {
        return "primitiveWrapperConflict int matching ";
    }


    public static String primitiveWrapperConflict(Object a) {
        return "primitiveWrapperConflict obj matching ";
    }

    public void finalize(){

    }
}


