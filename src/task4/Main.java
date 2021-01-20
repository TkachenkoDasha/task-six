package task4;

import java.io.*;

public class Main {
    public static void main(String[] args) {

        File file = new File("src/task4/FileWithSpace.txt");

        try(BufferedReader bufferedReader = new BufferedReader( new FileReader(file))) {
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                String lineAfter =  line.trim().replaceAll("\t+", " ").replaceAll(" +", " ");
                System.out.println(lineAfter);
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found!");
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
