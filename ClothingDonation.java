import java.time.LocalDate;

public class ClothingDonation extends Donation {
    private int itemCount;

    public ClothingDonation(String donorName, LocalDate date, int itemCount) {
        super(donorName, date);
        this.itemCount = itemCount;
    }

    @Override
    public double getValue() { return itemCount * 150.0; }

    @Override
    public double getTaxDeductibleAmount() { return getValue() * 0.5; }

    @Override
    public String toString() {
        return super.toString() + " [Clothing] - " + itemCount + " items | Value: " + String.format("%.2f", getValue()) + " TL";
    }
}