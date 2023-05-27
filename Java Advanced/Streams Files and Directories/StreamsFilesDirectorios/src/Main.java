import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        var path = "D:\\GitHub\\Softuni-Java-Track\\Java Advanced\\Streams Files and Directories\\StreamsFilesDirectorios\\src\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\input.txt";
        try(FileInputStream reader = new FileInputStream(path)){
            var data = reader.read();
            while(data >= 0){
                System.out.print(Integer.toBinaryString(data) + " ");

                data = reader.read();
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}