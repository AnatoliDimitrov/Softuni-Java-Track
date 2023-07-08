package hotelReservation;

public enum Discounts {
    VIP(20),
    SecondVisit(10),
    None(0);

    private Double discount;
    Discounts(double discount) {
        this.discount = discount;
    }

    public Double getDiscount() {
        return discount;
    }
}