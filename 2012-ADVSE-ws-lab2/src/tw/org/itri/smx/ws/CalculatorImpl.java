/**
 * Please modify this class to meet your needs
 * This class is not complete
 */

package tw.org.itri.smx.ws;

import java.util.logging.Logger;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;

/**
 * This class was generated by Apache CXF 2.2.12 Tue Feb 08 14:43:32 CST 2011 Generated source version: 2.2.12
 */

@javax.jws.WebService(serviceName = "CalculatorImplService", portName = "CalculatorImplPort", targetNamespace = "http://ws.smx.itri.org.tw/", endpointInterface = "tw.org.itri.smx.ws.Calculator")
public class CalculatorImpl implements Calculator
{

    private static final Logger LOG = Logger.getLogger(CalculatorImpl.class.getName());

    /*
     * (non-Javadoc)
     * @see tw.org.itri.smx.ws.Calculator#add(int arg0 ,)int arg1 )*
     */
    public int add(int arg0, int arg1)
    {
        LOG.info("Executing operation add");
        System.out.println(arg0);
        System.out.println(arg1);
        try
        {
            int _return = arg0 + arg1;
            return _return;
        }
        catch (Exception ex)
        {
            ex.printStackTrace();
            throw new RuntimeException(ex);
        }
    }

}
