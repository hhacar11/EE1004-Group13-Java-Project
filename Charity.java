import java.util.ArrayList;
import java.util.HashMap;
import java.util.Collections;

public class Charity {
    private String charityName;
    private ArrayList<Donation> donations = new ArrayList<>();
    private HashMap<Integer, Donation> donationById = new HashMap<>();

    public Charity(String charityName) {
        this.charityName = charityName;
    }

    public void recordDonation(Donation d) {
        donations.add(d);
        donationById.put(d.getId(), d);
        System.out.println("Donation recorded. ID: " + d.getId());
    }

    public void listAllDonations() {
        for (Donation d : donations) System.out.println(d);
    }

    public void listSortedByValue() {
        ArrayList<Donation> sortedList = new ArrayList<>(donations);
        Collections.sort(sortedList);
        System.out.println("===== Sorted by Value (high -> low) =====");
        for (Donation d : sortedList) System.out.println(d);
    }

    public Donation findById(int id) {
        return donationById.get(id);
    }

    public double getTotalTaxDeductible() {
        double total = 0;
        for (Donation d : donations) {
            total += d.getTaxDeductibleAmount();
        }
        return total;
    }
}