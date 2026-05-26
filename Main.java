import java.time.LocalDate;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter charity name: ");
        Charity myCharity = new Charity(scanner.nextLine());

        while (true) {
            System.out.println("\n--- Charity Menu ---");
            System.out.println("1. Record a money donation\n2. Record a food donation\n3. Record a clothing donation");
            System.out.println("4. List all donations\n5. List sorted by value\n6. Find donation by ID");
            System.out.println("7. Show total tax-deductible amount\n8. Exit");
            System.out.print("Choose an option (1-8): ");

            String choice = scanner.nextLine();
            if (choice.equals("8")) break;

            try {
                switch (choice) {
                    case "1": case "2": case "3":
                        System.out.print("Donor name: ");
                        String name = scanner.nextLine();
                        System.out.print("Date (yyyy-mm-dd): ");
                        LocalDate date = LocalDate.parse(scanner.nextLine());

                        if (choice.equals("1")) {
                            System.out.print("Amount (TL): ");
                            double amt = Double.parseDouble(scanner.nextLine());
                            myCharity.recordDonation(new MoneyDonation(name, date, amt));
                        } else if (choice.equals("2")) {
                            System.out.print("Weight (kg): ");
                            double w = Double.parseDouble(scanner.nextLine());
                            myCharity.recordDonation(new FoodDonation(name, date, w));
                        } else {
                            System.out.print("Item count: ");
                            int count = Integer.parseInt(scanner.nextLine());
                            myCharity.recordDonation(new ClothingDonation(name, date, count));
                        }
                        break;

                    case "4":
                        myCharity.listAllDonations();
                        break;
                    case "5":
                        myCharity.listSortedByValue();
                        break;
                    case "6":
                        System.out.print("Enter donation ID: ");
                        int id = Integer.parseInt(scanner.nextLine());
                        Donation d = myCharity.findById(id);
                        if (d != null) {
                            System.out.println(d);
                            System.out.printf("Value: %.2f TL | Tax-Deductible: %.2f TL\n", d.getValue(), d.getTaxDeductibleAmount());
                        } else {
                            System.out.println("No donation found with that ID.");
                        }
                        break;
                    case "7":
                        System.out.println("===== Tax-Deductible Summary =====");
                        System.out.printf("Total Tax-Deductible Amount: %.2f TL\n", myCharity.getTotalTaxDeductible());
                        break;
                    default:
                        System.out.println("Unknown option. Skipping...");
                }
            } catch (Exception e) {
                System.out.println("Error: Invalid input format. Please try again.");
            }
        }
        System.out.println("Exiting. Goodbye!");
    }
}