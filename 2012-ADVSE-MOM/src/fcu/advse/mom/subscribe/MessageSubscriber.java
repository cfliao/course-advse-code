package fcu.advse.mom.subscribe;

import javax.jms.JMSException;
import javax.jms.Session;
import javax.jms.Topic;
import javax.jms.TopicConnection;
import javax.jms.TopicSession;
import javax.jms.TopicSubscriber;

import org.apache.activemq.ActiveMQConnectionFactory;

public class MessageSubscriber
{
    public static void main(String[] args) throws JMSException
    {
        ActiveMQConnectionFactory connectionFactory = new ActiveMQConnectionFactory("tcp://localhost:61616");
       
        TopicConnection connection = connectionFactory.createTopicConnection();
        
        TopicSession session = connection.createTopicSession(false, Session.AUTO_ACKNOWLEDGE);
        
        Topic mytopic = session.createTopic("MYTOPIC");
        
        TopicSubscriber consumer = session.createSubscriber(mytopic);
        
        consumer.setMessageListener(new MyMessageListener());
        
        connection.start();
    }
}
