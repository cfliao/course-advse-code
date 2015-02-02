package fcu.advse.broker;

import java.rmi.Naming;

public class PowerServiceClient
{
    public static void main(String args[]) throws Exception
    {
        PowerService service = (PowerService) Naming.lookup("rmi://localhost/PowerService");
        
        System.out.println(service.square(9));
        System.out.println(service.power(2, 10));
    }
}
