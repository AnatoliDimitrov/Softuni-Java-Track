import java.io.*;

public class SumBytes {
    public static void main(String[] args) {
        var inputPath = "D:\\GitHub\\Softuni-Java-Track\\Java Advanced\\Streams Files and Directories\\StreansFilesDirectoriesExercise\\src\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\input.txt";
        var outputPath = "D:\\GitHub\\Softuni-Java-Track\\Java Advanced\\Streams Files and Directories\\StreansFilesDirectoriesExercise\\src\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\output.txt";

        try(var reader = new InputStreamReader(new FileInputStream(inputPath));
            var writer = new PrintWriter(new FileWriter(outputPath))) {
            var bytes = 0L;
            var data = reader.read();
            while (data >= 0) {
                if (data != 10 && data != 13) {
                    bytes += data;
                }
                data = reader.read();
            }
            writer.println(bytes);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}