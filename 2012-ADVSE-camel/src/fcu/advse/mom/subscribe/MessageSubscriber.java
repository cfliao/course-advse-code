package fcu.advse.mom.subscribe;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.Session;
import javax.jms.TextMessage;
import javax.jms.Topic;
import javax.jms.TopicConnection;
import javax.jms.TopicSession;
import javax.jms.TopicSubscriber;

import org.apache.activemq.ActiveMQConnectionFactory;

public class MessageSubscriber implements MessageListener
{
    public MessageSubscriber() throws JMSException
    {
        ActiveMQConnectionFactory connectionFactory = new ActiveMQConnectionFactory("tcp://localhost:61616");

        TopicConnection connection = connectionFactory.createTopicConnection();

        TopicSession session = connection.createTopicSession(false, Session.AUTO_ACKNOWLEDGE);

        Topic mytopic = session.createTopic("simple.output");

        TopicSubscriber consumer = session.createSubscriber(mytopic);

        consumer.setMessageListener(this);

        connection.start();
    }

    public static void main(String[] args) throws JMSException
    {
        new MessageSubscriber();
    }

    @Override
    public void onMessage(Message msg)
    {
        TextMessage m = (TextMessage) msg;

        try
        {
            System.out.println("Received: " + m.getText());
        }
        catch (JMSException e)
        {
            e.printStackTrace();
        }
    }
}
