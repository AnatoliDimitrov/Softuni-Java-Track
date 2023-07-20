package jediGalaxy;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] dimension = Arrays.stream(scanner.nextLine()
                        .split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        Galaxy galaxy = new Galaxy(dimension[0], dimension[1]);
        StarsManipulator starsManipulator = new StarsManipulator(galaxy);

        String input = scanner.nextLine();
        long sum = 0;

        while (!input.equals("Let the Force be with you")) {
            int[] playerPositions = Arrays.stream(input.split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            int[] enemyPositions = Arrays.stream(scanner.nextLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();

            starsManipulator.destroyStars(enemyPositions);
            sum += starsManipulator.sumOfStars(playerPositions);

            input = scanner.nextLine();
        }
        System.out.println(sum);
    }
}