package task5;

import java.io.*;


public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String filePath = bufferedReader.readLine();

        File file = new File(filePath);
                
        String extension = retrieveExtension(filePath);

        File file1 = new File("src/task5/testCreated" + extension);

        System.out.println(copyFiles(file, file1));
    }

    private static String retrieveExtension(String filePath) {
        int input = filePath.lastIndexOf('.');
        return input > 0 ? filePath.substring(input) : "";
    }

    private static String copyFiles(File file, File file1) {
        try {
            file1.createNewFile();
        } catch (IOException e) {
            System.out.println("Impossible to create file: " + e.getMessage());
            return "Bye.";
        }

        try (BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream(file));
             BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(file1))) {
            int info;
            while ((info = bufferedInputStream.read()) != -1) {
                bufferedOutputStream.write(info);
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found!");
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

        return file1.getAbsolutePath();
    }
}
