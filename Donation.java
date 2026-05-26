import java.time.LocalDate;

public abstract class Donation implements Comparable<Donation>, TaxDeductible {
    private static int counter = 1;
    private int id;
    private String donorName;
    private LocalDate date;

    public Donation(String donorName, LocalDate date) {
        this.id = counter++;
        this.donorName = donorName;
        this.date = date;
    }

    public int getId() { return id; }
    public String getDonorName() { return donorName; }
    public LocalDate getDate() { return date; }

    public abstract double getValue();

    @Override
    public int compareTo(Donation other) {
        return Double.compare(other.getValue(), this.getValue());
    }

    @Override
    public String toString() {
        return "ID: " + id + " | Donor: " + donorName + " (" + date + ")";
    }
}