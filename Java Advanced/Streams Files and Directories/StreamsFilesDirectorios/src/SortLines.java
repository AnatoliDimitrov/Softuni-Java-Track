import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Collections;
import java.util.Scanner;

public class SortLines {
    public static void main(String[] args) {
        var inputPath = "D:\\GitHub\\Softuni-Java-Track\\Java Advanced\\Streams Files and Directories\\StreamsFilesDirectorios\\src\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\input.txt";

        try {
            var lines = Files.readAllLines(Path.of(inputPath));
            Collections.sort(lines);
            System.out.println(String.join("\n", lines));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}