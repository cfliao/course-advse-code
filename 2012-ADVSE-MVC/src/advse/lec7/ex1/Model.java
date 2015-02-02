package advse.lec7.ex1;

import java.util.HashSet;
import java.util.Set;

public class Model
{
    private String data;

    private Set<Observer> observers = new HashSet<Observer>();

    public void attach(Observer observer)
    {
        observers.add(observer);
    }

    public void detach(Observer observer)
    {
        observers.remove(observer);
    }

    public void notifyEvent(Event e)
    {
        for (Observer o : observers)
        {
            o.update(e);
        }
    }

    public String getData()
    {
        return data;
    }

    public void service(Event e)
    {
        data = e.getContents();
        System.out.println("Model: data=" + data);
        notifyEvent(e);
    }
}
