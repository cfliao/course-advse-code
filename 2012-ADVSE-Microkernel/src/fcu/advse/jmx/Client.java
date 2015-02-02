package fcu.advse.jmx;

import fcu.advse.jmx.external.ExternalUsbServer;
import fcu.advse.jmx.external.ExternalVideoServer;

public class Client
{

    public static void main(String[] args)
    {
        ExternalUsbServer usbServer = new ExternalUsbServer();
        System.out.println(usbServer.readUsb());

        ExternalVideoServer videoServer = new ExternalVideoServer();
        videoServer.display();
    }

}
