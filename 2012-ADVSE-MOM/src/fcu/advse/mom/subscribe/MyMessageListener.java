package fcu.advse.mom.subscribe;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

public class MyMessageListener implements MessageListener
{

    public void onMessage(Message msg)
    {
        TextMessage m = (TextMessage) msg;
        
        try
        {
            System.out.println("> "+ m.getText());
        }
        catch (JMSException e)
        {
            e.printStackTrace();
        }
    }
}
