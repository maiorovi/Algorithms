package serialize;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;

public class SerializationLoad {

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        FileInputStream fstream = new FileInputStream("/app/projects/object.ser");
        ObjectInputStream objStream = new ObjectInputStream(fstream);
        Book b = (Book) objStream.readObject();
        System.out.println(b.toString());
    }

}
