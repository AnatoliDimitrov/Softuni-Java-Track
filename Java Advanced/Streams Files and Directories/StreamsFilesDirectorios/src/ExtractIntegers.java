import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class ExtractIntegers {
    public static void main(String[] args) {
        var inputPath = "D:\\GitHub\\Softuni-Java-Track\\Java Advanced\\Streams Files and Directories\\StreamsFilesDirectorios\\src\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\input.txt";

        try(FileInputStream reader = new FileInputStream(inputPath)){
            Scanner scanner = new Scanner(reader);
            while (scanner.hasNext()) {
                if (scanner.hasNextInt()){
                    System.out.println(scanner.next());
                } else {
                    scanner.next();
                }
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}