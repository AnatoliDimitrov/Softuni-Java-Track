package calculator;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        CalculationEngine engine = new CalculationEngine();
        InputInterpreter interpreter = Extensions.buildInterpreter(engine);
        String[] input = scanner.nextLine().split("\\s+");

        Arrays.stream(input).takeWhile(element -> !element.equals("end")).forEach(interpreter::interpret);

        System.out.println(engine.getCurrentResult());
    }
}