package understanding.oops;

// Java code to illustrate order of
// execution of constructors, static
// and initialization blocks
class InitAndStaticBlock {

    InitAndStaticBlock(int x)
    {
        System.out.println("ONE argument constructor");
    }

    InitAndStaticBlock()
    {
        System.out.println("No  argument constructor");
    }

    static
    {
        System.out.println("1st static init");
    }

    {
        System.out.println("1st instance init");
    }

    {
        System.out.println("2nd instance init");
    }

    static
    {
        System.out.println("2nd static init");
    }

    public static void main(String[] args)
    {
        new InitAndStaticBlock();
        new InitAndStaticBlock(8);
    }
}