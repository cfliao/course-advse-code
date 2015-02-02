package fcu.advse.jmx;

import java.io.IOException;

import javax.management.InstanceAlreadyExistsException;
import javax.management.MBeanRegistrationException;
import javax.management.MBeanServer;
import javax.management.MBeanServerFactory;
import javax.management.MalformedObjectNameException;
import javax.management.NotCompliantMBeanException;
import javax.management.ObjectName;
import javax.management.remote.JMXConnectorServer;
import javax.management.remote.JMXConnectorServerFactory;
import javax.management.remote.JMXServiceURL;

import com.sun.jdmk.comm.HtmlAdaptorServer;

import fcu.advse.jmx.internal.UsbDriver;
import fcu.advse.jmx.internal.VideoCardDriver;

// remember to execute /jdk_path/bin/"start rmiregistry" before you start this program
public class MicroKernel
{
    public static void main(String[] args) throws InstanceAlreadyExistsException, MBeanRegistrationException, NotCompliantMBeanException, MalformedObjectNameException, NullPointerException, IOException, InterruptedException 
    {
        // create microkernel
        MBeanServer microkernel = MBeanServerFactory.createMBeanServer();

        // add internal server
        microkernel.registerMBean(new VideoCardDriver(), new ObjectName("Internal Server:name=VideoCard Driver"));
        microkernel.registerMBean(new UsbDriver(), new ObjectName("Internal Server:name=USB Driver"));

        // add html connector
        HtmlAdaptorServer htmlServer = new HtmlAdaptorServer();
        ObjectName htmlName = new ObjectName("connector:type=html,port=8082");
        microkernel.registerMBean(htmlServer, htmlName);
        htmlServer.start();

        // add RMI connector
        JMXServiceURL rmiUrl = new JMXServiceURL("service:jmx:rmi:///jndi/rmi://localhost:1099/server");
        JMXConnectorServer rmiServer = JMXConnectorServerFactory.newJMXConnectorServer(rmiUrl, null, microkernel);
        ObjectName rmiName = new ObjectName("connector:type=standard_rmi");
        microkernel.registerMBean(rmiServer, rmiName);
        rmiServer.start();
        
        // Wait forever
        System.out.println("Microkernel and Internal Servers Started.");
        Thread.sleep(Long.MAX_VALUE);
    }

}
