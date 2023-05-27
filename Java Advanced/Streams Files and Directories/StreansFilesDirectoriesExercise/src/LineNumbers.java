import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class LineNumbers {
    private static Integer current = 1;
    public static void main(String[] args) {
        var inputPath = "D:\\GitHub\\Softuni-Java-Track\\Java Advanced\\Streams Files and Directories\\StreansFilesDirectoriesExercise\\src\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\inputLineNumbers.txt";

        try {
            List<String> lines = Files.readAllLines(Path.of(inputPath));
            lines.forEach(line -> System.out.println((current++) + ". " + line));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}