package fcu.advse.broker;

import java.math.BigInteger;
import java.rmi.Remote;
import java.rmi.RemoteException;

public interface PowerService extends Remote
{
    public BigInteger square(int number) throws RemoteException;

    public BigInteger power(int num1, int num2) throws RemoteException;
}