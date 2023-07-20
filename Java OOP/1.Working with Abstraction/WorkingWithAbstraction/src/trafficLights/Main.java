package trafficLights;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Light[] lights = Arrays.stream(scanner.nextLine()
                        .split(" "))
                .map(signal -> new Light(Signal.valueOf(signal)))
                .toArray(Light[]::new);

        int numberOfLightChanges = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < numberOfLightChanges; i++) {
            for (Light light : lights) {
                light.changeSignal();
                System.out.print(light + " ");
            }
            System.out.println();
        }
    }
}