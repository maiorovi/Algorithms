package rmi;

import java.rmi.Naming;

public class MyServer {

    public static void main(String[] args) {
        try {
            Adder stub = new AdderRemote();
            Multiplier mult = new DefaultMultiplier();
            Naming.rebind("rmi://localhost:5000/sonoo", stub);
            Naming.rebind("rmi://localhost:5000/mult", mult);
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
