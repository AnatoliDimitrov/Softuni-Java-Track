package animals;

import java.util.*;

public class Main {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        List<Animal> animalsInfo = new ArrayList<>();
        String animalType;

        while (!"Beast!".equals(animalType = scan.nextLine())) {

            String[] input = scan.nextLine().split("\\s+");
            String name = input[0];
            int age = Integer.parseInt(input[1]);
            String gender = input[2];
            try {
                switch (animalType) {
                    case "Dog" -> animalsInfo.add(new Dog(name, age, gender));
                    case "Cat" -> animalsInfo.add(new Cat(name, age, gender));
                    case "Frog" -> animalsInfo.add(new Frog(name, age, gender));
                    case "Kitten" -> animalsInfo.add(new Kitten(name, age));
                    case "Tomcat" -> animalsInfo.add(new Tomcat(name, age));
                }
            }catch (Exception exception){
                System.out.println(exception.getMessage());
            }
        }
        animalsInfo.forEach(System.out::println);
    }
}