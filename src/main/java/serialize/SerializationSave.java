package serialize;

import java.io.*;

public class SerializationSave implements Serializable {

    public static void main(String[] args) throws IOException {
        FileOutputStream stream = new FileOutputStream("/app/projects/object.ser");
        ObjectOutputStream objStream = new ObjectOutputStream(stream);
        Book b = new Book("One","Two");
        objStream.writeObject(b);
        objStream.close();
    }



}

class Book implements Serializable {
    private String author;
    private String name;

    public Book(String author, String name) {
        this.author = author;
        this.name = name;
    }

    public String toString() {
        return "author: " + author +"\n" + "name: " + name;
    }
}