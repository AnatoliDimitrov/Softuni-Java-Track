import java.util.*;

public class AcademyGraduation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, Double[]> students = new TreeMap<>();

        var counter = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < counter; i++) {
            String name = scanner.nextLine();
            String[] scoresStrings = scanner.nextLine().split(" ");
            Double[] scores = new Double[scoresStrings.length];

            for (int j = 0; j < scoresStrings.length; j++) {
                scores[j] = Double.parseDouble(scoresStrings[j]);
            }
            students.put(name, scores);
        }

//        for (int i = 0; i < counter; i++) {
//            var name = scanner.nextLine();
//            var grades = Arrays.stream(scanner.nextLine().split("\\s+"))
//                    .mapToDouble(Double::parseDouble)
//                    .toArray();
//            var sum = 0.0;
//            for (int j = 0; j < grades.length; j++) {
//                sum += grades[i];
//            }
//            var average = sum / grades.length;
//
//            if (!students.containsKey(name)){
//                students.put(name, average);
//            }
//        }

        students.forEach((name, scores) -> {
            var sum = 0.0;
            for (int i = 0; i < scores.length; i++) {
                sum += scores[i];
            }
            System.out.println(name + " is graduated with " + sum / scores.length);
        });
    }
}