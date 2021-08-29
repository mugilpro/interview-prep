package overridding;

import java.io.FileNotFoundException;
import java.io.IOException;

public class MainOverride {

}

class Parent{
    public void method1() throws IOException{

    }

    public Parent method2() throws IOException{
        return null;
    }
}

class child1 extends Parent{
//    public void method1() throws RuntimeException{
//
//    }
//    public void method1() throws IOException{
//
//    }
//    public void method1() {
//
//    }

//    public Parent method2() throws IOException{
//        return null;
//    }
//    public child1 method2() throws IOException{
//        return null;
//    }
//    public String method2() throws IOException{
//        return null;
//    }

}

