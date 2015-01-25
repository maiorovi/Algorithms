package rmi;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class DefaultMultiplier extends UnicastRemoteObject implements Multiplier {

    protected DefaultMultiplier() throws RemoteException {
        super();
    }

    @Override
    public int mult(int x, int y) throws RemoteException {
        return x * y;
    }

}
