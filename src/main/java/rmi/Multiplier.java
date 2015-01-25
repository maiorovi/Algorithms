package rmi;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface Multiplier extends Remote {

    public int mult(int x, int y) throws RemoteException;

}
