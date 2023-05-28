package P1_RubberDuck;

import java.util.ArrayDeque;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        var timeInfo = scanner.nextLine().split("\\s+");
        var taskInfo = scanner.nextLine().split("\\s+");

        ArrayDeque<Integer> timesQueue = new ArrayDeque<>();
        ArrayDeque<Integer> tasksStack = new ArrayDeque<>();
        Map<String, Integer> duckies = new LinkedHashMap<>();
        duckies.put("Darth Vader Ducky", 0);
        duckies.put("Thor Ducky", 0);
        duckies.put("Big Blue Rubber Ducky", 0);
        duckies.put("Small Yellow Rubber Ducky", 0);

        for (int i = 0; i < timeInfo.length; i++) {
            timesQueue.offer(Integer.parseInt(timeInfo[i]));
            tasksStack.push(Integer.parseInt(taskInfo[i]));
        }

        while (!tasksStack.isEmpty()){
            var result = timesQueue.peek() * tasksStack.peek();
            if(result <= 60){
                duckies.put("Darth Vader Ducky", duckies.get("Darth Vader Ducky") + 1);
                timesQueue.poll();
                tasksStack.pop();
            } else if (result <= 120) {
                duckies.put("Thor Ducky", duckies.get("Thor Ducky") + 1);
                timesQueue.poll();
                tasksStack.pop();
            } else if (result <= 180) {
                duckies.put("Big Blue Rubber Ducky", duckies.get("Big Blue Rubber Ducky") + 1);
                timesQueue.poll();
                tasksStack.pop();
            } else if (result <= 240) {
                duckies.put("Small Yellow Rubber Ducky", duckies.get("Small Yellow Rubber Ducky") + 1);
                timesQueue.poll();
                tasksStack.pop();
            } else {
                tasksStack.push(tasksStack.pop() - 2);
                timesQueue.offer(timesQueue.poll());
            }
        }
        System.out.println("Congratulations, all tasks have been completed! Rubber ducks rewarded:");
        duckies.forEach((k, v) -> {
            System.out.println(k + ": " + v);
        });
    }
}