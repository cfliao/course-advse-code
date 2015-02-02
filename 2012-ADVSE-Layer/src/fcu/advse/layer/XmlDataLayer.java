package fcu.advse.layer;

import java.io.InputStream;
import java.util.prefs.Preferences;

public class XmlDataLayer
{
    private InputStream is;
    private Preferences data;
    
    public XmlDataLayer()
    {
        is = this.getClass().getResourceAsStream("users.xml");
        data = getData();
    }
    
    public String findPasswordByID(String id)
    {
        return data.get(id, null);
    }

    @SuppressWarnings("static-access")
    private Preferences getData()
    {
        Preferences perf = Preferences.userRoot();
        try
        {
            perf.importPreferences(is);
            perf = perf.node("UserDB");
        }
        catch(Exception e)
        {
            e.printStackTrace();
            return null;
        }

        return perf;
    }

}
