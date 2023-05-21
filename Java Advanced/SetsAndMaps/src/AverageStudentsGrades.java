import java.util.*;

public class AverageStudentsGrades {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, List<Double>> students = new TreeMap<>();

        int counter = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < counter; i++) {
            var info = scanner.nextLine().split("\\s+");
            var name = info[0];
            var grade = Double.parseDouble(info[1]);

            if (!students.containsKey(name)) {
                students.put(name, new ArrayList<Double>());
            }
            students.get(name).add(grade);
        }

        for (var student:students.entrySet()) {
            Double sum = 0.0;

            for (int i = 0; i < student.getValue().size(); i++) {
                sum += student.getValue().get(i);
            }

            Double average = sum / student.getValue().size();

            System.out.print(student.getKey() + " -> ");
            student.getValue().forEach(g -> System.out.printf("%.2f ", g));
            System.out.printf("(avg: %.2f)\n",average);
        }
    }
}