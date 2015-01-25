package rmi;

import java.rmi.Naming;

public class MyClient {

    public static void main(String[] args) {
        try{
            Adder stub=(Adder) Naming.lookup("rmi://localhost:5000/sonoo");
            System.out.println(stub.add(34,4));
            Multiplier stub1 = (Multiplier) Naming.lookup("rmi://localhost:5000/mult");
            System.out.println(stub1.mult(2,30));
        }catch(Exception e){}
    }
}
