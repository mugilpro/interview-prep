package exception;

import java.io.FileNotFoundException;
import java.io.IOException;

public class MainExceptionOrder {

    public static void main(String args[]){
        try{
            try{
                System.out.println("starting");
                if(1==1) throw new FileNotFoundException("ERROR");
                System.out.println("ending");
            }catch (Exception e){
                System.out.println("General inner Exception");
                throw e;
            }
        } catch (FileNotFoundException e){
            System.out.println("FNF Exception");
        }
        catch (Exception e){
            System.out.println("General outer Exception");
        }
    }
}
