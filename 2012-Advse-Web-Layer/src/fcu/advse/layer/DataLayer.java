package fcu.advse.layer;

public class DataLayer
{
    public String findPasswordByID(String id)
    {
        if ("Tom".equals(id))
            return "12345";
        else if ("Mary".equals(id))
            return "33333";
        else
            return null;
    }
}
