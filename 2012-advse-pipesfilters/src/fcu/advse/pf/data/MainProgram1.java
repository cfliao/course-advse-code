package fcu.advse.pf.data;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class MainProgram1
{

    public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException
    {

        MyData data = new MyData("Hello World!");

        // Assemble the pipes-and-filters: object -> file
        FileOutputStream fos = new FileOutputStream("mydata.object.file");
        ObjectOutputStream oos = new ObjectOutputStream(fos);

        // start writing object
        oos.writeObject(data);
        oos.close();
        System.out.println("Original data=" + data.getData());

        // Assemble the pipes-and-filters: file -> object
        FileInputStream fis = new FileInputStream("mydata.object.file");
        ObjectInputStream ois = new ObjectInputStream(fis);
        MyData recoveredData = (MyData) ois.readObject();
        
        System.out.println("Recovered data=" + recoveredData.getData());

    }

}
