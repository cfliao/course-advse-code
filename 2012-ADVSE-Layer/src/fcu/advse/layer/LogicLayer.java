package fcu.advse.layer;

public class LogicLayer
{
    private DataLayer datalayer = new DataLayer();
    //private XmlDataLayer datalayer = new XmlDataLayer();

    public boolean auth(String inputId, String inputPassword)
    {
        String password = datalayer.findPasswordByID(inputId);

        if (inputPassword != null && password != null && password.equals(inputPassword))
        {
            return true;
        } else
            return false;
    }
}
