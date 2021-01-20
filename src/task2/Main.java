package task2;

import java.io.*;

public class Main {
    public static void main(String[] args) {
        try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream("src/task2/cat.dat"))) {
            Cat cat = new Cat("Barsik", 2, "lkgnjknk");
            objectOutputStream.writeObject(cat);
        } catch (FileNotFoundException e) {
            System.out.println("File not found.");
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

        try (ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream("src/task2/cat.dat"))) {
            Cat cat = (Cat) objectInputStream.readObject();
            System.out.println(cat);
        } catch (FileNotFoundException e) {
            System.out.println("File not found.");
        } catch (IOException | ClassNotFoundException e) {
            System.out.println(e.getStackTrace());
        }

    }
}
