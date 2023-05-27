import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;

public class CopyBytes {
    public static void main(String[] args) {
        var inputPath = "D:\\GitHub\\Softuni-Java-Track\\Java Advanced\\Streams Files and Directories\\StreamsFilesDirectorios\\src\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\input.txt";
        var outputPath = "D:\\GitHub\\Softuni-Java-Track\\Java Advanced\\Streams Files and Directories\\StreamsFilesDirectorios\\src\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\output.txt";

        var punctuations = Arrays.asList(' ', '\n');

        try(FileInputStream reader = new FileInputStream(inputPath); FileOutputStream writer = new FileOutputStream(outputPath)){
            var data = reader.read();
            while(data >= 0){
                if (punctuations.contains((char) data)){
                    writer.write(data);
                } else {
                    String digits = String.valueOf(data);

                    for (int i = 0; i < digits.length(); i++) {
                        writer.write(digits.charAt(i));
                    }
                }
                data = reader.read();
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}