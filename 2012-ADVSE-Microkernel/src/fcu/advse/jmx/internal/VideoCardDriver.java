package fcu.advse.jmx.internal;


public class VideoCardDriver implements VideoCardDriverMBean
{

    @Override
    public void display()
    {
        System.out.println("Display Graphics.");
    }

}
