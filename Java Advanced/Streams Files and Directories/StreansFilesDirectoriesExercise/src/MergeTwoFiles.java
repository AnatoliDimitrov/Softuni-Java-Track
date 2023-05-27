import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;

public class MergeTwoFiles  {
    public static void main(String[] args) {
        var inputOnePath = "D:\\GitHub\\Softuni-Java-Track\\Java Advanced\\Streams Files and Directories\\StreansFilesDirectoriesExercise\\src\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\inputOne.txt";
        var inputTwoPath = "D:\\GitHub\\Softuni-Java-Track\\Java Advanced\\Streams Files and Directories\\StreansFilesDirectoriesExercise\\src\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\inputTwo.txt";
        var outputPath = "D:\\GitHub\\Softuni-Java-Track\\Java Advanced\\Streams Files and Directories\\StreansFilesDirectoriesExercise\\src\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\output.txt";


        try (PrintWriter writer = new PrintWriter(new FileWriter(outputPath));){
            var firstLines = Files.readAllLines(Path.of(inputOnePath));
            var secondLines = Files.readAllLines(Path.of(inputTwoPath));

            firstLines.forEach(l -> writer.println(l));
            secondLines.forEach(l -> writer.println(l));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}