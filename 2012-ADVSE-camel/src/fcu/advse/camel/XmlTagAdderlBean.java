package fcu.advse.camel;

import java.util.Map;

import org.apache.camel.Body;
import org.apache.camel.Handler;
import org.apache.camel.Headers;
import org.apache.log4j.Logger;

public class XmlTagAdderlBean
{
    private final static Logger logger = Logger.getLogger(XmlTagAdderlBean.class);

    @Handler
    public String process(@Headers Map<String, Object> headers, @Body String body)
    {
        logger.info("body:" + body);
        return "<x>"+body+"</x>";
    }

}
