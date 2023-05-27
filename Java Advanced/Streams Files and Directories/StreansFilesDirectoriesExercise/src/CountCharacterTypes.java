import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class CountCharacterTypes {
    private static Set<Character> vowels = Set.of('a', 'e', 'i', 'o', 'u');
    private static Set<Character> punctuations = Set.of('(', ')', ',', '.', '?');
    private static Integer vowelsCount = 0;
    private static Integer punctuationsCount = 0;
    private static Integer consonantsCount = 0;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        var inputPath = "D:\\GitHub\\Softuni-Java-Track\\Java Advanced\\Streams Files and Directories\\StreansFilesDirectoriesExercise\\src\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\input.txt";
        var outputPat = "D:\\GitHub\\Softuni-Java-Track\\Java Advanced\\Streams Files and Directories\\StreansFilesDirectoriesExercise\\src\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\output.txt";

        try (PrintWriter writer = new PrintWriter(new FileWriter(outputPat))){
            List<String> lines = Files.readAllLines(Path.of(inputPath));
            lines.forEach(line -> {
                for (char c : line.toCharArray()) {
                    if (vowels.contains(c)) {
                        vowelsCount++;
                    } else if (punctuations.contains(c)) {
                        punctuationsCount++;
                    } else if (c != ' ') {
                        consonantsCount++;
                    }
                }
            });
            writer.printf("Vowels: %d%nOther symbols: %d%nPunctuation: %d%n", vowelsCount, consonantsCount, punctuationsCount);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}