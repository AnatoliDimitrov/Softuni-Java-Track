import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;

public class WordCount {
    public static void main(String[] args) {
        var searchWordsPath = "D:\\GitHub\\Softuni-Java-Track\\Java Advanced\\Streams Files and Directories\\StreansFilesDirectoriesExercise\\src\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\words.txt";
        Map<String, Integer> count = new LinkedHashMap<>();
        var inputPath = "D:\\GitHub\\Softuni-Java-Track\\Java Advanced\\Streams Files and Directories\\StreansFilesDirectoriesExercise\\src\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\text.txt";

        try {
            var lines = Files.readAllLines(Path.of(searchWordsPath));
            lines.forEach(line -> Arrays.stream(line.split("\\s+")).forEach(word -> count.put(word, 0)));

            var linesText = Files.readAllLines(Path.of(inputPath));
            linesText.forEach(line -> Arrays.stream(line.split("\\s+")).forEach(word -> {
                if (count.containsKey(word)) {
                    count.put(word, count.get(word) + 1);
                }
            }));

            count.entrySet().stream().sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                    .forEach(e -> System.out.printf("%s - %d%n", e.getKey(), e.getValue()));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}