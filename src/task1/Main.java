package task1;

import java.io.*;

public class Main {

    public static void main(String[] args) {
        File file = new File("C:\\Users\\DEDUSHKA\\Desktop\\Стишок.txt");
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
