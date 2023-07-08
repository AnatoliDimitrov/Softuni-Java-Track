package hotelReservation;

public class PriceCalculator {
    public static double calculatePrice(double price, int days, String season, String discount){
        var totalPrice = 0.0;
        var currentDiscount = (100 - Discounts.valueOf(discount).getDiscount());
        currentDiscount /= 100.0;

        var pricePerDay = price * Seasons.valueOf(season).getMultiplier();
        totalPrice = (pricePerDay * (double) days) * currentDiscount;

        return totalPrice;
    }

}