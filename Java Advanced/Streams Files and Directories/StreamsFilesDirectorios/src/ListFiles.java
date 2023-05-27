import java.io.File;

public class ListFiles {
    public static void main(String[] args) {
        var inputPath = "D:\\GitHub\\Softuni-Java-Track\\Java Advanced\\Streams Files and Directories\\StreamsFilesDirectorios\\src\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\Files-and-Streams";

        var folder = new File(inputPath);
        File[] files = folder.listFiles();

        if (files == null) return;

        for (var file : files) {
            if (file.isFile()) {
                System.out.println(String.format("%s: [%d]", file.getName(), file.length()));
            }
        }
    }
}