package fcu.advse.mom.publish;

import javax.jms.JMSException;
import javax.jms.Session;
import javax.jms.Topic;
import javax.jms.TopicConnection;
import javax.jms.TopicPublisher;
import javax.jms.TopicSession;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.commons.codec.EncoderException;
import org.apache.commons.codec.binary.Base64;

public class TtsMessagePublisher
{

    public static void main(String[] args) throws JMSException, InterruptedException, EncoderException
    {
        ActiveMQConnectionFactory connectionFactory = new ActiveMQConnectionFactory("tcp://localhost:61616");

        TopicConnection connection = connectionFactory.createTopicConnection();

        TopicSession session = connection.createTopicSession(false, Session.AUTO_ACKNOWLEDGE);

        Topic mytopic = session.createTopic("ssh.HCI.TTS");

        TopicPublisher publisher = session.createPublisher(mytopic);

        connection.start();

        publisher.publish(session.createTextMessage(Base64.encodeBase64String(new String("ด๚ธี").getBytes())));

        connection.close();

    }
}
