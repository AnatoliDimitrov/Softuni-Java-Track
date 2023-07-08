package firstAndReserveTeam;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        var team = new Team("Black Eagles");

        var n = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < n; i++) {
            var data = scanner.nextLine().split(" ");
            var firstName = data[0];
            var lastName = data[1];
            var age = Integer.parseInt(data[2]);
            var salary = Double.parseDouble(data[3]);

            try {
                var person = new Person(firstName, lastName, age, salary);
                team.addPlayer(person);
            } catch (Exception e){
                System.out.println(e.getMessage());
            }
        }

        System.out.println("First team have " + team.getFirstTeam().size() + " players");
        System.out.println("Reserve team have " + team.getReserveTeam().size() + " players");
    }
}