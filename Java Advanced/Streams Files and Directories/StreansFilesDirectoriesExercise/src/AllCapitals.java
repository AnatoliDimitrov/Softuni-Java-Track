import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class AllCapitals {
    public static void main(String[] args) {
        var path = "D:\\GitHub\\Softuni-Java-Track\\Java Advanced\\Streams Files and Directories\\StreansFilesDirectoriesExercise\\src\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\input.txt";
        try {
            var lines = Files.readAllLines(Path.of(path));
            lines.forEach(line -> System.out.println(line.toUpperCase()));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}