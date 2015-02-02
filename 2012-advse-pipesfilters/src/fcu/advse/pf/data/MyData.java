package fcu.advse.pf.data;

import java.io.Serializable;

public class MyData implements Serializable
{
    private static final long serialVersionUID = -6512138918882549065L;
    
    private String data;

    public String getData()
    {
        return data;
    }

    public MyData(String data)
    {
        super();
        this.data = data;
    }

}
