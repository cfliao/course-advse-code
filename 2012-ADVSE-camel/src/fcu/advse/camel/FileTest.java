package fcu.advse.camel;


import org.apache.camel.CamelContext;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.impl.DefaultCamelContext;

public class FileTest
{

    public static void main(String[] args) throws Exception
    {
        CamelContext context = new DefaultCamelContext();

        context.addRoutes(new RouteBuilder() {
            public void configure()
            {
                from("file:input?delete=true").bean(new XmlTagAdderlBean()).to("file:output");
            }
        });

        context.start();
        Thread.sleep(10000);
        context.stop();
    }
}
