package fcu.advse.bb;

import java.io.IOException;

import net.jini.core.discovery.LookupLocator;
import net.jini.core.entry.Entry;
import net.jini.core.entry.UnusableEntryException;
import net.jini.core.lookup.ServiceMatches;
import net.jini.core.lookup.ServiceRegistrar;
import net.jini.core.lookup.ServiceTemplate;
import net.jini.core.transaction.TransactionException;
import net.jini.lookup.entry.Name;
import net.jini.space.JavaSpace;

public class TestClient
{

    /**
     * @param args
     * @throws ClassNotFoundException 
     * @throws IOException 
     * @throws TransactionException 
     * @throws InterruptedException 
     * @throws UnusableEntryException 
     */
    public static void main(String[] args) throws IOException, ClassNotFoundException, TransactionException, UnusableEntryException, InterruptedException
    {
        LookupLocator ll = new LookupLocator("jini://localhost:4160");
        ServiceRegistrar sr = ll.getRegistrar();
        ServiceTemplate template = new ServiceTemplate(null, new Class[] { JavaSpace.class }, null);
        ServiceMatches sms = sr.lookup(template, 10);
        if (0 < sms.items.length)
        {
            JavaSpace space = (JavaSpace) sms.items[0].service;
            // do something with the space
            space.write(new Name("Hello"), null, 3000);

            Entry entry = space.read(null, null, 3000);
            
            System.out.println(entry.toString());
        } else
        {
            System.out.println("No Java Space found.");
        }
    }

}
