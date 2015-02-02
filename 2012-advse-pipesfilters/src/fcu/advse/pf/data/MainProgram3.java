package fcu.advse.pf.data;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.zip.CRC32;
import java.util.zip.CheckedInputStream;
import java.util.zip.CheckedOutputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;

public class MainProgram3
{
    public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException
    {

        MyData data = new MyData("Hello World!");

        //  modify the code to assemble the following pipes-and-filters: object -> CRC -> Zip -> file
        FileOutputStream fos = new FileOutputStream("mydata.object.crc.file.zip");
        ZipOutputStream zos = new ZipOutputStream(fos);
        ZipEntry entry = new ZipEntry("mydata.object.crc.file.zip");
        zos.putNextEntry(entry);
        CheckedOutputStream cos = new CheckedOutputStream(zos, new CRC32());
        ObjectOutputStream stream2 = new ObjectOutputStream(cos);

        // start writing object
        stream2.writeObject(data);
        stream2.close();

        System.out.println("original data: " + data.getData());
        System.out.println("out crc:" + cos.getChecksum().getValue());

        //  modify the code to assemble the following pipes-and-filters: file -> unzip -> CRC -> object
        FileInputStream fis = new FileInputStream("mydata.object.crc.file.zip");
        ZipInputStream zis = new ZipInputStream(fis);
        zis.getNextEntry();
        CheckedInputStream cis = new CheckedInputStream(zis, new CRC32());
        ObjectInputStream ois = new ObjectInputStream(cis);

        MyData recoveredData2 = (MyData) ois.readObject();

        System.out.println("recovered data: " + recoveredData2.getData());
        System.out.println("in crc:" + cos.getChecksum().getValue());

    }
}
