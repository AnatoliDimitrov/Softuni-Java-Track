package cardSuit;

import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner reader = new Scanner(System.in);

        CardSuits[] cards = CardSuits.values();

        System.out.println(reader.nextLine() + ":");

        for (CardSuits card : cards) {
            System.out.println(String.format("Ordinal value: %d; Name value: %s",
                    card.ordinal(), card.name()));
        }
    }
}