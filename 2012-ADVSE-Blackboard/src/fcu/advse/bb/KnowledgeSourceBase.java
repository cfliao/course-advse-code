package fcu.advse.bb;

import net.jini.core.discovery.LookupLocator;
import net.jini.core.lookup.ServiceMatches;
import net.jini.core.lookup.ServiceRegistrar;
import net.jini.core.lookup.ServiceTemplate;
import net.jini.space.JavaSpace;

public abstract class KnowledgeSourceBase implements KnowledgeSource
{
    private JavaSpace javaSpace;

    public JavaSpace getBlackboard()
    {
        return javaSpace;
    }

    public KnowledgeSourceBase()
    {
        try
        {
            LookupLocator ll = new LookupLocator("jini://localhost:4160");
            ServiceRegistrar sr = ll.getRegistrar();
            ServiceTemplate template = new ServiceTemplate(null, new Class[] { JavaSpace.class }, null);
            ServiceMatches sms = sr.lookup(template, 10);
            if (0 < sms.items.length)
            {
                javaSpace = (JavaSpace) sms.items[0].service;
            } else
            {
                throw new Exception("No Java Space found.");
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
            System.exit(1);
        }
    }

    abstract public int execCondition();

    abstract public void execAction();

}
