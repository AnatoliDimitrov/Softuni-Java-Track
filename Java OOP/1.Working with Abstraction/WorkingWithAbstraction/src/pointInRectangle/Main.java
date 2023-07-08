package pointInRectangle;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        var points = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        var rectangle = new Rectangle(points[0], points[1], points[2], points[3]);

        var n = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < n; i++) {
            var pointData = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            var point = new Point(pointData[0], pointData[1]);

            System.out.println(rectangle.contains(point));
        }
    }
}