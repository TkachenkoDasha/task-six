package task3;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Main {

    public static void main(String[] args) {
        File file = new File("src/task3/newFile.txt");
        Random random = new Random();

        if (!file.exists())  {
            try {
                file.createNewFile();
            } catch (IOException e) {
                System.out.println("File is not created.");
            }
        }

        writeToFile(file, random);

        readFile(file);
    }

    private static void readFile(File file) {
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(file))) {
            List<Integer> list = new ArrayList<>();
            String line = bufferedReader.readLine(); //56 56 8 45 23 split
            String[] array = line.split(" "); //[56][56][8]...

            for (String stringNumber : array) {
                list.add(Integer.parseInt(stringNumber));
            }

            list.stream().sorted().forEach(x -> System.out.print(x + " "));
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    private static void writeToFile(File file, Random random) {
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file))) {
            for (int i = 0; i < 200; i++) {
                int number = random.nextInt(100000);
                bufferedWriter.write(number + " ");
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
