package PokemonTrainer;

import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    private static Scanner scanner = new Scanner(System.in);
    private static Map<String, Trainer> trainers = new LinkedHashMap<>();

    public static void main(String[] args) throws IOException {

        getPokemons();

        String line;
        while (!"End".equals(line = scanner.nextLine())) {
            String element = line;
            trainers.values().forEach(trainer -> trainer.processElement(element));
        }
        trainers.values()
                .stream()
                .sorted(Trainer::compareTo)
                .forEach(System.out::println);
    }

    private static void getPokemons() throws IOException {
        String input;
        while (!"Tournament".equals(input = scanner.nextLine())) {
            String[] tokens = input.split(" ");

            String trainer = tokens[0];
            String pokemonName = tokens[1];
            String element = tokens[2];
            int health = Integer.parseInt(tokens[3]);

            trainers.putIfAbsent(trainer, new Trainer(trainer));
            trainers.get(trainer).add(new Pokemon(pokemonName, element, health));

        }
    }
}