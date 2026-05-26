import java.time.LocalDate;

public class FoodDonation extends Donation {
    private double kilograms;

    public FoodDonation(String donorName, LocalDate date, double kilograms) {
        super(donorName, date);
        this.kilograms = kilograms;
    }

    @Override
    public double getValue() { return kilograms * 80.0; }

    @Override
    public double getTaxDeductibleAmount() { return getValue() * 0.6; }

    @Override
    public String toString() {
        return super.toString() + " [Food] - " + kilograms + " kg | Value: " + String.format("%.2f", getValue()) + " TL";
    }
}