package fcu.advse.mom.publish;

import java.util.Date;

import javax.jms.JMSException;
import javax.jms.Session;
import javax.jms.Topic;
import javax.jms.TopicConnection;
import javax.jms.TopicPublisher;
import javax.jms.TopicSession;

import org.apache.activemq.ActiveMQConnectionFactory;

public class MessagePublisher
{

    public static void main(String[] args) throws JMSException, InterruptedException
    {
        ActiveMQConnectionFactory connectionFactory = new ActiveMQConnectionFactory("tcp://localhost:61616");

        TopicConnection connection = connectionFactory.createTopicConnection();

        TopicSession session = connection.createTopicSession(false, Session.AUTO_ACKNOWLEDGE);

        Topic inputTopic = session.createTopic("simple.input");

        TopicPublisher publisher = session.createPublisher(inputTopic);

        connection.start();

        publisher.publish(session.createTextMessage(new Date().toString()));

    }
}
