package cardsWithPower;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);

        String rank = scanner.nextLine();
        String suit = scanner.nextLine();

        System.out.println(String.format("Card name: %s of %s; Card power: %d",
                RankPowers.valueOf(rank), SuitPowers.valueOf(suit),
                RankPowers.valueOf(rank).getValue() + SuitPowers.valueOf(suit).getValue()
        ));
    }
}