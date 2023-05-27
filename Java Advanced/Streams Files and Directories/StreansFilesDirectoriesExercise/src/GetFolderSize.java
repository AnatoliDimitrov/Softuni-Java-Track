import java.io.File;

public class GetFolderSize {
    static int count = 0;
    public static void main(String[] args) {
        var path = "D:\\GitHub\\Softuni-Java-Track\\Java Advanced\\Streams Files and Directories\\StreansFilesDirectoriesExercise\\src\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\Exercises Resources";
        var file = new File(path);

        dfs(file);
        System.out.println("Folder size: " + count);
    }

    private static void dfs(File file) {
        if (!file.isDirectory()) {
            count += file.length();
            return;
        }

        var files = file.listFiles();
        for (File f : files) {
            dfs(f);
        }
    }
}