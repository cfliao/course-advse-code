package fcu.advse.bb;

import net.jini.core.entry.Entry;

public class MyEntry implements Entry
{
    private static final long serialVersionUID = 4653665064236503642L;
    
    private String value;

    public String getValue()
    {
        return value;
    }

    public void setValue(String value)
    {
        this.value = value;
    }

    public MyEntry()
    {
        
    }
    
    public MyEntry(String value)
    {
        super();
        this.value = value;
    }

}
