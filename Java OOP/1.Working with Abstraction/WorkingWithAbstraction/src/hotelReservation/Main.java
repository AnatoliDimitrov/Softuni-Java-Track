package hotelReservation;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        var data = scanner.nextLine().split(" ");

        var price = Double.parseDouble(data[0]);
        var days = Integer.parseInt(data[1]);
        var season = data[2];
        var discount = data[3];

        System.out.printf("%.2f", PriceCalculator.calculatePrice(price, days, season, discount));
    }
}