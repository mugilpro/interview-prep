package understanding.file;

import java.io.*;

public class FilePoc {


    public static void main(String[] args) throws IOException {
        //Creating file
        File f = new File("h:\\test.txt");
        System.out.println(f.createNewFile());
        //exists
        System.out.println(f.exists());
        //delete file
        System.out.println(f.delete());

        File fileRead = new File("h:\\testing.txt");

        //file read
        FileInputStream fileInputStream = new FileInputStream(fileRead);
        String content = new String(fileInputStream.readAllBytes());
        System.out.println(content); //testing\r\n the\r\nfile


        //file write
        File fileWrite = new File("h:\\testing_write.txt");
        FileOutputStream fileOutputStream = new FileOutputStream(fileWrite);
        fileOutputStream.write(content.getBytes());

        InputStream in  = FilePoc.class.getClassLoader().getResourceAsStream("sql/Join.sql");
        System.out.println(new String(in.readAllBytes()));

    }

}
