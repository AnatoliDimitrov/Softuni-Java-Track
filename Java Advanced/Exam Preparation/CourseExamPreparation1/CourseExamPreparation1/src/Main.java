import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, Integer> toys = new LinkedHashMap<>();

        toys.put("Bicycle", 0);
        toys.put("Doll", 0);
        toys.put("Teddy bear", 0);
        toys.put("Wooden train", 0);

        ArrayDeque<Integer> materialsStack = new ArrayDeque<>();
        ArrayDeque<Integer> magicQueue = new ArrayDeque<>();

        Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).forEach(materialsStack::push);
        Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).forEach(magicQueue::offer);

        while (!materialsStack.isEmpty() && !magicQueue.isEmpty()){
            var sum = materialsStack.peek() * magicQueue.peek();
            if(materialsStack.peek() == 0 || magicQueue.peek() == 0){
                if (materialsStack.peek() == 0){
                    materialsStack.pop();
                }
                if (magicQueue.peek() == 0){
                    magicQueue.poll();
                }
                continue;
            }
            var toyCreated =  false;
            if (sum == 150){
                toys.put("Doll", toys.get("Doll") + 1);
                toyCreated = true;
            }
            if (sum == 250){
                toys.put("Wooden train", toys.get("Wooden train") + 1);
                toyCreated = true;
            }
            if (sum == 300){
                toys.put("Teddy bear", toys.get("Teddy bear") + 1);
                toyCreated = true;
            }
            if (sum == 400){
                toys.put("Bicycle", toys.get("Bicycle") + 1);
                toyCreated = true;
            }
            if (sum < 0){
                materialsStack.push(materialsStack.pop() + magicQueue.poll());
            } else if (sum >= 0 && !toyCreated) {
                magicQueue.poll();
                materialsStack.push(materialsStack.pop() + 15);
            }

            if (toyCreated){
                materialsStack.pop();
                magicQueue.poll();
            }
        }

        var result = "No presents this Christmas!";
        if(toys.get("Doll") > 0 && toys.get("Wooden train") > 0){
            result = "The presents are crafted! Merry Christmas!";
        } else if(toys.get("Bicycle") > 0 && toys.get("Teddy bear") > 0){
            result = "The presents are crafted! Merry Christmas!";
        }

        System.out.println(result);

        if(!materialsStack.isEmpty()){
            System.out.println("Materials left: " + materialsStack.stream().map(e -> e + "").collect(Collectors.joining(", ")));
        }

        if (!magicQueue.isEmpty()){
            System.out.println("Magic left: " + magicQueue.stream().map(e -> e + "").collect(Collectors.joining(", ")));
        }

        for (var entry:toys.entrySet()) {
            if (entry.getValue() > 0){
                System.out.println(entry.getKey() + ": " + entry.getValue());
            }
        }
    }
}