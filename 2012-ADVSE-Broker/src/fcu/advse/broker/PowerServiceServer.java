package fcu.advse.broker;

import java.math.BigInteger;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class PowerServiceServer extends UnicastRemoteObject implements PowerService
{
    private static final long serialVersionUID = 1L;

    public PowerServiceServer() throws RemoteException
    {
        super();
    }

    // Calculate the square of a number
    public BigInteger square(int number) throws RemoteException
    {
        String numrep = String.valueOf(number);
        BigInteger bi = new BigInteger(numrep);

        // Square the number
        bi = bi.multiply(bi);

        return (bi);
    }

    // Calculate the power of a number
    public BigInteger power(int num1, int num2) throws RemoteException
    {
        String numrep = String.valueOf(num1);
        BigInteger bi = new BigInteger(numrep);

        bi = bi.pow(num2);

        return bi;
    }

    public static void main(String args[]) throws Exception
    {
        System.setProperty("java.rmi.server.codebase", PowerServiceServer.class.getProtectionDomain().getCodeSource().getLocation().toString());
        // Create an instance of our power service server ...
        PowerServiceServer svr = new PowerServiceServer();

        // ... and bind it with the RMI Registry
        Naming.bind("PowerService", svr);

        System.out.println("Service bound....");
    }
}
