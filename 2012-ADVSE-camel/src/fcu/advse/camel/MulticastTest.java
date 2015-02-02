package fcu.advse.camel;


import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.camel.CamelContext;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.component.jms.JmsComponent;
import org.apache.camel.impl.DefaultCamelContext;

public class MulticastTest
{

    public static void main(String[] args) throws Exception
    {
        CamelContext context = new DefaultCamelContext();

        context.addComponent("jms", JmsComponent.jmsComponentAutoAcknowledge(new ActiveMQConnectionFactory("tcp://localhost:61616")));

        context.addRoutes(new RouteBuilder() {
            public void configure()
            {
                from("jms:topic:simple.input").bean(new XmlTagAdderlBean()).multicast().to("jms:topic:simple.output","file://./output");
            }
        });

        context.start();
    }
}
