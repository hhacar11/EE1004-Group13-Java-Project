import java.time.LocalDate;

public class MoneyDonation extends Donation {
    private double amountTL;

    public MoneyDonation(String donorName, LocalDate date, double amountTL) {
        super(donorName, date);
        this.amountTL = amountTL;
    }

    @Override
    public double getValue() { return amountTL; }

    @Override
    public double getTaxDeductibleAmount() { return getValue() * 1.0; }

    @Override
    public String toString() {
        return super.toString() + " [Money] - " + String.format("%.2f", amountTL) + " TL | Value: " + String.format("%.2f", getValue()) + " TL";
    }
}