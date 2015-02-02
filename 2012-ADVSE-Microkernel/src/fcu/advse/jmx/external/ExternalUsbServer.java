package fcu.advse.jmx.external;

import java.io.IOException;
import java.net.MalformedURLException;

import javax.management.JMX;
import javax.management.MBeanServerConnection;
import javax.management.MalformedObjectNameException;
import javax.management.ObjectName;
import javax.management.remote.JMXConnector;
import javax.management.remote.JMXConnectorFactory;
import javax.management.remote.JMXServiceURL;

import fcu.advse.jmx.internal.UsbDriverMBean;

public class ExternalUsbServer
{
    private JMXServiceURL url = null;

    private JMXConnector jmxc = null;

    private MBeanServerConnection mbsc = null;
    
    public ExternalUsbServer()
    {
        try
        {
            url = new JMXServiceURL("service:jmx:rmi:///jndi/rmi://localhost:1099/server");
            jmxc = JMXConnectorFactory.connect(url, null);
            mbsc = jmxc.getMBeanServerConnection();
        }
        catch (MalformedURLException e)
        {
            e.printStackTrace();
            System.exit(1);
        }
        catch (IOException e)
        {
            e.printStackTrace();
            System.exit(1);
        }
    }
    
    public String readUsb()
    {
        ObjectName mbeanName = null;
        
        try
        {
            mbeanName = new ObjectName("Internal Server:name=USB Driver");
        }
        catch (MalformedObjectNameException e)
        {
            e.printStackTrace();
        }
        catch (NullPointerException e)
        {
            e.printStackTrace();
        }

        UsbDriverMBean mbeanProxy = JMX.newMBeanProxy(mbsc, mbeanName, UsbDriverMBean.class, true);

        return mbeanProxy.read();
    }
    
}
