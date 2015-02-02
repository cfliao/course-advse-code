package fcu.advse.jmx.internal;

public interface UsbDriverMBean
{
    public String read();
    public void write(String data);
}
