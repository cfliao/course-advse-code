package fcu.advse.jmx.internal;


public class UsbDriver implements UsbDriverMBean
{
    @Override
    public String read()
    {
        return "some usb data";
    }

    @Override
    public void write(String data)
    {
        System.out.println("writing some data to usb:" + data);
    }

}
