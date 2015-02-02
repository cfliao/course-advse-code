
package tw.org.itri.smx.ws;

import javax.xml.ws.Endpoint;

/**
 * This class was generated by Apache CXF 2.2.12
 * Tue Feb 08 14:43:32 CST 2011
 * Generated source version: 2.2.12
 * 
 */
 
public class Calculator_CalculatorImplPort_Server{

    protected Calculator_CalculatorImplPort_Server() throws Exception {
        System.out.println("Starting Server");
        Object implementor = new CalculatorImpl();
        String address = "http://localhost:8192/Adder";
        Endpoint.publish(address, implementor);
    }
    
    public static void main(String args[]) throws Exception { 
        new Calculator_CalculatorImplPort_Server();
        System.out.println("Server ready..."); 
        
        Thread.sleep(5 * 60 * 1000); 
        System.out.println("Server exiting");
        System.exit(0);
    }
}
