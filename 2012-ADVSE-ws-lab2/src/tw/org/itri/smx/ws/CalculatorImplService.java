
/*
 * 
 */

package tw.org.itri.smx.ws;

import java.net.MalformedURLException;
import java.net.URL;
import javax.xml.namespace.QName;
import javax.xml.ws.WebEndpoint;
import javax.xml.ws.WebServiceClient;
import javax.xml.ws.WebServiceFeature;
import javax.xml.ws.Service;

/**
 * This class was generated by Apache CXF 2.2.12
 * Tue Feb 08 14:43:32 CST 2011
 * Generated source version: 2.2.12
 * 
 */


@WebServiceClient(name = "CalculatorImplService", 
                  wsdlLocation = "file:CalculatorImplService.wsdl",
                  targetNamespace = "http://ws.smx.itri.org.tw/") 
public class CalculatorImplService extends Service {

    public final static URL WSDL_LOCATION;
    public final static QName SERVICE = new QName("http://ws.smx.itri.org.tw/", "CalculatorImplService");
    public final static QName CalculatorImplPort = new QName("http://ws.smx.itri.org.tw/", "CalculatorImplPort");
    static {
        URL url = null;
        try {
            url = new URL("file:CalculatorImplService.wsdl");
        } catch (MalformedURLException e) {
            System.err.println("Can not initialize the default wsdl from file:CalculatorImplService.wsdl");
            // e.printStackTrace();
        }
        WSDL_LOCATION = url;
    }

    public CalculatorImplService(URL wsdlLocation) {
        super(wsdlLocation, SERVICE);
    }

    public CalculatorImplService(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public CalculatorImplService() {
        super(WSDL_LOCATION, SERVICE);
    }
    

    /**
     * 
     * @return
     *     returns Calculator
     */
    @WebEndpoint(name = "CalculatorImplPort")
    public Calculator getCalculatorImplPort() {
        return super.getPort(CalculatorImplPort, Calculator.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns Calculator
     */
    @WebEndpoint(name = "CalculatorImplPort")
    public Calculator getCalculatorImplPort(WebServiceFeature... features) {
        return super.getPort(CalculatorImplPort, Calculator.class, features);
    }

}
